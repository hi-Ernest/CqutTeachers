package edu.cqut.hr.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	public static Connection getConnection() 
	{
	    Connection connection = null;
	    Statement stmt = null;
		String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/tickit?useUnicode=true&characterEncoding=utf-8";//设置数据库的地址 设置编码  支持汉字
		String userName = "root";
		String userPWD = "Chen247.";
		
		try {
			//注册JDBC驱动程序
			Class.forName(driverName);
			
			//建立与数据库的物理连接
			connection = DriverManager.getConnection(url,userName,userPWD);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static Statement getStatement()
	{
		Statement stmt = null;
		try {
			stmt = getConnection() .createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return stmt;
	}
	
	/**
	 * Statement接口中执行sql语句的方法
	 * @param sql
	 * @return
	 * @throws Exception
	 */
	public static boolean execute(String sql) throws Exception
	{
		Connection connection = getConnection();
		
		Statement  statement =  connection.createStatement();
		
		return statement.execute(sql);
	}
}
