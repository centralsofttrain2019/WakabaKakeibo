package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import bean.HistoryListBean;
import bean.ReconstructListBean;
import dao.Dao;
import dao.MoneyNotesDao;
import dao.PurchasePatternsDao;
import domain.MoneyNoteTypeEnum;
import dto.MoneyNotesDto;
import dto.PurchasePatternsDto;

public class MoneyNotesService
{
	public HistoryListBean findAllHistoryList(int userID)
	{
		HistoryListBean bean = new HistoryListBean();
		//オートクローズ
		try( Connection con= Dao.getConnection() )
		{
			MoneyNotesDao dao = new MoneyNotesDao(con);
			List<MoneyNotesDto> historyList = dao.findByUserIDWithIDName(userID);

			bean.setValueFromDto(historyList);

		}
		catch( SQLException | ClassNotFoundException e )
		{
			e.printStackTrace();
			throw new RuntimeException( e );
		}
		return bean;
	}


	public ReconstructListBean getReconstructListBean(int userID)
	{
		ReconstructListBean bean = new ReconstructListBean();
		try( Connection con= Dao.getConnection() )
		{
			//今日の日付を取得
			LocalDate today = LocalDate.now();

			//家計簿（全部の）データをテーブルから取得
			MoneyNotesDao mnDao = new MoneyNotesDao(con);
			List<MoneyNotesDto> mnList = mnDao.findByDate(userID,today.minusDays(6),today);

			System.out.println(mnList.toString());

			//購入パターンをテーブルから取得
			PurchasePatternsDao ppDao = new PurchasePatternsDao(con);
			List<PurchasePatternsDto> ppList = ppDao.findByUserID(userID);

			System.out.println(ppList.toString());

			List<MoneyNotesDto> reconsList = createReconstructList(mnList,ppList,today);

			bean.setValueFromDto(mnList, reconsList, today);
		}
		catch( SQLException | ClassNotFoundException e )
		{
			e.printStackTrace();
			throw new RuntimeException( e );
		}
		return bean;
	}

	//家計簿の復元予想した後のデータを作成する
	public List<MoneyNotesDto> createReconstructList(List<MoneyNotesDto> mnList, List<PurchasePatternsDto> ppList, LocalDate today)
	{
		//復元すべき商品リスト
		List<MoneyNotesDto> reconsList = new ArrayList<MoneyNotesDto>();
		int intervalDays = 0;

		for(PurchasePatternsDto pp: ppList)
		{

			LocalDate lastDay = pp.getLastPurchaseDate();
			LocalDate nextDay = null;

			switch(pp.getDatePatternType()) {
			case ONEWEEK:
				nextDay = lastDay.plusDays(7);
				intervalDays = 7;
				break;
			case TWOWEEKS:
				nextDay = lastDay.plusDays(14);
				intervalDays = 14;
				break;
			case THREEWEEKS:
				nextDay = lastDay.plusDays(21);
				intervalDays = 21;
				break;
			}


			if(nextDay.isAfter(today.minusDays(7)) && nextDay.isBefore(today.plusDays(1)))
			{
				System.out.println("Pattern : "+ pp.getProductName());
				MoneyNotesDto reconsData = new MoneyNotesDto(
						0,  //インサート時に自動採番させる
						pp.getUserID(),
						nextDay,
						MoneyNoteTypeEnum.EXPENSE,
						pp.getProductID(),
						pp.getProductName(),
						pp.getProductID()/100 ,
						pp.getNumberPattern(),
						pp.getAmountPattern(),
						intervalDays,
						"" //カテゴリー名は必要ない
						);
				reconsList.add(reconsData);
			}
		}

		return reconsList;
	}

}
