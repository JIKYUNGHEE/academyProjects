package kr.co.bit.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.co.bit.login.vo.LoginVO;
import kr.co.bit.member.vo.memberFileVO;
import kr.co.bit.util.ConnectionFactory;

public class LoginDAO {
	
	public LoginVO login(LoginVO login) {
		
		LoginVO userVO = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("select id, password, nickname, type from t_member where id = ? and password = ? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			pstmt.setString(1, login.getId());
			pstmt.setString(2, login.getPassword());
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				userVO = new LoginVO();
				userVO.setId(rs.getString("id"));
				userVO.setPassword(rs.getString("password"));
				userVO.setNickname(rs.getString("nickname"));
				userVO.setType(rs.getString("type"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userVO;
	}
	
	public String selectPictureById(String id) {
		  String file = null;
		  
		  StringBuilder sql = new StringBuilder();
	      sql.append("select fileSaveName ");
	      sql.append(" from t_member_file where memberId = ? ");
	      try(
	         Connection conn = new ConnectionFactory().getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	      ){
	         pstmt.setString(1, id);
	         ResultSet rs = pstmt.executeQuery();
	         
	         if(rs.next()) {
	            file = rs.getString(1);
	         }
	      }catch(Exception e) {
	         e.printStackTrace();
	      }

		return file;
	}
	
}