package service;

import java.sql.Connection;
import java.sql.SQLException;

import bean.MoneyNoteBean;
import dao.Dao;

public class KakeiboService
{
	public MoneyNoteBean findByKey()
	{
		MoneyNoteBean bean = new MoneyNoteBean();


		//オートクローズ
				try( Connection con= Dao.getConnection() )
				{
//					Dao dao = new Dao( con );
//					List<MoneyNoteBean> historyList = dao.findByKey();

					System.out.println("接続成功2");
	//				bean.setHistoryList( historyList );
				}
				catch( SQLException | ClassNotFoundException e )
				{
					e.printStackTrace();
					throw new RuntimeException( e );
				}

				return bean;

	}



}
