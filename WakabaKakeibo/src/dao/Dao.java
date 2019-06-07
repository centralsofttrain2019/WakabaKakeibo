package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dao {

	public static Connection getConnection()

		throws SQLException, ClassNotFoundException
		{
		System.out.println("testdb");
			Class.forName("com.mysql.cj.jdbc.Driver");

	        Connection con = null;
	        con = DriverManager.getConnection(
	                    "jdbc:mysql://"
	                    + "localhost"
	                    + "/"
	                    + "wakaba_schema"
	                    + "?serverTimezone=JST",
	                    "root",
	                    "root"
	                    );
	        System.out.println("接続成功");
	        return con;
		}


	}


