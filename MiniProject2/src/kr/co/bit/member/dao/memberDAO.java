package kr.co.bit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.bit.member.vo.memberFileVO;
import kr.co.bit.member.vo.memberVO;
import kr.co.bit.util.ConnectionFactory;

public class memberDAO {

	private List<memberVO> members = null;
	
	public void insert(memberVO member) {
		
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into t_member ( id, name, password, nickname, sex, petNo, tel, basic_addr ) ");
		sql.append(" values (?, ?, ?, ?, ?, ?, ?, ?) ");
		
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			
			int cnt = 1;
			
			pstmt.setString(cnt++, member.getId());
			pstmt.setString(cnt++, member.getName());
			pstmt.setString(cnt++, member.getPassword());
			pstmt.setString(cnt++, member.getNickname());
			pstmt.setString(cnt++, member.getSex());
			pstmt.setInt(cnt++, member.getPetNo());		
			pstmt.setString(cnt++, member.getTel());
			pstmt.setString(cnt++, member.getBasic_addr());
			
			pstmt.executeQuery();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public memberVO selectById(String id){
			
			StringBuilder sql = new StringBuilder();
			sql.append(" select id, name, password, nickname, sex, petNo, tel, basic_addr, type, point, to_char(reg_date, 'yyyy-mm-dd') as reg_date from t_member where id = ? ");
			memberVO member = null;
			
			try(
					Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql.toString());
					){
				
				pstmt.setString(1, id);
				
				ResultSet rs = pstmt.executeQuery();
				member = new memberVO();
				
				if(rs.next()) {
					member.setId(id);
					member.setName(rs.getString("name"));
					member.setPassword(rs.getString("password"));
					member.setNickname(rs.getString("nickname"));
					member.setSex(rs.getString("sex"));
					member.setPetNo(rs.getInt("petNo"));
					member.setTel(rs.getString("tel"));
					member.setBasic_addr(rs.getString("basic_addr"));
					member.setPoint(rs.getInt("point"));
					member.setType(rs.getString("type"));
					member.setReg_date(rs.getString("reg_date"));
				}else {
					//member == null
				}
				
		}catch(Exception e) {
			e.printStackTrace();
		}
			return member;
		}
	
	
	
	public memberVO login(String id, String password) {
		
		memberVO idmember = null;
		memberVO member = null;
		
		idmember = selectById(id);
		
		StringBuilder sql = new StringBuilder();
		sql.append("select id, name, password, nickname, sex, petNo, tel, basic_addr, type, point, to_char(reg_date, 'yyyy-mm-dd') as reg_date from t_member where id=? and password=?");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			member = new memberVO();
			if(rs.next()) {
				member.setId(id);
				member.setName(rs.getString("name"));
				member.setPassword(rs.getString("password"));
				member.setNickname(rs.getString("nickname"));
				member.setSex(rs.getString("sex"));
				member.setPetNo(rs.getInt("petNo"));
				member.setTel(rs.getString("tel"));
				member.setBasic_addr(rs.getString("basic_addr"));
				member.setPoint(rs.getInt("point"));
				member.setType(rs.getString("type"));
				member.setReg_date(rs.getString("reg_date"));
			}
			else {
				
			}
		}catch(Exception e) {
			
		}
		return member;
	}

	//---------------------------------------------------------------------------------------------
	//첨부파일 관련 CRUD
	//---------------------------------------------------------------------------------------------
	
	public void insertFile(memberFileVO fileVO) {
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into t_member_file( no, memberId, fileOriName, fileSaveName, fileSize) values ( " );
		sql.append(" seq_t_member_file_no.nextval, ?, ?, ?, ? ) ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			int loc = 1;
			pstmt.setString(loc++, fileVO.getMemberId());
			pstmt.setString(loc++, fileVO.getFileOriName());
			pstmt.setString(loc++, fileVO.getFileSaveName());
			pstmt.setInt(loc++, fileVO.getFileSize());
			System.out.println(pstmt);
			
			pstmt.executeUpdate();
						
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		/**
		 * file 선택
		 * @param boardNo
		 * @return
		 */
		public memberFileVO selectFileByNo(String memberId){
			memberFileVO fileVO = null;
			StringBuilder sql = new StringBuilder();
			sql.append(" select no, fileOriName, fileSaveName, fileSize from t_member_file where memberId = ? ");
			
			try(
					Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement pstmt =  conn.prepareStatement(sql.toString());
					){
				pstmt.setString(1, memberId);
				
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					fileVO = new memberFileVO();
					
					fileVO.setNo(rs.getInt("no"));
					fileVO.setMemberId(memberId);
					fileVO.setFileOriName(rs.getString("fileOriName"));
					fileVO.setFileSaveName(rs.getString("fileSaveName"));
					fileVO.setFileSize(rs.getInt("fileSize"));
					
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			return fileVO;
		}
		
				
		/**
		 * file삭제
		 * @param boardNo
		 */
		public void deleteFile(String memberId) {
			StringBuilder sql = new StringBuilder();
			sql.append(" delete from t_board_file where memberId=? ");
			
			try(
					Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql.toString());
					){
				pstmt.setString(1, memberId);
				
				pstmt.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
	}
		/**
		 * file 수정
		 */
		
		public void modifyMember(memberVO member){
			
			StringBuilder sql = new StringBuilder();
			sql.append("update t_member set name=?, password=?, nickname=?, petNo=?, sex=?, tel=?, basic_addr=? where id=?");
			
			try(
					
					Connection conn = new ConnectionFactory().getConnection();			
					PreparedStatement pstmt = conn.prepareStatement(sql.toString());
					
					) { 
				
				int loc = 1;			
				pstmt.setString(loc++, member.getName());
				pstmt.setString(loc++, member.getPassword());
				pstmt.setString(loc++, member.getNickname());
				pstmt.setInt(loc++, member.getPetNo());
				pstmt.setString(loc++, member.getSex());
				pstmt.setString(loc++, member.getTel());
				pstmt.setString(loc++, member.getBasic_addr());
				pstmt.setString(loc++, member.getId());
				
				pstmt.executeUpdate();
				
				
			} catch(Exception e) {
				
				
			}
			
		}
		
		
		
		
		
		
		
}

