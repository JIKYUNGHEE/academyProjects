package kr.co.bit.like.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.bit.like.vo.LikeFileVO;
import kr.co.bit.like.vo.LikeVO;
import kr.co.bit.like.vo.ReplyVO;
import kr.co.bit.util.ConnectionFactory;

public class LikeDAO {

	public List<LikeVO> selectAll() {
		
		List<LikeVO> list = new ArrayList<>();
		LikeVO like = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select like_no, id, pname, pintro, title from t_like ");
		
		
		
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				
				){
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				like = new LikeVO();
				like.setLike_no(rs.getInt("like_no"));
				like.setId(rs.getString("id"));
				like.setpName(rs.getString("pname"));
				like.setpIntro(rs.getString("pintro"));
				like.setTitle(rs.getString("title"));
				
				
				list.add(like);
			
			}
					
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public List<LikeFileVO> selectFileAll() {
		List<LikeFileVO> list = new ArrayList<>();
		LikeFileVO fileVO = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select no, like_no, oriname, savename, fsize from t_like_file order by like_no desc");
		
		
		
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				
				){
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				fileVO = new LikeFileVO();
				fileVO.setNo(rs.getInt("no"));
				fileVO.setLike_no(rs.getInt("like_no"));
				fileVO.setOriname(rs.getString("oriname"));
				fileVO.setSavename(rs.getString("savename"));
				fileVO.setFsize(rs.getInt("fsize"));
				
				list.add(fileVO);
			
			}
					
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	
	

	public int selectNo() {
		
		String sql = "select seq_t_like_no.nextval from dual";
		int no=0;
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				){
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			no = rs.getInt(1);
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return no;
	}
	
	public void insert(LikeVO like) {

		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_like( like_no, id, pname, pintro, title) values( ");
		sql.append(" ?, ?, ?, ?, ? )");

		try (Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		) {
			
			int loc =1;
			pstmt.setInt(loc++, like.getLike_no());
			pstmt.setString(loc++, like.getId());
			pstmt.setString(loc++, like.getpName());
			pstmt.setString(loc++, like.getpIntro());
			pstmt.setString(loc++, like.getTitle());
			
			pstmt.executeUpdate();

		} catch (Exception e) {

		}

	}
	
	public void insertFile(LikeFileVO fileVO)
	{
		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_like_file(no, like_no, oriname, savename, fsize) ");
		sql.append(" values( seq_t_like_file_no.nextval,?,?,?,? )" );
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				
				){
			
				int loc =1;
				pstmt.setInt(loc++, fileVO.getLike_no());
				pstmt.setString(loc++, fileVO.getOriname());
				pstmt.setString(loc++, fileVO.getSavename());
				pstmt.setInt(loc++, fileVO.getFsize());
			
				pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public LikeVO selectOne(int like_no) {

		LikeVO like=null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select like_no, id, pname, pintro, title from t_like where like_no=?");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				
				){
			pstmt.setInt(1, like_no);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next())
			{
				like = new LikeVO();
				
				like.setLike_no(rs.getInt("like_no"));
				like.setId(rs.getString("id"));
				like.setpName(rs.getString("pname"));
				like.setpIntro(rs.getString("pintro"));
				like.setTitle(rs.getString("title"));
				
			}
			
		}catch(Exception e) {
			
			
		}
		
		return like;
	}

	public LikeFileVO selectFileOne(int like_no) {
		
		LikeFileVO fileVO = null;
		StringBuilder sql = new StringBuilder();
		sql.append(" select no, like_no, oriname, savename, fsize from t_like_file where like_no=? ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			
			pstmt.setInt(1, like_no);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				fileVO = new LikeFileVO();
				int loc = 1;
				
				fileVO.setNo(rs.getInt(loc++));
				fileVO.setLike_no(rs.getInt(loc++));
				fileVO.setOriname(rs.getString(loc++));
				fileVO.setSavename(rs.getString(loc++));
				fileVO.setFsize(rs.getInt(loc++));
				
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return fileVO;
	}

	public void delete(int like_no) {

		StringBuilder sql = new StringBuilder();
		sql.append(" delete from t_like where like_no=?");
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				
				){

			pstmt.setInt(1, like_no);
			pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
	}

	public List<ReplyVO> ajaxProcess(int like_no) {
		List<ReplyVO> list = new ArrayList<>();
		ReplyVO vo = null;
		
		StringBuilder sql = new StringBuilder();
		
		sql.append(" select no, like_no, id, content, nickname from t_like_reply where like_no=? order by no asc ");
		
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				
				){
				pstmt.setInt(1, like_no);
				
				ResultSet rs = pstmt.executeQuery();
				while(rs.next())
				{
					vo = new ReplyVO();
					
					vo.setNo(rs.getInt("no"));
					vo.setLike_no(rs.getInt("like_no"));
					vo.setId(rs.getString("id"));
					vo.setContent(rs.getString("content"));
					vo.setNickname(rs.getNString("nickname"));
					
					list.add(vo);
					
				}
			
		}catch(Exception e) {
			
		}
		
		
		
		
		return list;
		
		
		
		
	}


public void ajaxInsert(ReplyVO reply) {
	
		StringBuilder sql = new StringBuilder();
		
	sql.append(" insert into t_like_reply(no, like_no, id, content, nickname) values( ");
	sql.append(" seq_t_like_reply_no.nextval,?, ?, ?, ?) ");
	
	
	try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			
			){
		
		pstmt.setInt(1, reply.getLike_no());
		pstmt.setString(2, reply.getId());
		pstmt.setString(3, reply.getContent());
		pstmt.setString(4, reply.getNickname());
		
		pstmt.executeUpdate();
		
		
	}catch(Exception e) {
		
	}

}
	

public List<LikeVO> getList(int startRow, int endRow) {
	// 페이징 처리를 위한 sql / 인라인뷰, rownum 사용
	String sql = "select * from "
			+ "(select rownum rn, like_no, id, pname, pintro, title from "
			+ "(select * from t_like order by like_no desc)) where rn between ? and ?";
	List<LikeVO> list = new ArrayList<>();
	try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			){
		pstmt.setInt(1, startRow); // sql 물음표에 값 매핑
		pstmt.setInt(2, endRow);
		ResultSet rs = pstmt.executeQuery(); // sql 실행
		
					// 반복할 때마다 ExboardDTO 객체를 생성 및 데이터 저장
			while (rs.next()) 
			{
				LikeVO like = new LikeVO();
				
				like.setLike_no(rs.getInt("like_no"));
				like.setId(rs.getString("id"));
				like.setpName(rs.getString("pname"));
				like.setpIntro(rs.getString("pintro"));
				like.setTitle(rs.getString("title"));
				

				list.add(like); // list에 0번 인덱스부터 board 객체의 참조값을 저장
			} ;
		
	} catch (Exception e) {
		e.printStackTrace();
	} 
	
	return list; // list 반환
}

public int getCount(){
	int count = 0;
	String sql = "select count(*) from t_like";
	try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
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

public void deleteReply(int reply_no) {
	
	
	String sql = " delete from t_like_reply where no=?"; 
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
