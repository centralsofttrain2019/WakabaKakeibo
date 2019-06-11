package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import bean.HistoryListBean;
import dao.Dao;
import dao.MoneyNotesDao;
import dto.MoneyNotesDto;

public class MoneyNotesService
{
	public HistoryListBean findAll()
	{
		HistoryListBean bean = new HistoryListBean();
		//オートクローズ
				try( Connection con= Dao.getConnection() )
				{
					MoneyNotesDao dao = new MoneyNotesDao(con);
					List<MoneyNotesDto> historyList = dao.selectAll();

				}
				catch( SQLException | ClassNotFoundException e )
				{
					e.printStackTrace();
					throw new RuntimeException( e );
				}


				return bean;

	}



}
