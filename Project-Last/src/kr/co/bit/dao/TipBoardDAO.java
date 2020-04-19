package kr.co.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.bit.TipBoard.vo.TBoardComVO;
import kr.co.bit.TipBoard.vo.TBoardFileVO;
import kr.co.bit.TipBoard.vo.TBoardRepVO;
import kr.co.bit.TipBoard.vo.TBoardVO;
import kr.co.bit.util.ConnectionFactory;

public class TipBoardDAO {

	public List<TBoardVO> selectAll() {

	      List<TBoardVO> list = new ArrayList<>();
	      TBoardVO vo = null;
	      StringBuilder sql = new StringBuilder();
	      
	      sql.append("select no, title, writer, ");
	      sql.append("	   to_char(reg_date, 'yyyy-mm-dd') as reg_date, view_cnt ");
	      sql.append(" from b_t_board   ");
	      

	      try (
	    		Connection conn = new ConnectionFactory().getConnection();
	            PreparedStatement pstmt = conn.prepareStatement(sql.toString());

	      ) {
	         ResultSet rs = pstmt.executeQuery();

	         while (rs.next()) {
	            vo = new TBoardVO();

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

	   
	  // 팁 게시판 글 등록 
	 public void insertTBoard(TBoardVO tvo) {
		 
		 StringBuilder sql = new StringBuilder();
		 
		 sql.append(" insert into b_t_board( no, title, content, writer ) ");
		 sql.append(" values( seq_b_t_board_no.NEXTVAL,?, ?, ? ) ");
		 
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			int loc=1;
			
			pstmt.setString(loc++, tvo.getTitle());
			pstmt.setString(loc++, tvo.getContent());
			pstmt.setString(loc++, tvo.getWriter());
			pstmt.executeQuery();
			 
		} catch(Exception e) {
			 e.printStackTrace();
		}
		 
	 }
	 
	 // 글등록시 생성글 no 받아오기 (파일업로드시 no(fk) 필요하므로)
	  public TBoardVO selectBoardInfo(String writer) {
		  
		  TBoardVO tvo = new TBoardVO();
		  
		  StringBuilder sql = new StringBuilder();
		  
		  sql.append(" select no, title, content, writer  ");
		  sql.append(" from b_t_board  ");
		  sql.append(" where writer = ? ");
		  
		  try(
				  Connection conn = new ConnectionFactory().getConnection();
				  PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		  ) {
			  int loc=1;
			  pstmt.setString(loc++, writer);
			  ResultSet rs = pstmt.executeQuery();
			  if(rs.next()) {
				  tvo.setNo(rs.getInt("no"));
			  }
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  return tvo;
	  }
	   
	  // no에 해당하는 게시글 받아오기(디테일)
	  public TBoardVO selectBoardByNo(int no) {
		  
		  TBoardVO tvo = new TBoardVO();
		  
		  StringBuilder sql = new StringBuilder();
		  
		  sql.append(" select no, title, content, writer, ");
		  sql.append("	   to_char(reg_date, 'yyyy-mm-dd') as reg_date, view_cnt ");
		  sql.append(" from b_t_board  ");
		  sql.append(" where no = ? ");
		  
		  try(
				  Connection conn = new ConnectionFactory().getConnection();
				  PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		  ) {
			  int loc=1;
			  pstmt.setInt(loc++, no);
			  ResultSet rs = pstmt.executeQuery();
			  if(rs.next()) {
				  tvo.setWriter(rs.getString("writer"));
				  tvo.setTitle(rs.getString("title"));
				  tvo.setViewCnt(rs.getInt("view_cnt"));
				  tvo.setContent(rs.getString("content"));
				  tvo.setNo(rs.getInt("no"));
				  tvo.setRegDate(rs.getString("reg_date"));
			  }
		  }catch(Exception e) {
			  e.printStackTrace();
		  }
		  
		  return tvo;
	  }
	  
	  // no 에 해당하는 글 viewCnt 증가
		public void viewCntPlus(int no,int viewNo) {
			  
			  StringBuilder sql = new StringBuilder();
			  
			  sql.append("  update b_t_board set view_cnt = ?  ");
			  sql.append("  where no = ?  ");
			  
			  try(
					 Connection conn = new ConnectionFactory().getConnection(); 
					 PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			  ){
				  	int loc = 1;
				  	pstmt.setInt(loc++, viewNo);
				  	pstmt.setInt(loc++, no);
				  	pstmt.executeUpdate();
				  
			  } catch (Exception e) {
				  e.printStackTrace();
			  }
			  
		  }
	  
	  
	  // no에 해당하는 글삭제
	  public void deleteByNo(int no) {
		  
		  StringBuilder sql = new StringBuilder();
		  
		  sql.append("  delete b_t_board  ");
		  sql.append("  where no = ?  ");
		  
		  try(
				 Connection conn = new ConnectionFactory().getConnection(); 
				 PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		  ){
			  	int loc = 1;
			  	pstmt.setInt(loc++, no);
			  	pstmt.executeUpdate();
			  
		  } catch (Exception e) {
			  e.printStackTrace();
		  }
		  
	  }
  
  
//글쓴이로 게시물 검색하기 
  
  public List<TBoardVO> selectWriter(String writer) {

      List<TBoardVO> list = new ArrayList<>();
      TBoardVO vo = null;
      StringBuilder sql = new StringBuilder();
      
      sql.append("select no, title, writer, ");
      sql.append("	   to_char(reg_date, 'yyyy-mm-dd') as reg_date, view_cnt ");
      sql.append(" from b_t_board ");
      sql.append("  where writer = ?   ");

      try (
    		Connection conn = new ConnectionFactory().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql.toString());

      ) {
    	  
         pstmt.setString(1, writer);
         
         ResultSet rs = pstmt.executeQuery();
         
         while (rs.next()) {
        	
            vo = new TBoardVO();

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
  
  
			
		// 글 수정시 no찾아 업데이트
		public void reWriteUp(TBoardVO tvo) {
			
			 StringBuilder sql = new StringBuilder();
			 
			 sql.append(" update b_t_board  ");
			 sql.append(" set title = ?, content = ? ");
			 sql.append(" where no = ?   ");
			 
				try(
					Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql.toString())
				) {
					int loc=1;
					pstmt.setString(loc++, tvo.getTitle());
					pstmt.setString(loc++, tvo.getContent());
					pstmt.setInt(loc++, tvo.getNo());
					
					pstmt.executeUpdate();
					
				} catch(Exception e) {
					e.printStackTrace();
				}
				
				
			}

  
  
  
  ////////////////////////// 파일 CRUD ///////////////////////////////////////

  // 글 등록시 (no)fk 받아 파일 등록
 public void insertTBoardFile(TBoardFileVO tfileVO) {
	  
	  StringBuilder sql = new StringBuilder();
	  
	  sql.append(" insert into b_t_board_file  ");
     sql.append("  (no,file_no, file_ori_name, file_save_name,file_size ) ");
     sql.append("  values(b_t_board_file_SEQ_no.NEXTVAL,?,?,?,? ) ");
	  
	  try(
			  Connection conn = new ConnectionFactory().getConnection();
			  PreparedStatement pstmt = conn.prepareStatement(sql.toString());
	  ) {
		  		
		  		int loc=1;
		  		pstmt.setInt(loc++, tfileVO.getFileNo());
		  		pstmt.setString(loc++, tfileVO.getFileOriName());
		  		pstmt.setString(loc++, tfileVO.getFileSaveName());
		  		pstmt.setInt(loc++, tfileVO.getFileSize());
		  		
		  		pstmt.executeUpdate();
		  		
	  } catch(Exception e) {
		  e.printStackTrace();
	  }
	  
 }
  
  
  
  
  // no에 해당하는 게시글 사진파일 받아오기(디테일)
 	public List<TBoardFileVO> selectTFileByNo(int no) {
	  
 	List<TBoardFileVO> fileList = new ArrayList<>();
	  StringBuilder sql = new StringBuilder();
	  
	  sql.append(" select no, file_ori_name, file_save_name, file_size ");
	  sql.append(" from b_t_board_file ");
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
  
  ///////////////////////////////PAGING 관련 DAO///////////////////////////////////
private static final int LIST_SIZE = 5;
	

	public List<TBoardVO> selectBoard() {
	
	
		
		List<TBoardVO> boardList = new ArrayList<TBoardVO>();
		String sql = 
			"select no, writer, title, to_char(reg_date, 'yyyy-mm-dd') reg_date  " +
			"  from b_t_board                                                      " +
			" order by no desc                                                   ";
		
		try (
				Connection    conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				
			){
		
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				TBoardVO bVO = new TBoardVO();
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
	public List<TBoardVO> selectBoard(int pageNo) {
		int start = (pageNo -1) * LIST_SIZE + 1;
		int end   = pageNo      * LIST_SIZE;
		
		List<TBoardVO> boardList = new ArrayList<TBoardVO>();
		String sql = 
			"select no, writer, title, to_char(reg_date, 'yyyy-mm-dd') reg_date , view_cnt  " +
			"  from ( select rownum rnum, b.*                 " +
			"		   from ( select a.*                      " +
			"		 		    from b_t_board a                " +
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
				TBoardVO bVO = new TBoardVO();
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
		String sql = "select count(*) cnt from b_t_board"; 
		
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
	// 답글 저장
			public void insertCom(TBoardComVO tcvo) {
				
				StringBuilder sql = new StringBuilder();
				
				sql.append(" insert into b_t_board_com(no, comment_no, writer, title, content) ");
				sql.append(" values( b_t_board_com_SEQ.nextval, ?, ?, ?, ? )");
				
				try {
					
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				
				int col=1;
				
				pstmt.setInt(col++, tcvo.getCommentNo());
				pstmt.setString(col++, tcvo.getWriter());
				pstmt.setString(col++, tcvo.getTitle());
				pstmt.setString(col++, tcvo.getContent());
				
				pstmt.executeUpdate();
				
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			// 답글 목록 불러오기
			public List<TBoardComVO> selectComAll(){
				
				List<TBoardComVO> tlist = new ArrayList<>();
				TBoardComVO tcvo = null;
				
				StringBuilder sql = new StringBuilder();
				
				sql.append(" select no, title, comment_no ");
				sql.append(" from b_t_board_com ");
				
				try {
					Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql.toString());
					
					ResultSet rs = pstmt.executeQuery();
					
					while(rs.next()) {
						tcvo = new TBoardComVO();
						tcvo.setNo(rs.getInt("no"));
						tcvo.setTitle(rs.getString("title"));
						tcvo.setCommentNo(rs.getInt("comment_no"));
						
						tlist.add(tcvo);
					}
				}catch(Exception e) {
					e.printStackTrace();
				}
				return tlist;
			}
			
			// 답글 번호로 답글 상세 보기
			public TBoardComVO selectComNo(int no) {
				
				TBoardComVO tcvo = null;
				StringBuilder sql = new StringBuilder();
				
				sql.append(" select no, title, writer, content, view_cnt, to_char(reg_date, 'yy-mm-dd') as reg_date ");
				sql.append(" from b_t_board_com");
				sql.append(" where no=? ");
				
				try {
					Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql.toString());
					
					pstmt.setInt(1, no);
					
					ResultSet rs = pstmt.executeQuery();
					rs.next();
					
					tcvo = new TBoardComVO();
					
					tcvo.setNo(rs.getInt("no"));
					tcvo.setTitle(rs.getString("title"));
					tcvo.setWriter(rs.getString("writer"));
					tcvo.setContent(rs.getString("content"));
					tcvo.setViewCnt(rs.getInt("view_cnt"));
					tcvo.setRegDate(rs.getString("reg_date"));
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				return tcvo;
			}
			
			// 답글 번호 받아서 삭제
			public void delCom(int no) {
				
				StringBuilder sql = new StringBuilder();
				sql.append(" delete b_t_board_com ");
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
			public void insertRep(TBoardRepVO rvo) {
				
				StringBuilder sql = new StringBuilder();
				sql.append(" insert into b_t_board_rep(no, reply_no, writer, content)");
				sql.append(" values( b_t_board_rep_SEQ.nextval, ?, ?, ?) ");
				
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
			public List<TBoardRepVO> SelectRepAll(int no){
				
				List<TBoardRepVO> rlist = new ArrayList<>();
				TBoardRepVO trvo = null;
				
				StringBuilder sql = new StringBuilder();
				sql.append(" select no, writer, content, to_char(reg_date, 'yy-mm-dd') as reg_date ");
				sql.append(" from b_t_board_rep ");
				sql.append(" where reply_no = ?");
				sql.append(" order by no");
				
				try {
					
					Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql.toString());
					pstmt.setInt(1, no);
					
					ResultSet rs = pstmt.executeQuery();

					while(rs.next()) {
						trvo = new TBoardRepVO();
						
						trvo.setNo(rs.getInt("no"));
						trvo.setWriter(rs.getString("writer"));
						trvo.setContent(rs.getString("content"));
						trvo.setRegDate(rs.getString("reg_date"));
						
						rlist.add(trvo);
					}
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				
				return rlist;
			}
			// 댓글 번호 받아서 댓글 삭제
			public void delRep(int no) {
				
				StringBuilder sql = new StringBuilder();
				sql.append(" delete b_t_board_rep ");
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

	
	
	
	
   
}