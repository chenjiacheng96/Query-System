package cqh.utils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Utils {
	// �������ӳ�
	private static ComboPooledDataSource cpds = new ComboPooledDataSource();
	
	// threadlocal���
	private static ThreadLocal<Connection> local = new ThreadLocal<Connection>();
	
	// ����Դ
	public static DataSource getDataSource() {
		return cpds;
	}
	
	// ��ȡ���Ӷ���
	public static Connection getConnection() {
		Connection con = null;
		try {
			con = local.get();
			
			if (con == null) {
				con = cpds.getConnection();
				local.set(con);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	
	// �ͷ�threadlocal��Դ
	public static void removeThreadLocal() {
		local.remove();
	}
	
	// �ͷ���Դ
	public static void release(ResultSet resultSet, Statement statement,
			Connection connection) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (statement != null) {

			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (connection != null) {

			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}











