package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.HistoryListBean;
import bean.ReconstructListBean;
import dao.Dao;
import dao.MoneyNotesDao;
import dao.PurchasePatternsDao;
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
			MoneyNotesDao mnDao = new MoneyNotesDao(con);
			List<MoneyNotesDto> mnList = mnDao.findByUserIDWithIDName(userID);

			PurchasePatternsDao ppDao = new PurchasePatternsDao(con);
			List<PurchasePatternsDto> ppList = ppDao.findByUserID(userID);

			List<MoneyNotesDto> reconsList = createReconstructList(mnList,ppList);

			bean.setValueFromDto(mnList, reconsList);
		}
		catch( SQLException | ClassNotFoundException e )
		{
			e.printStackTrace();
			throw new RuntimeException( e );
		}
		return bean;
	}

	//家計簿の復元予想した後のデータを作成する
	public List<MoneyNotesDto> createReconstructList(List<MoneyNotesDto> mnList, List<PurchasePatternsDto> ppList)
	{
		List<MoneyNotesDto> reconsList = new ArrayList<MoneyNotesDto>();
		
		for(PurchasePatternsDto pp: ppList)
		{
			 pp.getProductID();
		}

		return reconsList;
	}

}
