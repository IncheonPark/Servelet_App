package com.winter.app.users;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
	
	
	

}
