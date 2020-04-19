package kr.co.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.bit.notice.vo.NoticeVO;
import kr.co.bit.util.ConnectionFactory;

public class NoticeDAO {
	
	public List<NoticeVO> selectAll(){
		
		List<NoticeVO> list = new ArrayList<>();
		NoticeVO vo = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select no, title, writer, to_char(reg_date, 'yyyy-mm-dd') as reg_date, view_cnt ");
		sql.append(" from b_notice ");
		
		
		try(
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		
		){
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo = new NoticeVO();
				
				vo.setNo(rs.getInt("no"));
				vo.setTitle(rs.getString("title"));
				vo.setWriter(rs.getString("writer"));
				vo.setRegDate(rs.getString("reg_date"));
				vo.setViewCnt(rs.getInt("view_cnt"));
				
				list.add(vo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

}
