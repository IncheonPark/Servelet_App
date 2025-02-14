package com.winter.app.accounts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.winter.app.utils.DBConnection;

public class AccountDAO {
	

	// INSERT INTO ACCOUNTS VALUES (ACCOUNTNUM_SEQ.NEXTVAL, 'DNEHD', 1, 0, SYSDATE);
	// 계좌 만들기
	public int make(AccountDTO dto) throws Exception {
		
		Connection con = DBConnection.getConnection();
		String sql = "INSERT INTO ACCOUNTS VALUES (ACCOUNTNUM_SEQ.NEXTVAL, ?, ?, 0, SYSDATE)";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, dto.getUserName());
		st.setLong(2, dto.getProductNum());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnection(st, con);
		return result;
		
	}
	
	
	
	
	

}
