package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import bean.MBBean;
import bean.MBListBean;
import bean.MessageBean;
import bean.MessageListBean;
import dao.BlogsDao;
import dao.MessageDao;
import dto.MessageDto;


public class UsersService {

	public MessageListBean findAll()
	{
		MessageListBean bean = new MessageListBean();

		//オートクローズ
		try( Connection con= dao.Dao.getConnection() )
		{
			MessageDao mdao = new MessageDao(con);
			List<MessageDto> mList = mdao.selectAll();

			bean.setmDtoList(mList);

			//bean.setEmpList(eList);
			//System.out.println(mList);

//			System.out.println("従業員の情報は以下です。\n"
//								+ eList.toString()
//								);
		}
		catch( SQLException | ClassNotFoundException e )
		{
			e.printStackTrace();
			throw new RuntimeException( e );
		}

		return bean;
	}

	public MessageBean findById(int id)
	{
		MessageBean bean = new MessageBean();

		//オートクローズ
		try( Connection con= dao.Dao.getConnection() )
		{
			MessageDao mDao = new MessageDao(con);
			MessageDto mDto = mDao.findById(id);
			bean.setDto(mDto);
			//bean.setmDtoList(mList);

			//bean.setEmpList(eList);
			//System.out.println(mList);

//			System.out.println("従業員の情報は以下です。\n"
//								+ eList.toString()
//								);
		}
		catch( SQLException | ClassNotFoundException e )
		{
			e.printStackTrace();
			throw new RuntimeException( e );
		}

		return bean;
	}

	public MBListBean findAllBlog()
	{
		MBListBean bean = new MBListBean();

		//オートクローズ
		try( Connection con= dao.Dao.getConnection() )
		{
			BlogsDao bDao = new BlogsDao(con);
			List<MBBean> bList = bDao.selectAllBlog();

			bean.setbBeanList(bList);

			//bean.setEmpList(eList);
			//System.out.println(mList);

//			System.out.println("従業員の情報は以下です。\n"
//								+ eList.toString()
//								);
		}
		catch( SQLException | ClassNotFoundException e )
		{
			e.printStackTrace();
			throw new RuntimeException( e );
		}

		return bean;
	}



}
