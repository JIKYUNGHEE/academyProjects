package kr.co.bit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.bit.board.vo.ReplyVO;
import kr.co.bit.util.ConnectionFactory;
import kr.co.bit.util.JDBCClose;

public class ReplyDAO {

	public void insertReply(ReplyVO reply) {
		
			
			StringBuilder sql = new StringBuilder();
			sql.append("insert into ex_reply( ");
			sql.append("    reply_no, board_no, id, reply_content ");
			sql.append(" ) values ( ");
			sql.append("    seq_t_reply_no.nextval, ?, ?, ? ");
			sql.append(" ) ");
			
			try (
				Connection conn 
					= new ConnectionFactory().getConnection();
				PreparedStatement pstmt 
					= conn.prepareStatement(sql.toString());
			) {
				int loc = 1;
				
				pstmt.setInt(loc++,	reply.getBoard_no());
				pstmt.setString(loc++, reply.getId());
				pstmt.setString(loc++, reply.getReply_content());
								
				pstmt.executeUpdate();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
	public List<ReplyVO> getReply(int board_no){
		
		List<ReplyVO> list = new ArrayList<>();
				
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{			
			
			  conn = new ConnectionFactory().getConnection();			
			  StringBuilder sql = new StringBuilder();			  

			  sql.append("select reply_no, board_no, id, to_char(reply_date, 'yyyy-mm-dd hh:mi:ss') as reply_date, reply_content from ex_reply where board_no =?");
			  sql.append("    order by reply_no asc  ");
			  
			  pstmt = conn.prepareStatement(sql.toString());
			  pstmt.setInt(1, board_no);
			  
			  ResultSet rs = pstmt.executeQuery();
			  				
			
			  while(rs.next()){
				
				 ReplyVO reply = new ReplyVO();
				   
				 int reply_no = rs.getInt("reply_no");
				  int board_no1 = rs.getInt("board_no");
				  String id = rs.getString("id");
				  String reply_date = rs.getString("reply_date");
				  String reply_content = rs.getString("reply_content");
				  
				  reply.setReply_no(reply_no);
				  reply.setBoard_no(board_no1);
				  reply.setId(id);
				  reply.setReply_date(reply_date);
				  reply.setReply_content(reply_content);
				  		
				  list.add(reply);
			  }
			  
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			JDBCClose.close(conn,  pstmt);
		}
		
		return list;		
		
	}
	
	
	public void delete(int no) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete ex_reply where reply_no = ?");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}		
		
	

		
		
	}

		
	

