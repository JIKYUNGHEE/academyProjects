package kr.co.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.bit.member.vo.MemberVO;
import kr.co.bit.util.ConnectionFactory;
import kr.co.bit.util.JDBCClose;

public class MemberDAO {
	
	
	public List<MemberVO> selectAllBoard() {

		List<MemberVO> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = new ConnectionFactory().getConnection();

			StringBuilder sql = new StringBuilder();
			sql.append(" select id, pw, name, tel, addr, type, point, grade ");
			sql.append(" from b_member ");

			pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberVO member = new MemberVO();

				
				String name = rs.getString("name");
				String pw = rs.getString("pw");
				String id = rs.getString("id");
				String tel = rs.getString("tel");
				String addr = rs.getString("addr");
				String type = rs.getString("type");
				String grade = rs.getString("grade");
				int point = rs.getInt("point");
				
				member.setName(name);
				member.setId(id);
				member.setPw(pw);
				member.setTel(tel);
				member.setAddr(addr);
				member.setPoint(point);
				member.setGrade(grade);
				member.setType(type);
				
				list.add(member);

			}

		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			JDBCClose.close(conn, pstmt);
		}

		return list;
	}


	public MemberVO selectById(String id) {

		MemberVO member = null;		
	
		StringBuilder sql = new StringBuilder();
		sql.append("select id, pw, name, tel, addr, type, point, grade ");
		sql.append("  from b_member ");
		sql.append(" where id = ? ");

		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){

			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				member = new MemberVO();
			
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setAddr(rs.getString("addr"));
				member.setTel(rs.getString("tel"));
				member.setType(rs.getString("type"));
				member.setPoint(rs.getInt("point"));
				member.setGrade(rs.getString("grade"));
				
				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return member;

	}

	public void delete(String id) {

		StringBuilder sql = new StringBuilder();
		sql.append("delete from b_member ");
		sql.append(" where id = ?");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setString(1, id);
			pstmt.executeUpdate();
			
			

		} catch (Exception e) {

		}
	}
	
	public void updateM(MemberVO member) {
		
		StringBuilder sql = new StringBuilder();
		sql.append(" update b_member set pw=?, tel=?, addr=?, point=?, grade=? ");
		sql.append(" where id = ? ");
		System.out.println("변경시킬 비밀번호:"+member.getPw());
		System.out.println("업데이트 왜안돼");
		
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			int loc=1;
			pstmt.setString(loc++, member.getPw());
			System.out.println("변경된 비밀번호는 "+member.getPw());
			pstmt.setString(loc++, member.getTel());
			pstmt.setString(loc++, member.getAddr());
			pstmt.setInt(loc++, member.getPoint());
			pstmt.setString(loc++, member.getGrade());
			pstmt.setString(loc++, member.getId());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
}
