package kr.co.bit.map.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.bit.map.vo.MapVO;
import kr.co.bit.util.ConnectionFactory;
import kr.co.bit.util.JDBCClose;

public class MapDAO {
	
	public void insertMeeting(MapVO meeting) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into t_meeting ");
		sql.append(" values ( ");
		sql.append(" ?, ?, ?, ?, ? ");
		sql.append(" ) ");
		
		try (
			Connection conn 
				= new ConnectionFactory().getConnection();
			PreparedStatement pstmt 
				= conn.prepareStatement(sql.toString());
		) {
			
			pstmt.setString(1, meeting.getMeetingTime());
			pstmt.setString(2, meeting.getParkName());
			pstmt.setString(3, meeting.getUserId());
			pstmt.setString(4, meeting.getUserNickname());
			pstmt.setString(5, meeting.getFileSaveName());
							
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteMeeting(MapVO meeting) {
		StringBuilder sql = new StringBuilder();
		sql.append("delete from t_meeting ");
		sql.append(" where ");
		sql.append(" parkName = ? and ");
		sql.append(" userId = ? and meetingTime = ? ");
		
		try (
			Connection conn 
				= new ConnectionFactory().getConnection();
			PreparedStatement pstmt 
				= conn.prepareStatement(sql.toString());
		) {
			
			pstmt.setString(1, meeting.getParkName());
			pstmt.setString(2, meeting.getUserId());
			pstmt.setString(3, meeting.getMeetingTime());
		
			pstmt.executeUpdate();
		
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<MapVO> getParticipants(String parkName){
		
		List<MapVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{			
			
			  conn = new ConnectionFactory().getConnection();			
			  StringBuilder sql = new StringBuilder();			  

			  sql.append("select userNickname, fileSaveName, meetingTime from t_meeting where parkName = ? ");
			  sql.append("    order by meetingTime  ");
			  
			  pstmt = conn.prepareStatement(sql.toString());
			  pstmt.setString(1, parkName);
			  
			  ResultSet rs = pstmt.executeQuery();
			  				
			
			  while(rs.next()){
				
				 MapVO meeting = new MapVO();
				 
				 meeting.setUserNickname(rs.getString("userNickname"));
				 meeting.setFileSaveName(rs.getString("fileSaveName"));
				 meeting.setMeetingTime(rs.getString("meetingTime"));
				  		
				 list.add(meeting);
			  }
			  
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			JDBCClose.close(conn,  pstmt);
		}
		
		return list;
	}
	
	public boolean checkMeeting(String meetingTime, String parkName, String userId) {
		boolean check = false;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{			
			
			  conn = new ConnectionFactory().getConnection();			
			  StringBuilder sql = new StringBuilder();			  

			  sql.append("select * from t_meeting where parkName = ? ");
			  sql.append("    and userId = ? and meetingTime = ? ");
			  
			  pstmt = conn.prepareStatement(sql.toString());
			  pstmt.setString(1, parkName);
			  pstmt.setString(2, userId);
			  pstmt.setString(3, meetingTime);
			  System.out.println("parkName : "+parkName);
			  System.out.println("userId : "+userId);
			  System.out.println("meetingTime : "+meetingTime);
			  System.out.println(sql);
			  ResultSet rs = pstmt.executeQuery();
			  				
			  if(rs.next()){
				  check = true;
			  }
			  
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			JDBCClose.close(conn,  pstmt);
		}
		return check;
	}
}
