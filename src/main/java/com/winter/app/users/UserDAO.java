package com.winter.app.users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.winter.app.utils.DBConnection;

public class UserDAO {
	
	
	// 회원 추가 add
	public int add(UserDTO dto) throws Exception {
		
		Connection con = DBConnection.getConnection();
		String sql = "INSERT INTO USERS VALUES (?, ?, ?, ?, ?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, dto.getUserName());
		st.setString(2, dto.getPassword());
		st.setString(3, dto.getName());
		st.setString(4, dto.getPhone());
		st.setString(5, dto.getEmail());		
		
		int result = st.executeUpdate();
		
		DBConnection.disConnection(st, con);
		return result;
		
	}
	
	
	//
	public UserDTO login(UserDTO dto) throws Exception {
		
		Connection con = DBConnection.getConnection();
		String sql = "SELECT * FROM USERS WHERE USERNAME=? AND PASSWORD=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, dto.getUserName());
		st.setString(2, dto.getPassword());
		
		ResultSet rs = st.executeQuery();
		
		if (rs.next()) {
			dto.setUserName(rs.getString("USERNAME"));
			dto.setPassword(rs.getString("PASSWORD"));
			dto.setName(rs.getString("NAME"));
			dto.setPhone(rs.getString("PHONE"));
			dto.setEmail(rs.getString("EMAIL"));
			
		} else {
			dto = null;
			
		}
		
		DBConnection.disConnection(rs, st, con);
		return dto;
		
	}
	
	
	//
	public int update(UserDTO dto) throws Exception {
		
		Connection con = DBConnection.getConnection();
		String sql = "UPDATE USERS SET PASSWORD=?, NAME=?, PHONE=?, EMAIL=? WHERE USERNAME=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, dto.getPassword());
		st.setString(2, dto.getName());
		st.setString(3, dto.getPhone());
		st.setString(4, dto.getEmail());
		st.setString(5, dto.getUserName());
		
		System.out.println("dto 변수들 출력");
		System.out.println(dto.getPassword());
		System.out.println(dto.getName());
		System.out.println(dto.getPhone());
		System.out.println(dto.getEmail());
		System.out.println(dto.getUserName());
		
		int result = st.executeUpdate();
		System.out.println("result :" + result);
		
		DBConnection.disConnection(st, con);		
		return result;
		
	}
	
	
	
	
	
	

}
