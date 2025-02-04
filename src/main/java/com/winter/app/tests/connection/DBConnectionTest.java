package com.winter.app.tests.connection;

import java.sql.Connection;

import com.winter.app.utils.DBConnection;

public class DBConnectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			Connection con = DBConnection.getConnection();
			
			System.out.println(con);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}

	}

}
