package kr.co.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.co.bit.member.vo.MemberVO;
import kr.co.bit.util.ConnectionFactory;

public class JoinDAO {

	public void join(MemberVO member) {

		StringBuilder sql = new StringBuilder();

		sql.append("insert into b_member(id, pw, name, tel, addr)  ");
		sql.append("    values(?, ?, ?, ? ,?  )   ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			
			int loc=1;
			pstmt.setString(loc++, member.getId());
			pstmt.setString(loc++, member.getPw());
			pstmt.setString(loc++, member.getName());
			pstmt.setString(loc++, member.getTel());
			pstmt.setString(loc++, member.getAddr());
			
			pstmt.executeUpdate();
			System.out.println("db들어감");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
}
