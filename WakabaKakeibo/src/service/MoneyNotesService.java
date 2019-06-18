package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import bean.HistoryListBean;
import bean.ReconstructListBean;
import dao.Dao;
import dao.MoneyNotesDao;
import dao.PurchasePatternsDao;
import domain.DatePatternTypeEnum;
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

			//購入パターンをテーブルから取得
			PurchasePatternsDao ppDao = new PurchasePatternsDao(con);
			List<PurchasePatternsDto> ppList = ppDao.findByUserID(userID);


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
	private List<MoneyNotesDto> createReconstructList(List<MoneyNotesDto> mnList, List<PurchasePatternsDto> ppList, LocalDate today)
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
				if(nextDay.isBefore(today.minusDays(6)))
				{
					nextDay = lastDay.plusDays(14);
					intervalDays = 14;
					if(nextDay.isBefore(today.minusDays(6)))
					{
						nextDay = lastDay.plusDays(21);
						intervalDays = 21;
					}
				}
				break;
			case TWOWEEKS:
				nextDay = lastDay.plusDays(14);
				intervalDays = 14;
				if(nextDay.isBefore(today.minusDays(6)))
				{
					nextDay = lastDay.plusDays(21);
					intervalDays = 21;
				}
				break;
			case THREEWEEKS:
				nextDay = lastDay.plusDays(21);
				intervalDays = 21;
				break;
			}

			if(nextDay.isAfter(today.minusDays(7)) && nextDay.isBefore(today.plusDays(1)))
			{
				MoneyNotesDto reconsData = new MoneyNotesDto(
						0,  //インサート時に自動採番させる
						pp.getUserID(),
						nextDay,
						MoneyNoteTypeEnum.EXPENSE,
						pp.getProductID(),
						pp.getProductName(), //商品名は必要ない
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

	//ユーザID、商品名、個数、価格から家計簿データを作成する
	public void insertMoneyNotes(int userID ,String productName, int number, int amount, LocalDate purchaseDate)
	{
		MoneyNotesDto dto = new MoneyNotesDto();
		dto.setUserID(userID);
		dto.setPurchaseDate(purchaseDate);
		dto.setType(MoneyNoteTypeEnum.EXPENSE);

		dto.setNumberOfPurchase(number);
		dto.setAmount(amount);

		try( Connection con= Dao.getConnection() )
		{
			MoneyNotesDao dao = new MoneyNotesDao(con);
			int productID = dao.findProductID(productName);
			dto.setProductID(productID);
			dto.setCategoryID(dao.getCategoryID(productID));
			dto.setPurchaseIntervalDays((int)ChronoUnit.DAYS.between(dao.getLastPurchaseDate(userID, productID), purchaseDate));
			dao.insertMoneyNotes(dto);

			updatePatternTable(userID, productID,purchaseDate );
		}
		catch( SQLException | ClassNotFoundException e )
		{
			e.printStackTrace();
			throw new RuntimeException( e );
		}
	}

	private void updatePatternTable(int userID, int productID, LocalDate lastPurchaseDate)
	{
		PurchasePatternsDto dto = checkDatePattern(userID, productID);


		try( Connection con= Dao.getConnection() )
		{
			PurchasePatternsDao dao = new PurchasePatternsDao(con);

			if(dto.getDatePatternType() == DatePatternTypeEnum.OUTOFPTTERN)
			{
				dao.deleteData(userID, productID);
			}else
			{
				dao.updateData(userID, productID, dto.getDatePatternType() , lastPurchaseDate, dto.getAmountPattern(), dto.getNumberPattern());
			}
		}
		catch( SQLException | ClassNotFoundException e )
		{
			e.printStackTrace();
			throw new RuntimeException( e );
		}
	}

	//過去12週間のデータを取得し購入パターンを作成する
	public void createPatternTable(int userID)
	{
		LocalDate today = LocalDate.now();
		List<Integer> idList;

		try( Connection con= Dao.getConnection() )
		{
			MoneyNotesDao mnDao = new MoneyNotesDao(con);
			idList = mnDao.getProductIDsByDate(userID, today, today.minusWeeks(3));
		}
		catch( SQLException | ClassNotFoundException e )
		{
			e.printStackTrace();
			throw new RuntimeException( e );
		}

		for(int id : idList)
		{
			PurchasePatternsDto dto = checkDatePattern(userID, id);
			if(dto.getDatePatternType() != DatePatternTypeEnum.OUTOFPTTERN)
			{
				insertPurchasePattern(dto);
			}
		}
	}

	//同じ商品が3回連続で登場した場合は間隔によってパターンのデータを作成
	private PurchasePatternsDto checkDatePattern(int userID, int productID)
	{
		List<MoneyNotesDto> dtoList;
		try( Connection con= Dao.getConnection() )
		{
			MoneyNotesDao mnDao = new MoneyNotesDao(con);
			dtoList = mnDao.findByProductIDWithSorted(userID, productID);
		}
		catch( SQLException | ClassNotFoundException e )
		{
			e.printStackTrace();
			throw new RuntimeException( e );
		}

		int maxIntervalDate =0;
		int count =0;

		//最初はパターン外として設定
		PurchasePatternsDto dto = new PurchasePatternsDto();
		dto.setDatePatternType(DatePatternTypeEnum.OUTOFPTTERN);
		dto.setUserID(userID);
		dto.setProductID(productID);

		for(MoneyNotesDto mnd : dtoList)
		{
			count++;
			if(count ==1)
			{
				dto.setLastPurchaseDate(mnd.getPurchaseDate());
				dto.setNumberPattern(mnd.getNumberOfPurchase());
				dto.setAmountPattern(mnd.getAmount());
			}
			else if(count==3) {
				if(maxIntervalDate <=7)
				{
					dto.setDatePatternType(DatePatternTypeEnum.ONEWEEK);
				}
				else if(maxIntervalDate <= 14)
				{
					dto.setDatePatternType(DatePatternTypeEnum.TWOWEEKS);
				}
				else if(maxIntervalDate <= 21)
				{
					dto.setDatePatternType(DatePatternTypeEnum.THREEWEEKS);
				}
			}
			maxIntervalDate = mnd.getPurchaseIntervalDays() > maxIntervalDate
					? mnd.getPurchaseIntervalDays() : maxIntervalDate;
		}
		return dto;
	}

	public void insertPurchasePattern(PurchasePatternsDto dto)
	{
		try( Connection con= Dao.getConnection() )
		{
			PurchasePatternsDao dao = new PurchasePatternsDao(con);
			dao.insertData(dto);
		}
		catch( SQLException | ClassNotFoundException e )
		{
			e.printStackTrace();
			throw new RuntimeException( e );
		}
	}

}
