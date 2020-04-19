package kr.co.bit.walk.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.bit.util.ConnectionFactory;
import kr.co.bit.walk.vo.ReplyVO;
import kr.co.bit.walk.vo.WalkFileVO;
import kr.co.bit.walk.vo.WalkVO;

public class WalkDAO {

	public List<WalkVO> selectAll() {

		List<WalkVO> list = new ArrayList<>();
		WalkVO walk = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select walk_no, title, content, to_char(reg_date,'yyyy-mm-dd hh:mi:ss') as reg_date from t_walk ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				walk = new WalkVO();
				walk.setWalk_no(rs.getInt("walk_no"));
				walk.setTitle(rs.getString("title"));
				walk.setContent(rs.getString("content"));
				walk.setReg_date(rs.getString("reg_date"));

				list.add(walk);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	public List<WalkFileVO> selectFileAll() {
		List<WalkFileVO> list = new ArrayList<>();
		WalkFileVO fileVO = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select file_no, walk_no, oriname, savename, fsize from t_walk_file order by walk_no desc");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				fileVO = new WalkFileVO();
				fileVO.setFile_no(rs.getInt("file_no"));
				fileVO.setWalk_no(rs.getInt("walk_no"));
				fileVO.setOriname(rs.getString("oriname"));
				fileVO.setSavename(rs.getString("savename"));
				fileVO.setFsize(rs.getInt("fsize"));

				list.add(fileVO);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;

	}

	public int selectNo() {

		String sql = "select seq_t_walk_no.nextval from dual";
		int no = 0;
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

	public void insert(WalkVO walk) {

		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_walk( walk_no, title, content) values( ");
		sql.append(" ?, ?, ? )");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {

			int loc = 1;
			pstmt.setInt(loc++, walk.getWalk_no());
			pstmt.setString(loc++, walk.getTitle());
			pstmt.setString(loc++, walk.getContent());

			pstmt.executeUpdate();

		} catch (Exception e) {

		}

	}

	public void insertFile(WalkFileVO fileVO) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_walk_file(file_no, walk_no, oriname, savename, fsize) ");
		sql.append(" values( seq_t_walk_file_no.nextval,?,?,?,? )");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {

			int loc = 1;
			pstmt.setInt(loc++, fileVO.getWalk_no());
			pstmt.setString(loc++, fileVO.getOriname());
			pstmt.setString(loc++, fileVO.getSavename());
			pstmt.setInt(loc++, fileVO.getFsize());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public WalkVO selectOne(int walk_no) {

		WalkVO walk = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select walk_no, title, content, reg_date from t_walk where walk_no=?");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {
			pstmt.setInt(1, walk_no);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				walk = new WalkVO();

				walk.setWalk_no(rs.getInt("walk_no"));
				walk.setTitle(rs.getString("title"));
				walk.setContent(rs.getString("content"));
				walk.setReg_date(rs.getString("reg_date"));

			}

		} catch (Exception e) {

		}

		return walk;
	}

	public WalkFileVO selectFileOne(int walk_no) {

		WalkFileVO fileVO = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select file_no, walk_no, oriname, savename, fsize from t_walk_file where walk_no=? ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {

			pstmt.setInt(1, walk_no);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				fileVO = new WalkFileVO();
				int loc = 1;

				fileVO.setFile_no(rs.getInt(loc++));
				fileVO.setWalk_no(rs.getInt(loc++));
				fileVO.setOriname(rs.getString(loc++));
				fileVO.setSavename(rs.getString(loc++));
				fileVO.setFsize(rs.getInt(loc++));

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return fileVO;
	}

	public void delete(int walk_no) {

		StringBuilder sql = new StringBuilder();
		sql.append(" delete from t_walk where walk_no=?");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {

			pstmt.setInt(1, walk_no);
			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public List<ReplyVO> ajaxProcess(int walk_no) {
		List<ReplyVO> list = new ArrayList<>();
		ReplyVO vo = null;

		StringBuilder sql = new StringBuilder();
		sql.append(" select reply_no, walk_no, id, reply_content, to_char(reg_date,'yyyy-mm-dd hh:mi:ss') as reg_date, nickname from t_walk_reply where walk_no=? order by reply_no asc ");

		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {
			pstmt.setInt(1, walk_no);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				vo = new ReplyVO();
				
				vo.setReply_no(rs.getInt("reply_no"));
				vo.setWalk_no(rs.getInt("walk_no"));
				vo.setId(rs.getString("id"));
				vo.setReply_content(rs.getString("reply_content"));
				vo.setReg_date(rs.getString("reg_date"));
				vo.setNickname(rs.getString("nickname"));
				vo.getId();
				list.add(vo);

			}

		} catch (Exception e) {

		}

		return list;

	}

	public void ajaxInsert(ReplyVO reply) {

		StringBuilder sql = new StringBuilder();

		sql.append(" insert into t_walk_reply(reply_no, walk_no, id, reply_content, nickname) values( ");
		sql.append(" seq_t_walk_reply_no.nextval, ?, ?, ?, ?) ");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {

			pstmt.setInt(1, reply.getWalk_no());
			pstmt.setString(2, reply.getId());
			pstmt.setString(3, reply.getReply_content());
			pstmt.setString(4, reply.getNickname());
			
			pstmt.executeUpdate();

		} catch (Exception e) {

		}

	}

	public List<WalkVO> getList(int startRow, int endRow) {
		// 페이징 처리를 위한 sql / 인라인뷰, rownum 사용
		String sql = "select * from "
				+ "(select rownum rn, walk_no, title, content, to_char(reg_date,'yyyy-mm-dd hh:mi:ss') as reg_date  from "
				+ "(select * from t_walk order by walk_no desc)) where rn between ? and ?";
		List<WalkVO> list = new ArrayList<>();
		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setInt(1, startRow); // sql 물음표에 값 매핑
			pstmt.setInt(2, endRow);
			ResultSet rs = pstmt.executeQuery(); // sql 실행

			// 반복할 때마다 WalkVO 객체를 생성 및 데이터 저장
			while (rs.next()) {
				WalkVO walk = new WalkVO();

				walk.setWalk_no(rs.getInt("walk_no"));
				walk.setTitle(rs.getString("title"));
				walk.setContent(rs.getString("content"));
				walk.setReg_date(rs.getString("reg_date"));

				list.add(walk); // list에 0번 인덱스부터 board 객체의 참조값을 저장
			}
			;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list; // list 반환
	}

	public int getCount() {
		int count = 0;
		String sql = "select count(*) from t_walk";

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {

			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return count; // 총 레코드 수 리턴
	}

	public void deleteReply(int reply_no) {
		
		
		String sql = " delete from t_walk_reply where reply_no=?"; 
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				){
			
				pstmt.setInt(1, reply_no);
				pstmt.executeUpdate();
			
		}catch(Exception e) {
			
		}
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
}

