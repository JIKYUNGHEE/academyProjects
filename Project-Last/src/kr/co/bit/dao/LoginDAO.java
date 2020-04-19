package kr.co.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.co.bit.member.vo.MemberVO;
import kr.co.bit.util.ConnectionFactory;

public class LoginDAO {

	public MemberVO login(MemberVO member) {

		MemberVO userVO = null;

		

		StringBuilder sql = new StringBuilder();
		sql.append(" select id, pw, type ");
		sql.append(" from b_member ");
		sql.append(" where id = ? and pw = ? ");

		System.out.println("sql후");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			ResultSet rs = pstmt.executeQuery();

			System.out.println("되니ㅠ_ㅠ??");
			// 로그인 성공

			System.out.println(member.getId());
			System.out.println(member.getPw());

			if (rs.next()) {

				userVO = new MemberVO();

				userVO.setId(rs.getString("id"));
				userVO.setPw(rs.getString("pw"));
				userVO.setType(rs.getString("type"));

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return userVO;
	}

}
