package kr.co.bit.board.dao;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.bit.board.vo.BoardFileVO;
import kr.co.bit.board.vo.BoardVO;
import kr.co.bit.util.ConnectionFactory;
import kr.co.bit.util.JDBCClose;

public class BoardDAO {


	// 전체 게시글 조회서비스 
	public List<BoardVO> selectAllBoard() {

		List<BoardVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select no, title, writer, ");
			sql.append("       to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
			sql.append("  from t_freeboard ");
			sql.append(" order by no desc ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO board = new BoardVO();
				
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String regDate = rs.getString("reg_date");
				
				board.setNo(no);
				board.setTitle(title);
				board.setWriter(writer);
				board.setRegDate(regDate);
				
				list.add(board);
			}
			

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		
		return list;
	}	

	
	/**
	 * 게시글 번호 추출
	 */
	public int selectNo() {
		int no = 0;
		String sql = "select seq_t_freeboard_no.nextval from dual ";
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
	

	public void insert(BoardVO board) {

		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_freeboard( ");
		sql.append("    no, title, writer, content ");
		sql.append(" ) values ( ");
		sql.append("    ?, ?, ?, ? ");
		sql.append(") ");
		
		try (
			Connection conn 
				= new ConnectionFactory().getConnection();
			PreparedStatement pstmt 
				= conn.prepareStatement(sql.toString());
		) {
			int loc = 1;
			pstmt.setInt(loc++,	board.getNo());
			pstmt.setString(loc++, board.getTitle());
			pstmt.setString(loc++, board.getWriter());			
			pstmt.setString(loc++, board.getContent());
			
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			
		}
	}
	
	// 게시물번호에 따른 조회서비스
	public BoardVO selectByNo(int no) {
		
		BoardVO board = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("select no, title, writer, content, view_cnt, ");
		sql.append("       to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
		sql.append("  from t_freeboard ");
		sql.append(" where no = ? ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			addViewCnt(no);
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board = new BoardVO();
			
				board.setNo(rs.getInt("no"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setViewCnt(rs.getInt("view_cnt"));
				board.setRegDate(rs.getString("reg_date"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return board;
	}
	
	
	public BoardVO selectAllWrite(int no){
		
		BoardVO board = null;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{			
			
			  conn = new ConnectionFactory().getConnection();			
			  StringBuilder sql = new StringBuilder();			  

			  sql.append("select no, title, writer, content from t_freeboard where no =?");
			  
			  
			  pstmt = conn.prepareStatement(sql.toString());
			  pstmt.setInt(1, no);
			  
			  ResultSet rs = pstmt.executeQuery();
			  
				
			
			  while(rs.next()){
				
				 board = new BoardVO();
				   
				 int no1 = rs.getInt("no");
				  String title = rs.getString("title");
				  String writer = rs.getString("writer");
				  String content = rs.getString("content");
				  
				  board.setNo(no1);
				  board.setTitle(title);
				  board.setWriter(writer);
				  board.setContent(content);
				  				
			  }
			  
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			JDBCClose.close(conn,  pstmt);
		}
		
		return board;		
		
	}

	
	public void delete(int no) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete t_freeboard where no = ?");
		
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
	
	
	
	private void addViewCnt(int no) {
		StringBuilder sql = new StringBuilder();
		sql.append("update t_freeboard set view_cnt = view_cnt + 1 where no = ?");
		
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
	
	
	public void modify(BoardVO board){
		
		StringBuilder sql = new StringBuilder();
		sql.append("update t_freeboard set title=?, writer=?, content=? where no =?");
		
		try(
				
			Connection conn = new ConnectionFactory().getConnection();			
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
						
			) { 
			
			int loc = 1;			
			pstmt.setString(loc++, board.getTitle());
			pstmt.setString(loc++, board.getWriter());			
			pstmt.setString(loc++, board.getContent());
			pstmt.setInt(loc++, board.getNo());
			
			pstmt.executeUpdate();
			
			
		} catch(Exception e) {
			e.printStackTrace();
			
		}
		
		
		
		
	}

	
	public void deleteFile(int no) {

		StringBuilder sql = new StringBuilder();
		sql.append("delete from t_freeboard_file where board_no=? ");
	      
	      try (
	    		  
	    		  Connection conn = new ConnectionFactory().getConnection();
	    	      PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	    		  
	    		  ){
	               	         
	        	         
	         pstmt.setInt(1, no);
	         pstmt.executeUpdate();
	         
	      }catch(Exception e) {
	    	  e.printStackTrace();
	      }
	}


	
	//-----------------------------------------------------
	// 첨부파일 관련 CRUD (t_board_file)
	//-----------------------------------------------------
	public void insertFile(BoardFileVO fileVO) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_freeboard_file( ");
		sql.append("   no, board_no, file_ori_name, ");
		sql.append("   file_save_name, file_size ");
		sql.append(" ) values( ");
		sql.append("   seq_t_freeboard_file_no.nextval, ?, ?, ?, ? ");
		sql.append(" ) ");
		
		try(
			Connection conn 
				= new ConnectionFactory().getConnection();
			PreparedStatement pstmt 
				= conn.prepareStatement(sql.toString());
		) {
			
			int loc = 1;
			pstmt.setInt(loc++, fileVO.getBoardNo());
			pstmt.setString(loc++, fileVO.getFileOriName());
			pstmt.setString(loc++, fileVO.getFileSaveName());
			pstmt.setInt(loc++, fileVO.getFileSize());
			
			pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public List<BoardFileVO> selectFileByNo(int boardNo){
		
		List<BoardFileVO> fileList = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder();
		sql.append("select no, file_ori_name, file_save_name, file_size ");
		sql.append(" from t_freeboard_file where board_no = ? ");
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setInt(1, boardNo);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardFileVO file = new BoardFileVO();
				file.setNo(rs.getInt(1));
				file.setFileOriName(rs.getString(2));
				file.setFileSaveName(rs.getString(3));
				file.setFileSize(rs.getInt(4));
				fileList.add(file);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return fileList;
	}
	
	public void downloadFile(int no) throws IOException {
		
		String fileOriName = null;
		String fileSaveName = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select file_ori_name, file_save_name ");
		sql.append(" from t_freeboard_file where no = ? ");
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				fileOriName = rs.getString(1);
				fileSaveName = rs.getString(2);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		InputStream in = new FileInputStream("C:/Users/bit-user/web-workspace/Mission-Web/WebContent/upload/"+fileSaveName);
		BufferedInputStream bin = new BufferedInputStream(in);
		OutputStream out = new FileOutputStream("C:/Users/bit-user/web-workspace/Mission-Web/WebContent/download/"+fileOriName);
		BufferedOutputStream bout = new BufferedOutputStream(out);
		
		int bData;
		
		while(true) {
			bData = bin.read();
			if(bData==-1)
				break;
			bout.write(bData);
		}
		bin.close();
		bout.close();		
	}
	
	//-----------------------------------------------------
	// 페이징
	/* 전체 게시글 조회 서비스 */
		public List<BoardVO> getList(int startRow, int endRow) {

			List<BoardVO> list = new ArrayList<>();
			
			StringBuilder sql = new StringBuilder();
			
			sql.append(" select * from (select rownum rn, no, writer, title, content,  to_char(reg_date, 'yyyy-mm-dd') as reg_date, view_cnt ");
			sql.append(" from (select * from t_freeboard order by no desc)) " );
			sql.append(" where rn between ? and ? " );
			
			try(
					Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql.toString());
					) {
				pstmt.setInt(1, startRow);
				pstmt.setInt(2, endRow);
				ResultSet rs = pstmt.executeQuery();
				
				while(rs.next()) {
					BoardVO board = new BoardVO();
					
					int no = rs.getInt("no");
					String title = rs.getString("title");
					String writer = rs.getString("writer");
					String regDate = rs.getString("reg_date");
					
					board.setNo(no);
					board.setTitle(title);
					board.setWriter(writer);
					board.setRegDate(regDate);
					
					list.add(board);
				}			
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return list;
		}
		
		/* 전체 게시글 수 조회 서비스 */
		public int getCount(){
			int count = 0;
			String sql = "select count(*) from t_freeboard";
			try(
					Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql.toString());
					) {
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()){
					count = rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return count; // 총 레코드 수 리턴
		}
	
}








