package kr.co.bit.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.bit.user.vo.UserVO;
import kr.co.bit.util.ConnectionFactory;
import oracle.net.aso.l;

public class UserDAO {
	// 회원 가입 서비스
	public void insertUser(UserVO userData) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO t1_user(id, password, nickname, ");
		sql.append(" email_id, email_domain, type, gender, sign_type) ");
		sql.append(" values (?, ?, ?, ?, ?, ?, ?, ?) ");
		
		try(
				// AutoCloseable 상속받기 때문에 에러 x
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			int loc = 1;
			pstmt.setString(loc++, userData.getId());
			pstmt.setString(loc++, userData.getPassword());
			pstmt.setString(loc++, userData.getNickname());
			pstmt.setString(loc++, userData.getEmail_id());
			pstmt.setString(loc++, userData.getEmail_domain());
			pstmt.setString(loc++, userData.getType());
			pstmt.setString(loc++, userData.getGender());
			pstmt.setString(loc++, userData.getSign_type());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) { e.printStackTrace(); }
		
	}
		
		
	//전체 회원 조회 서비스
	public List<UserVO> selectAllUser() {
			
		List<UserVO> list = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id, password, nickname, ");
		sql.append(" 		email_id, email_domain, type, gender, sign_type, ");
		sql.append("		to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
		sql.append("FROM t1_user ");
		sql.append("ORDER BY reg_date desc");
		
		try (
				// AutoCloseable 상속받기 때문에 에러 x
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				
		){
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				UserVO userList = new UserVO();
				
				userList.setId(rs.getString("id"));
				userList.setPassword(rs.getString("password"));
				userList.setNickname(rs.getString("nickname"));
				userList.setEmail_id(rs.getString("email_id"));
				userList.setEmail_domain(rs.getString("email_domain"));
				userList.setType(rs.getString("type"));
				userList.setGender(rs.getString("gender"));
				userList.setSign_type(rs.getString("sign_type"));
				userList.setReg_date(rs.getString("reg_date"));
				
				list.add(userList);
			}
		} catch (Exception e) { e.printStackTrace(); }
		
		return list;
	}
		
	// 회원 아이디에 따른 상세 정보 조회 서비스
	public UserVO selectById(String id) {
		
		UserVO userList = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id, password, nickname, ");
		sql.append(" 		email_id, email_domain, type, gender, sign_type, ");
		sql.append("		to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
		sql.append("FROM t1_user ");
		sql.append("WHERE id = ? ");
	 	
		try(
				// AutoCloseable 상속받기 때문에 에러 x
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				userList = new UserVO();
				
				userList.setId(rs.getString("id"));
				userList.setPassword(rs.getString("password"));
				userList.setNickname(rs.getString("nickname"));
				userList.setEmail_id(rs.getString("email_id"));
				userList.setEmail_domain(rs.getString("email_domain"));
				userList.setType(rs.getString("type"));
				userList.setGender(rs.getString("gender"));
				userList.setSign_type(rs.getString("sign_type"));
				userList.setReg_date(rs.getString("reg_date")); 
			}
		} catch (Exception e) { e.printStackTrace(); }
		
		return userList;
	}
	
	// 회원 아이디에 해당하는 회원 탈퇴
	public void deleteUser(String id) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM t1_user ");
		sql.append("WHERE id = ? ");
		
		try(
				// AutoCloseable 상속받기 때문에 에러 x
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, id);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) { e.printStackTrace(); }
		
	}
	
	// 로그인 서비스
	public UserVO login(UserVO user) {
		
		UserVO loginUser = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id, password, nickname, type, sign_type ");
		sql.append("FROM t1_user ");
		sql.append("WHERE id = ? and password = ? ");
		
		try (
				// AutoCloseable 상속받기 때문에 에러 x
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPassword());
			
			ResultSet rs = pstmt.executeQuery();
			
			// 로그인 성공 시
			if (rs.next()) {
				loginUser = new UserVO();
				
				loginUser.setId(rs.getString("id"));
				loginUser.setPassword(rs.getString("password"));
				loginUser.setNickname(rs.getString("nickname"));
				loginUser.setType(rs.getString("type"));
				loginUser.setSign_type(rs.getString("sign_type"));
			}
		} catch (Exception e) { e.printStackTrace(); }
		
		return loginUser;
	}
	
	// 회원정보 수정 - 일반
    public void updateUser(UserVO userData) {
    	
        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE t1_user ");
        sql.append("SET password = ?, nickname = ?, email_id = ?, email_domain = ? ");
        sql.append("WHERE id = ?");
        
        try (
        		// AutoCloseable 상속받기 때문에 에러 x
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
        ){
        	// 자동 커밋을 false로 한다.
            conn.setAutoCommit(false);

            int loc = 1;
			pstmt.setString(loc++, userData.getPassword());
			pstmt.setString(loc++, userData.getNickname());
			pstmt.setString(loc++, userData.getEmail_id());
			pstmt.setString(loc++, userData.getEmail_domain());
			pstmt.setString(loc++, userData.getId());
			
			pstmt.executeUpdate();
			
			// 완료시 커밋
            conn.commit(); 
            
        } catch (Exception e) { e.printStackTrace(); }
    }
    
    // 회원정보 수정 - 카카오 (비번 변경 불가)
    public void updatekkoUser(UserVO userData) {
    	
        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE t1_user ");
        sql.append("SET nickname = ?, email_id = ?, email_domain = ? ");
        sql.append("WHERE id = ?");
        
        try (
        		// AutoCloseable 상속받기 때문에 에러 x
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
        ){
        	// 자동 커밋을 false로 한다.
            conn.setAutoCommit(false);
        	
            int loc = 1;
			pstmt.setString(loc++, userData.getNickname());
			pstmt.setString(loc++, userData.getEmail_id());
			pstmt.setString(loc++, userData.getEmail_domain());
			pstmt.setString(loc++, userData.getId());
			
			pstmt.executeUpdate();
			
			// 완료시 커밋
            conn.commit();
            
        } catch (Exception e) { e.printStackTrace(); }
    }
    
    // 아이디 중복체크
    public boolean checkId(String id) {
    	
    	StringBuffer sql = new StringBuffer();
        sql.append("SELECT id FROM t1_user ");
        
        try (
        		// AutoCloseable 상속받기 때문에 에러 x
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
        ){
        	ResultSet rs = pstmt.executeQuery();
        	
        	while (rs.next()) {
				if (rs.getString("id").equals(id)) {
					return true;
				}
			}
        } catch (Exception e) { e.printStackTrace(); }
        return false;
	}
}
