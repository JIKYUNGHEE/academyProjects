package kr.co.bit.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public Connection getConnection() {

		Connection conn = null;

		try {
			// ojdbc8.jar �ȿ� ���� �о����
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@192.168.1.25:1521:xe";
			String user = "hr";
			String password = "hr";

			conn = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) { e.printStackTrace(); }

		return conn;
	}
}
