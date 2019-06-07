package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import bean.MoneyNotesBean;
import dao.Dao;
import dao.HistoryDao;
import dto.MoneyNotesDto;

public class KakeiboService
{
	public MoneyNotesBean findByKey()
	{
		MoneyNotesBean bean = new MoneyNotesBean();


		//オートクローズ
				try( Connection con= Dao.getConnection() )
				{
					HistoryDao dao = new HistoryDao(con);
					List<MoneyNotesDto> historyList = dao.selectAll();
					System.out.println("接続mess");

					bean.setDtoList( historyList );
				}
				catch( SQLException | ClassNotFoundException e )
				{
					e.printStackTrace();
					throw new RuntimeException( e );
				}


				return bean;

	}



}
