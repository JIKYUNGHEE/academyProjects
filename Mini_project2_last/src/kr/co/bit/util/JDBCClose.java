package kr.co.bit.util;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class JDBCClose {

	public static void close(Connection conn, PreparedStatement pstmt) {
		// 1. PreparedStatement 먼저 닫기
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (Exception e) { e.printStackTrace(); }
		}
		// 2. Connection 마지막으로 닫기
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) { e.printStackTrace(); }
		}
		// => if문 각자 쓰는 이유 : PreparedStatement 실행 실패하면 break로 나가버리기 때문!
	}
	
}
