package javaweb.app1.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class DBManager {

	private static DataSource dataSource;
	
	static{
		
		dataSource = new ComboPooledDataSource("ajaxapp");
		
	}
	
	public Connection getConnection(){
		Connection conn= null;
		
		if(dataSource != null)
			try{
				conn = dataSource.getConnection();
			} catch (SQLException e) {
				throw new RuntimeException();
			
			}
		
		return conn;
	}
	
	
	private DBManager(){}
	
	private static DBManager instance = new DBManager();
	
	public static DBManager getInstance(){
		return instance;
	}
	
}
