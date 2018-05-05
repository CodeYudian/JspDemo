package com.codeYudian.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class InitDB {

	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/test";
	private static final String username = "root";
	private static final String password = "yudian123";

	private static Connection conn = null;

	// ��������
	static {
		try {
			Class.forName(driver);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// ����ģʽ.������ֻ����һ��ʵ��
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
				System.out.println("���ݿ����ӳɹ�");
			} else {
				System.out.println("���ݿ�����ʧ��");
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
