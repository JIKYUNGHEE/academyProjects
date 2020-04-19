package kr.co.bit.qna.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.bit.qna.vo.QnAVO;
import kr.co.bit.util.ConnectionFactory;
import kr.co.bit.util.JDBCClose;

public class QnADAO {
	
	/**
	 * qna 추가 -> 회원
	 * @param qna
	 */
	public void insert_Q(QnAVO qna) {
		StringBuilder sql = new StringBuilder();
		
		sql.append(" insert into t_qnaboard( no, writer, title, content1, reg_date1 ) ");
		sql.append(" values ( seq_t_qnaboard_no.nextval, ?, ?, ?, sysdate ) ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			
			pstmt.setString(1, qna.getWriter());
			pstmt.setString(2, qna.getTitle());
			pstmt.setString(3, qna.getContent1());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * qna 추가 -> 관리자
	 * @param qna
	 */
	public void update_A(QnAVO qna) {
		StringBuilder sql = new StringBuilder();
		
		System.out.println("qna content2 : "+qna.getContent2());
		System.out.println("qna no : "+qna.getNo());
		
		sql.append(" update t_qnaboard set content2=?, reg_date2=sysdate where no = ? ");
				
		try(
				Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			
			pstmt.setString(1, qna.getContent2());
			pstmt.setInt(2, qna.getNo());
						
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * qna 게시글 번호 추출
	 * @return
	 */
	public int selectNo() {
		int no = 0;
		String sql = "select seq_t_qnaboard_no.nextval from dual ";
		try(
			Connection conn 
				= new ConnectionFactory().getConnection();
			PreparedStatement pstmt 
				= conn.prepareStatement(sql);
		) {
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			no = rs.getInt(1);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return no;
	}
	
	/**
	 * 전체 Q&A 조회 -> 관리자 용
	 */
	public List<QnAVO> selectAllBoard() {

		List<QnAVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" select no, title, writer, content1, content2,  ");
			sql.append("       to_char(reg_date1, 'yyyy-mm-dd') as reg_date1, ");
			sql.append("       to_char(reg_date2, 'yyyy-mm-dd') as reg_date2");
			sql.append("  from t_qnaboard ");
			sql.append(" order by no desc ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				QnAVO qna = new QnAVO();
				
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String content1 = rs.getString("content1");
				String content2 = rs.getString("content2");
				String regDate1 = rs.getString("reg_date1");
				String regDate2 = rs.getString("reg_date2");
				
				qna.setNo(no);
				qna.setTitle(title);
				qna.setWriter(writer);
				qna.setContent1(content1);
				qna.setContent2(content2);
				qna.setRegDate1(regDate1);
				qna.setRegDate2(regDate2);
				
				list.add(qna);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		return list;
	}
	
	/**
	 * 나의 Q&A 조회 -> 회원용
	 */
	// 게시물번호에 따른 조회서비스
		public List<QnAVO> selectById(String id) {
			
			List<QnAVO> list = null;
			QnAVO qna = null;
			StringBuilder sql = new StringBuilder();
			sql.append("select no, title, writer, content1, content2,  ");
			sql.append("       to_char(reg_date1, 'yyyy-mm-dd') as reg_date1, ");
			sql.append("       to_char(reg_date2, 'yyyy-mm-dd') as reg_date2");
			sql.append("  from t_qnaboard ");
			sql.append("  where writer = ? order by no desc ");
			
			try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
				pstmt.setString(1, id);
				ResultSet rs = pstmt.executeQuery();
				
				list = new ArrayList<>();
				
				while(rs.next()) {
					qna = new QnAVO();
					qna.setNo(rs.getInt("no"));
					qna.setTitle(rs.getString("title"));
					qna.setWriter(rs.getString("writer"));
					qna.setContent1(rs.getString("content1"));
					qna.setContent2(rs.getString("content2"));
					qna.setRegDate1(rs.getString("reg_date1"));
					qna.setRegDate2(rs.getString("reg_date2"));
					
					list.add(qna);
				}
				
			} catch(Exception e) {
				e.printStackTrace();
			}			
			return list;
		}	
}