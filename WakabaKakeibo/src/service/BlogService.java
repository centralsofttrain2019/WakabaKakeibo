package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import bean.MBCommentBean;
import bean.MBCommentListBean;
import dao.CommentDao;

public class BlogService {

	public MBCommentListBean findAllComment()
	{
		MBCommentListBean bean = new MBCommentListBean();

		//オートクローズ
		try( Connection con= dao.Dao.getConnection() )
		{
			CommentDao bDao = new CommentDao(con);
			List<MBCommentBean> bList = bDao.selectAll();

			bean.setMbCList(bList);

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

	public void innerComment(int UserID, int BLogID, Timestamp CommentDate, String Content)
	{
		//オートクローズ
		try( Connection con= dao.Dao.getConnection() )
		{
			CommentDao bDao = new CommentDao(con);
			bDao.insertComment(UserID, BLogID, CommentDate, Content);

		}
		catch( SQLException | ClassNotFoundException e )
		{
			e.printStackTrace();
			throw new RuntimeException( e );
		}

	}

}
