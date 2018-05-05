package com.codeYudian.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class InitDB {

	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/test";
	private static final String username = "root";
	private static final String password = "yudian123";

	private static Connection conn = null;

	// 加载驱动
	static {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// 单例模式.单例类只能有一个实例
	public static Connection getConnection() throws Exception {
		if (conn == null) {
			conn = DriverManager.getConnection(url, username, password);
			return conn;
		}
		return conn;
	}

	public static void main(String[] args) {
		try {
			Connection conn = InitDB.getConnection();
			if (conn != null) {
				System.out.println("数据库连接成功");
			} else {
				System.out.println("数据库连接失败");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
