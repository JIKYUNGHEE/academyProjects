package kr.co.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.bit.TipBoard.vo.TBoardFileVO;
import kr.co.bit.TipBoard.vo.TBoardVO;
import kr.co.bit.marketBoard.vo.MBoardComVO;
import kr.co.bit.marketBoard.vo.MBoardFileVO;
import kr.co.bit.marketBoard.vo.MBoardRepVO;
import kr.co.bit.marketBoard.vo.MBoardVO;
import kr.co.bit.util.ConnectionFactory;

public class MBoardDAO {

	// 전체 게시글 조회
	public List<MBoardVO> selectAll() {
		List<MBoardVO> marketList = new ArrayList<>();
		MBoardVO mvo = null;

		StringBuilder sql = new StringBuilder();
		sql.append(" select no, title, writer, content, view_cnt, ");
		sql.append(" to_char(reg_date, 'yy-mm-dd') as reg_date ");
		sql.append("  from b_m_board ");
		sql.append(" order by no desc ");

		try {
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				mvo = new MBoardVO();

				mvo.setNo(rs.getInt("no"));
				mvo.setTitle(rs.getString("title"));
				mvo.setWriter(rs.getString("writer"));
				mvo.setContent(rs.getString("content"));
				mvo.setViewCnt(rs.getInt("view_cnt"));
				mvo.setRegDate(rs.getString("reg_date"));

				marketList.add(mvo);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return marketList;
	}
	
	 // no에 해당하는 게시글 받아오기(디테일)
	  public MBoardVO selectBoardByNo(int no) {
		  
		  MBoardVO mvo = new MBoardVO();
		  
		  StringBuilder sql = new StringBuilder();
		  
		  sql.append(" select no, title, content, writer, ");
		  sql.append("	   to_char(reg_date, 'yyyy-mm-dd') as reg_date, view_cnt ");
		  sql.append(" from b_m_board  ");
		  sql.append(" where no = ? ");
		  
		  try(
				  Connection conn = new ConnectionFactory().getConnection();
				  PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		  ) {
			  int loc=1;
			  pstmt.setInt(loc++, no);
			  ResultSet rs = pstmt.executeQuery();
			  if(rs.next()) {
				  mvo.setWriter(rs.getString("writer"));
				  mvo.setTitle(rs.getString("title"));
				  mvo.setViewCnt(rs.getInt("view_cnt"));
				  mvo.setContent(rs.getString("content"));
				  mvo.setNo(rs.getInt("no"));
				  mvo.setRegDate(rs.getString("reg_date"));
			  }
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  return mvo;
	  }
	
	
	
		// 글 수정시 no찾아 업데이트
		public void reWriteUp(MBoardVO mvo) {
			
			 StringBuilder sql = new StringBuilder();
			 
			 sql.append(" update b_m_board  ");
			 sql.append(" set title = ?, content = ?, view_cnt = ?, reg_date = sysdate ");
			 sql.append(" where no = ?   ");
			 
				try(
					Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql.toString())
				) {
					int loc=1;
					pstmt.setString(loc++, mvo.getTitle());
					pstmt.setString(loc++, mvo.getContent());
					pstmt.setInt(loc++, mvo.getViewCnt());
					pstmt.setInt(loc++, mvo.getNo());
					
					pstmt.executeUpdate();
					
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				
			}

	
	
	
	
	// file등록을 위해 글 번호 가지고 오기
		public int selectFileNo() {
			int no = 0;

			StringBuilder sql = new StringBuilder();
			sql.append(" select b_m_board_SEQ.NEXTVAL from dual ");

			try {
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

				ResultSet rs = pstmt.executeQuery();

				rs.next();

				no = rs.getInt(1);
				System.out.println(no);

			} catch (Exception e) {
				e.printStackTrace();
			}

			return no;
		}

	// 글 등록
	public void insert(MBoardVO mvo) {

		StringBuilder sql = new StringBuilder();
		sql.append(" insert into b_m_board(no, title, writer, content) ");
		sql.append(" values(?, ?, ?, ?) ");

		try {
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());

			int col=1;
			pstmt.setInt(col++, mvo.getNo());
			pstmt.setString(col++, mvo.getTitle());
			pstmt.setString(col++, mvo.getWriter());
			pstmt.setString(col++, mvo.getContent());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	
	 ////////////////////////// 파일 CRUD ///////////////////////////////////////
	
	// file 등록
	public void insertFile(MBoardFileVO fvo) {

		StringBuilder sql = new StringBuilder();

		sql.append(" insert into b_m_board_file  ");
		sql.append("  (no, file_no,  file_ori_name, file_save_name, file_size ) ");
		sql.append("  values(b_m_board_file_SEQ_no.NEXTVAL, ?, ?, ?, ? ) ");

		try {

			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			
			int col=1;
			pstmt.setInt(col++, fvo.getFileNo());
			pstmt.setString(col++, fvo.getFileOriName());
			pstmt.setString(col++, fvo.getFileSaveName());
			pstmt.setInt(col++, fvo.getFileSize());
	
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// no에 해당하는 게시글 사진파일 받아오기(디테일)
	 	public List<TBoardFileVO> selectTFileByNo(int no) {
		  
	 	List<TBoardFileVO> fileList = new ArrayList<>();
		  StringBuilder sql = new StringBuilder();
		  
		  sql.append(" select no, file_ori_name, file_save_name, file_size ");
		  sql.append(" from b_m_board_file ");
		  sql.append(" where file_no = ? ");
		  
		  try(
				  Connection conn = new ConnectionFactory().getConnection();
				  PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		  ) {
			  		int loc=1;
			  		pstmt.setInt(loc++, no);
			  		
			  		
			  		
			  		ResultSet rs = pstmt.executeQuery();
			  		
			  		while(rs.next()) {
			  			TBoardFileVO fvo = new TBoardFileVO();
			  			
			  			fvo.setNo(rs.getInt("no"));
			  			fvo.setFileOriName(rs.getString("file_ori_name"));
			  			fvo.setFileSaveName(rs.getString("file_save_name"));
			  			fvo.setFileSize(rs.getInt("file_size"));
			  			
			  			fileList.add(fvo);
			  		}
			  		
		  } catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  return fileList;
	  }
	
	
	
	
	// 상세 보기
	public MBoardVO selectDetail(int no) {

		MBoardVO board = null;

		StringBuilder sql = new StringBuilder();
		
		// view_cnt 증가
		sql.append(" update b_m_board set view_cnt = view_cnt+1");
		sql.append(" where no=?");
		
		try {
			
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		

		StringBuilder sqll = new StringBuilder();
		sqll.append(" select no, title, writer, content, view_cnt, ");
		sqll.append("       to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
		sqll.append("  from b_m_board ");
		sqll.append(" where no = ? ");

		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sqll.toString());
			
		) {

			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				board = new MBoardVO();

				board.setNo(rs.getInt("no"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setContent(rs.getString("content"));
				board.setViewCnt(rs.getInt("view_cnt"));
				board.setRegDate(rs.getString("reg_date"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return board;
	}
	// 글 삭제
	public void del(int no) {

		StringBuilder sql = new StringBuilder();
		sql.append("delete b_m_board ");
		sql.append(" where no = ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			
			pstmt.setInt(1, no);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//file 삭제
	public void fileDel(int no) {
		
		StringBuilder sql = new StringBuilder();
		sql.append(" delete b_m_board_file ");
		sql.append(" where file_no=? ");
		
		try {
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 답글 저장
	public void insertCom(MBoardComVO mcvo) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append(" insert into b_m_board_com(no, comment_no, writer, title, content) ");
		sql.append(" values( b_m_board_com_SEQ.nextval, ?, ?, ?, ? )");
		
		try {
			
		Connection conn = new ConnectionFactory().getConnection();
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		
		int col=1;
		
		pstmt.setInt(col++, mcvo.getCommentNo());
		pstmt.setString(col++, mcvo.getWriter());
		pstmt.setString(col++, mcvo.getTitle());
		pstmt.setString(col++, mcvo.getContent());
		
		pstmt.executeUpdate();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 답글 목록 불러오기
	public List<MBoardComVO> selectComAll(){
		
		List<MBoardComVO> clist = new ArrayList<>();
		MBoardComVO mcvo = null;
		
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select no, title, comment_no ");
		sql.append(" from b_m_board_com");
		
		try {
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				mcvo = new MBoardComVO();
				mcvo.setNo(rs.getInt("no"));
				mcvo.setTitle(rs.getString("title"));
				mcvo.setCommentNo(rs.getInt("comment_no"));
				clist.add(mcvo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return clist;
	}
	
	// 답글 번호로 답글 상세 보기
	public MBoardComVO selectComNo(int no) {
		
		MBoardComVO mcvo = null;
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select no, title, writer, content, view_cnt, to_char(reg_date, 'yy-mm-dd') as reg_date ");
		sql.append(" from b_m_board_com");
		sql.append(" where no=? ");
		
		try {
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setInt(1, no);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			mcvo = new MBoardComVO();
			
			mcvo.setNo(rs.getInt("no"));
			mcvo.setTitle(rs.getString("title"));
			mcvo.setWriter(rs.getString("writer"));
			mcvo.setContent(rs.getString("content"));
			mcvo.setViewCnt(rs.getInt("view_cnt"));
			mcvo.setRegDate(rs.getString("reg_date"));
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return mcvo;
	}
	
	// 답글 번호 받아서 삭제
	public void delCom(int no) {
		
		StringBuilder sql = new StringBuilder();
		sql.append(" delete b_m_board_com ");
		sql.append(" where no=? ");
		
		try {
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	// 댓글 저장
	public void insertRep(MBoardRepVO rvo) {
		
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into b_m_board_rep(no, reply_no, writer, content)");
		sql.append(" values( b_m_board_rep_SEQ.nextval, ?, ?, ?) ");
		
		try {
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			
			int col=1;
			pstmt.setInt(col++, rvo.getReplyNo());
			pstmt.setString(col++, rvo.getWriter());
			pstmt.setString(col++, rvo.getContent());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// 게시물 번호 받아서 댓글 불러 오기
	public List<MBoardRepVO> SelectRepAll(int no){
		
		List<MBoardRepVO> rlist = new ArrayList<>();
		MBoardRepVO rvo = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select no, writer, content, to_char(reg_date, 'yy-mm-dd') as reg_date ");
		sql.append(" from b_m_board_rep ");
		sql.append(" where reply_no = ?");
		sql.append(" order by no");
		
		try {
			
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				rvo = new MBoardRepVO();
				
				rvo.setNo(rs.getInt("no"));
				rvo.setWriter(rs.getString("writer"));
				rvo.setContent(rs.getString("content"));
				rvo.setRegDate(rs.getString("reg_date"));
				
				rlist.add(rvo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return rlist;
	}
	// 댓글 번호 받아서 댓글 삭제
	public void delRep(int no) {
		
		StringBuilder sql = new StringBuilder();
		sql.append(" delete b_m_board_rep ");
		sql.append(" where no=?");
		
		try {
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	  ///////////////////////////////PAGING 관련 DAO///////////////////////////////////
	private static final int LIST_SIZE = 5;
		

		public List<MBoardVO> selectBoard() {
		
		
			
			List<MBoardVO> boardList = new ArrayList<MBoardVO>();
			String sql = 
				"select no, writer, title, to_char(reg_date, 'yyyy-mm-dd') reg_date  " +
				"  from b_m_board                                                      " +
				" order by no desc                                                   ";
			
			try (
					Connection    conn = new ConnectionFactory().getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql.toString());
					
				){
			
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					MBoardVO bVO = new MBoardVO();
					bVO.setNo     (rs.getInt   ("no"));
					bVO.setWriter (rs.getString("writer"));
					bVO.setTitle  (rs.getString("title"));
					bVO.setRegDate(rs.getString("reg_date"));
					boardList.add(bVO);
			
				
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
			return boardList;
		}	
		
		
		/**
		 * 요청한 페이지 관련 목록 조회
		 * @param pageNo - 요청페이지 번호
		 * @return 
		 */
		public List<MBoardVO> selectBoard(int pageNo) {
			int start = (pageNo -1) * LIST_SIZE + 1;
			int end   = pageNo      * LIST_SIZE;
			
			List<MBoardVO> boardList = new ArrayList<MBoardVO>();
			String sql = 
				"select no, writer, title, to_char(reg_date, 'yyyy-mm-dd') reg_date, view_cnt  " +
				"  from ( select rownum rnum, b.*                 " +
				"		   from ( select a.*                      " +
				"		 		    from b_m_board a                " +
				"				   order by no desc ) b )         " +
				" where rnum >= ?                                 " +
				"   and rnum <= ?                                 ";
			
			try(
					Connection         conn = new ConnectionFactory().getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql.toString());
					
					){
			
				
				pstmt.setInt(1, start);
				pstmt.setInt(2, end);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					MBoardVO bVO = new MBoardVO();
					bVO.setNo     (rs.getInt   ("no"));
					bVO.setWriter (rs.getString("writer"));
					bVO.setTitle  (rs.getString("title"));
					bVO.setRegDate(rs.getString("reg_date"));
					bVO.setViewCnt(rs.getInt("view_cnt"));
					boardList.add(bVO);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} 
			return boardList;
		}
		
		/**
		 * 전체 게시글 카운트
		 * @return
		 */
		public int selectBoardCount() {
			int totalCount = 0;
			ResultSet rs = null;
			String sql = "select count(*) cnt from b_m_board"; 
			
			try(
					Connection        conn   = new ConnectionFactory().getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql.toString());
					
					){
			
				rs = pstmt.executeQuery();
				rs.next();
				totalCount = rs.getInt("cnt");
			} catch (Exception e) {
				e.printStackTrace();
			} 
			return totalCount;
		}	


		

		  public List<MBoardVO> selectWriter(String writer) {

		      List<MBoardVO> list = new ArrayList<>();
		      MBoardVO vo = null;
		      StringBuilder sql = new StringBuilder();
		      
		      sql.append("select no, title, writer, ");
		      sql.append("	   to_char(reg_date, 'yyyy-mm-dd') as reg_date, view_cnt ");
		      sql.append(" from b_m_board ");
		      sql.append("  where writer = ?   ");

		      try (
		    		Connection conn = new ConnectionFactory().getConnection();
		            PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		      ) {
		    	  
		         pstmt.setString(1, writer);
		         
		         ResultSet rs = pstmt.executeQuery();
		         
		         while (rs.next()) {
		        	
		            vo = new MBoardVO();

		            vo.setNo(rs.getInt("no"));
		            vo.setTitle(rs.getString("title"));
		            vo.setWriter(rs.getString("writer"));
		            vo.setRegDate(rs.getString("reg_date"));
		            vo.setViewCnt(rs.getInt("view_cnt"));
		            	
		            list.add(vo);

		         }

		      } catch (Exception e) {
		         e.printStackTrace();
		      }

		      return list;
		   }
		  
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	

















	
