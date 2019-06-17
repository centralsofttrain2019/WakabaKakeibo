package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import bean.BLBean;
import bean.BLMapBean;
import bean.MBCommentBean;
import bean.MBCommentListBean;
import dao.BlogCommentsDao;
import dao.BlogLikesDao;
import dao.BlogsDao;
import domain.BlogCategoryEnum;

public class BlogService {

	public MBCommentListBean findAllComment()
	{
		MBCommentListBean bean = new MBCommentListBean();

		//オートクローズ
		try( Connection con= dao.Dao.getConnection() )
		{
			BlogCommentsDao bDao = new BlogCommentsDao(con);
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
			BlogCommentsDao bDao = new BlogCommentsDao(con);
			bDao.insertComment(UserID, BLogID, CommentDate, Content);
			System.out.println("Service Hello");

		}
		catch( SQLException | ClassNotFoundException e )
		{
			e.printStackTrace();
			throw new RuntimeException( e );
		}

	}

	public BLMapBean findAllLike()
	{
		BLMapBean blMBean = new BLMapBean();

		//オートクローズ
		try( Connection con= dao.Dao.getConnection() )
		{
			BlogLikesDao blDao = new BlogLikesDao(con);
			List<BLBean> blList = blDao.selectAllLikes();

//			List->Map<Integer, List<BLBean>>への変換
			Map<Integer, List<BLBean>> map = blList.stream().collect(Collectors.groupingBy(s -> s.getBlogID()));

			blMBean.setMap(map);

		}
		catch( SQLException | ClassNotFoundException e )
		{
			e.printStackTrace();
			throw new RuntimeException( e );
		}

		return blMBean;
	}

	public void changeLike(int UserID, int BLogID, Timestamp likeDate, String like)
	{
		//オートクローズ
		try( Connection con= dao.Dao.getConnection() )
		{
			BlogLikesDao bLDao = new BlogLikesDao(con);
			bLDao.changeLike(UserID, BLogID, likeDate, like);

		}
		catch( SQLException | ClassNotFoundException e )
		{
			e.printStackTrace();
			throw new RuntimeException( e );
		}

	}


	public void insertBlog(int UserID, Timestamp CreateDate, String Title, String Content, BlogCategoryEnum Category, String image1, String image2, int ReblogID)
	{
		//オートクローズ
		try( Connection con= dao.Dao.getConnection() )
		{
			BlogsDao bLDao = new BlogsDao(con);
			bLDao.insertBlog(UserID, CreateDate, Title, Content, Category, image1, image2, ReblogID);

		}
		catch( SQLException | ClassNotFoundException e )
		{
			e.printStackTrace();
			throw new RuntimeException( e );
		}

	}

}
