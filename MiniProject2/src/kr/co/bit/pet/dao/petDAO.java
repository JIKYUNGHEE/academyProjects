package kr.co.bit.pet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.bit.board.vo.BoardVO;
import kr.co.bit.member.vo.memberVO;
import kr.co.bit.pet.vo.petVO;
import kr.co.bit.util.ConnectionFactory;
import kr.co.bit.util.JDBCClose;

public class petDAO {

	public void insert(petVO pet) {
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    
	    if(pet.getName()==null) {
	    	return;
	    }
	    
		try{
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
				sql.append(" insert into t_pet ( no, petOwner, name, age, sex, species ) ");
				sql.append(" values (seq_t_pet_no.nextval, ?, ?, ?, ?, ?) ");
				
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, pet.getOwner());
				pstmt.setString(2, pet.getName());
				pstmt.setInt(3, pet.getAge());
				pstmt.setString(4, pet.getSex());
				pstmt.setString(5, pet.getSpecies());
				
				pstmt.executeUpdate();
				
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			 JDBCClose.close(conn, pstmt);
		}
	}
	
	
	public List<petVO> selectAllById(String id) {

		List<petVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("select no, petowner, name, age, sex, species ");			
			sql.append("  from t_pet ");
			sql.append(" where petowner = ? ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				petVO pet = new petVO();
				
				int no = rs.getInt("no");				
				String owner = rs.getString("petowner");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String sex = rs.getString("sex");
				String species = rs.getString("species");
				
				pet.setNo(no);
				pet.setOwner(owner);
				pet.setName(name);
				pet.setAge(age);
				pet.setSex(sex);
				pet.setSpecies(species);
				
				System.out.println("species"+species);
				
				list.add(pet);
			}
			

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		
		return list;
	}	
	
	
	
	public void modifyPet(petVO pet){
		
		System.out.println("modifyPet 도착");
		
		StringBuilder sql = new StringBuilder();
		sql.append(" update t_pet set name=?, age=?, sex=?, species=? where  petowner=? and no=?  ");
			
		try(
				
				Connection conn = new ConnectionFactory().getConnection();			
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				
				) { 
			
			int loc = 1;		
			
			pstmt.setString(loc++, pet.getName());
			pstmt.setInt(loc++, pet.getAge());
			pstmt.setString(loc++, pet.getSex());
			pstmt.setString(loc++, pet.getSpecies());
			
			pstmt.setString(loc++, pet.getOwner());
			pstmt.setInt(loc++, pet.getNo());

			
			pstmt.executeUpdate();
			
			
		} catch(Exception e) {
			e.printStackTrace();
			
		}
		
	}
		
	
	
}
