package kr.co.bit.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.bit.board.vo.BoardFileVO;
import kr.co.bit.board.vo.BoardVO;
import kr.co.bit.board.vo.CommentVO;
import kr.co.bit.util.ConnectionFactory;

public class BoardDAO {

	public List<BoardVO> selectAllBoard() {
		List<BoardVO> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT type, no, title, writer, to_char(reg_date, 'yyyy-mm-dd') as reg_date, re FROM t1_board ORDER BY no DESC ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardVO board = new BoardVO();

				String type = rs.getString("type");
				int no = rs.getInt("no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String regDate = rs.getString("reg_date");
				int re = rs.getInt("re");

				board.setType(type);
				board.setNo(no);
				board.setTitle(title);
				board.setWriter(writer);
				board.setRegDate(regDate);
				board.setRe(re);

				list.add(board);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<BoardVO> selectBoardByType(String boardType) {
		List<BoardVO> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT type, no, title, writer, to_char(reg_date, 'yyyy-mm-dd') as reg_date, re FROM t1_board ");
		sql.append(" WHERE type = ? ");
		sql.append(" order by no desc ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {
			int loc = 1;
			pstmt.setString(loc++, boardType);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardVO board = new BoardVO();
				board.setType(rs.getString("type"));
				board.setNo(rs.getInt("no"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setRegDate(rs.getString("reg_date"));
				board.setRe(rs.getInt("re"));

				list.add(board);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	

	/*public List<ReplyVO> selectReplyByType(String boardType) {
		List<ReplyVO> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("select r_no, type, no, title, writer, to_char(reg_date, 'yyyy-mm-dd') as reg_date, re ");
		sql.append(" from t1_reply ");
		sql.append(" where type = ? ");
		sql.append(" order by no desc, re asc ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {
			int loc = 1;
			pstmt.setString(loc++, boardType);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				ReplyVO reply = new ReplyVO();

				reply.setRno(rs.getInt("r_no"));
				reply.setType(rs.getString("type"));
				reply.setNo(rs.getInt("no"));
				reply.setTitle(rs.getString("title"));
				reply.setWriter(rs.getString("writer"));
				reply.setRegDate(rs.getString("reg_date"));
				reply.setRe(rs.getInt("re"));

				list.add(reply);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}*/

	public BoardVO selectBoard(int no) {
		BoardVO board = new BoardVO();
		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT type, b_no, no, content, title, writer, view_cnt, to_char(reg_date, 'yyyy-mm-dd') as reg_date, re FROM t1_board ");
		sql.append(" WHERE no = ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			int loc = 1;
			pstmt.setInt(loc++, no);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				board.setType(rs.getString("type"));
				board.setbNo(rs.getInt("b_no"));
				board.setNo(rs.getInt("no"));
				board.setContent(rs.getString("content"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setViewCnt(rs.getInt("view_cnt"));
				board.setRegDate(rs.getString("reg_date"));
				board.setRe(rs.getInt("re"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return board;

	}

	/*
	 * public ReplyVO selectByRe(int no) { ReplyVO reply = null;
	 * 
	 * StringBuilder sql = new StringBuilder();
	 * sql.append("select title, writer, content, view_cnt, ");
	 * sql.append(" to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
	 * sql.append(" from t1_reply "); sql.append(" where no = ? "); try( Connection
	 * conn = new ConnectionFactory().getConnection(); PreparedStatement pstmt =
	 * conn.prepareStatement(sql.toString()); ) { pstmt.setInt(1, no); ResultSet rs
	 * = pstmt.executeQuery();
	 * 
	 * if(rs.next()) { reply = new ReplyVO();
	 * 
	 * board.setTitle(rs.getString("title"));
	 * board.setWriter(rs.getString("writer"));
	 * board.setContent(rs.getString("content"));
	 * board.setViewCnt(rs.getInt("view_cnt"));
	 * board.setRegDate(rs.getString("reg_date")); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } return board;
	 * 
	 * }
	 */
	public List<BoardFileVO> selectFile(int no) {

		List<BoardFileVO> flist = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT f_no, board_no, ori_name, save_name, file_size FROM t1_file ");
		sql.append(" WHERE board_no = ? ");
		sql.append("ORDER BY f_no ASC ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			int loc = 1;
			pstmt.setInt(loc++, no);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardFileVO file = new BoardFileVO();
				file.setNo(rs.getInt("f_no"));
				file.setBoardNo(rs.getInt("board_no"));
				file.setOriName(rs.getString("ori_name"));
				file.setSaveName(rs.getString("save_name"));
				file.setFileSize(rs.getInt("file_size"));

				flist.add(file);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return flist;

	}

	public List<CommentVO> selectAllCommentByNo(int no) {
		List<CommentVO> list = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT c_no, board_no, writer, content, to_char(reg_date, 'yyyy-mm-dd') as reg_date FROM t1_comment ");
		sql.append(" WHERE board_no= ?");
		sql.append(" ORDER BY c_no ASC ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			int loc = 1;
			pstmt.setInt(loc++, no);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				CommentVO comment = new CommentVO();
				comment.setcNo(rs.getInt("c_no"));
				comment.setBoardNo(rs.getInt("board_no"));
				comment.setWriter(rs.getString("writer"));
				comment.setContent(rs.getString("content"));
				comment.setRegDate(rs.getString("reg_date"));

				list.add(comment);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public CommentVO selectCommentByNo(int no) {
		CommentVO comment = new CommentVO();
		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT c_no, board_no, writer, content, to_char(reg_date, 'yyyy-mm-dd') as reg_date FROM t1_comment ");
		sql.append(" WHERE c_no= ?");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			int loc = 1;
			pstmt.setInt(loc++, no);
			ResultSet rs = pstmt.executeQuery();

			comment.setcNo(rs.getInt("c_no"));
			comment.setBoardNo(rs.getInt("board_no"));
			comment.setWriter(rs.getString("writer"));
			comment.setContent(rs.getString("content"));
			comment.setRegDate(rs.getString("reg_date"));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return comment;

	}

	public int selectNo() {
		int no = 0;
		String sql = "select seq_t1_board_no.nextval from dual";
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			no = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return no;
	}

	public void insert(BoardVO board) {

		StringBuilder sql = new StringBuilder();
		sql.append("insert into t1_board( ");
		sql.append(" type, no, title, writer, content, b_no ");
		sql.append(" ) values ( ");
		sql.append(" ?, ?, ?, ?, ?, ? ");
		sql.append(") ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			int loc = 1;
			pstmt.setString(loc++, board.getType());
			pstmt.setInt(loc++, board.getNo());
			pstmt.setString(loc++, board.getTitle());
			pstmt.setString(loc++, board.getWriter());
			pstmt.setString(loc++, board.getContent());
			pstmt.setInt(loc++, board.getNo());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertComment(CommentVO comment) {
		StringBuilder sql = new StringBuilder();
		sql.append("INSERT INTO t1_comment( c_no, board_no, writer, content ) ");
		sql.append(" VALUES( seq_t1_comment_no.nextval, ?, ?, ? ) ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			int loc = 1;
			pstmt.setInt(loc++, comment.getBoardNo());
			pstmt.setString(loc++, comment.getWriter());
			pstmt.setString(loc++, comment.getContent());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertReply(BoardVO reply) {

		StringBuilder sql = new StringBuilder();
		sql.append("insert into t1_board( ");
		sql.append(" no, b_no, title, writer, content, type, re ");
		sql.append(" ) values ( ");
		sql.append(" ?, ?, ?, ?, ?, ?, seq_t1_board_re.nextval ");
		sql.append(" ) ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			int loc = 1;
			pstmt.setInt(loc++, reply.getNo());
			pstmt.setInt(loc++, reply.getbNo());
			pstmt.setString(loc++, reply.getTitle());
			pstmt.setString(loc++, reply.getWriter());
			pstmt.setString(loc++, reply.getContent());
			pstmt.setString(loc++, reply.getType());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertFile(BoardFileVO fileVO) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into t1_file( ");
		sql.append(" f_no, board_no, ori_name, ");
		sql.append(" save_name, file_size ");
		sql.append(" ) values( ");
		sql.append(" seq_t1_file_no.nextval, ?, ?, ?, ? ");
		sql.append(" ) ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			int loc = 1;
			pstmt.setInt(loc++, fileVO.getBoardNo());
			pstmt.setString(loc++, fileVO.getOriName());
			pstmt.setString(loc++, fileVO.getSaveName());
			pstmt.setInt(loc++, fileVO.getFileSize());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void updateComment(CommentVO comment) {
		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE t1_comment SET content = ? ");
		sql.append(" WHERE c_no= ?");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			int loc = 1;
			pstmt.setString(loc++, comment.getContent());
			pstmt.setInt(loc++, comment.getcNo());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteFile(int no) {

		StringBuilder sql = new StringBuilder();
		sql.append("delete from t1_file where board_no =? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			int loc = 1;
			pstmt.setInt(loc++, no);

			pstmt.executeUpdate();

		} catch (Exception e) {

		}
	}

	public void deleteComment(int no) {
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM t1_comment WHERE c_no = ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			int loc = 1;
			pstmt.setInt(loc++, no);

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void delete(int no) {

		StringBuilder sql = new StringBuilder();
		sql.append("delete from t1_board where no =? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			int loc = 1;
			pstmt.setInt(loc++, no);

			pstmt.executeUpdate();

		} catch (Exception e) {

		}
	}

	public void updateCount(BoardVO board) {

		StringBuilder sql = new StringBuilder();
		sql.append("UPDATE t1_board ");
		sql.append("SET view_cnt = view_cnt + 1 ");
		sql.append("WHERE no = ? ");

		try (
				// AutoCloseable 상속받기 때문에 에러 x
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setInt(1, board.getNo());

			// 테이블 데이터 수정
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int selectCountByType(String type) {

		int no = 0;

		String sql = "SELECT COUNT(*) FROM t1_board where type= ? ";

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);

		) {
			pstmt.setString(1, type);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				no = rs.getInt(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return no;
	}

	public List<BoardVO> selectPartBoardByType(String type, int startRow, int size) throws SQLException {

		List<BoardVO> result = new ArrayList<>();
		StringBuilder sql = new StringBuilder();
		sql.append(" select * from ( select rownum rnum, b.* ");
		sql.append(" from ( select a.* ");
		sql.append(" from t1_board a ");
		sql.append(" where type= ? ");
		sql.append(" order by b_no desc, re asc ) b )");
		sql.append(" where rnum >= ? ");
		sql.append(" and rnum <= ? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {

			pstmt.setString(1, type);
			pstmt.setInt(2, startRow + 1);
			pstmt.setInt(3, startRow + size );
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardVO board = new BoardVO();
				board.setNo(rs.getInt("no"));
				board.setbNo(rs.getInt("b_no"));
				board.setTitle(rs.getString("title"));
				board.setWriter(rs.getString("writer"));
				board.setRegDate(rs.getString("reg_date"));
				board.setRe(rs.getInt("re"));

				result.add(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}
	
/*	public BoardVO convertReplyToBoard(ReplyVO reply){
		
		BoardVO board = new BoardVO();
			
			board.setNo(0);
			board.setRe(reply.getRe());
			board.setTitle(reply.getTitle());
			board.setWriter(reply.getWriter());
			board.setContent(reply.getContent());
			board.setViewCnt(reply.getViewCnt());
			board.setRegDate(reply.getRegDate());
			board.setType(reply.getType());
			
	return board;

}*/
	
	// 글쓴이(id)에 따른 게시글 조회 서비스
		public List<BoardVO> selectByIdBoard(String id) {
			
			List<BoardVO> list = new ArrayList<>();
			BoardVO board = null;
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT no, title, writer, ");
			sql.append("		to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
			sql.append("FROM t1_board ");
			sql.append("WHERE writer = ? ");
			sql.append("ORDER BY no DESC ");
			
			try(
					// AutoCloseable 상속받기 때문에 에러 x
					Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			) {
				pstmt.setString(1, id);
				
				ResultSet rs = pstmt.executeQuery();
				
				while (rs.next()) {
					board = new BoardVO();
					
					board.setNo(rs.getInt("no"));
					board.setTitle(rs.getString("title"));
					board.setWriter(rs.getString("writer"));
					board.setRegDate(rs.getString("reg_date"));
					
					list.add(board);
				}
			} catch (Exception e) { e.printStackTrace(); }
			
			return list;
		}
	
		// 게시물 번호에 따른 조회 서비스
		public BoardVO selectByNo(int no) {
			
			BoardVO board = null;
			
			StringBuilder sql = new StringBuilder();
			sql.append("SELECT no, title, writer, content, view_cnt, ");
		 	sql.append("		to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
		 	sql.append("FROM t1_board ");
		 	sql.append("WHERE no = ? ");
		 	
			try(
					// AutoCloseable 상속받기 때문에 에러 x
					Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){
				pstmt.setInt(1, no);
				
				ResultSet rs = pstmt.executeQuery();
				
				while (rs.next()) {
					board = new BoardVO();
					
					board.setTitle(rs.getString("title"));
					board.setWriter(rs.getString("writer"));
					board.setContent(rs.getString("content"));
					board.setViewCnt(rs.getInt("view_cnt"));
					board.setRegDate(rs.getString("reg_date"));
				}
				
			} catch (Exception e) { e.printStackTrace(); }
			
			return board;
		}
	

		// 게시물 수정 
		public void update(BoardVO board) {
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE t_board SET title = ?, content = ? ");
			sql.append(" WHERE no= ?");
			
			
			
			try(
					Connection conn = new ConnectionFactory().getConnection();
					PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){
				int loc = 1;
				pstmt.setString(loc++, board.getTitle());
				pstmt.setString(loc++, board.getContent());
				pstmt.setInt(loc++, board.getNo());
				
				pstmt.executeUpdate();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			
		}
}
