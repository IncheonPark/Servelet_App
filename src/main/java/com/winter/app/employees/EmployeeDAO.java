package com.winter.app.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.winter.app.utils.DBConnection;

public class EmployeeDAO {
	
	
	// 조회 메서드
	public EmployeeDTO login(EmployeeDTO dto) throws Exception {
		
		Connection con = DBConnection.getConnection();
		String sql = "SELECT EMPOYE_ID, PASSWORD, FIRST_NAME FROM EMPLOYEES "
				+ " WHERE EMPLOYEE_ID=? AND PASSWORD=?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, dto.getEmployee_id());
		st.setString(2, dto.getPassword());
		
		ResultSet rs = st.executeQuery();
		
		if (rs.next()) {
			dto.setFirst_name(rs.getString("FIRST_NAME"));
		} else {
			dto = null;
		}
		
		DBConnection.disConnection(rs, st, con);
		return dto;
		
		
	}
	
	
	// 사원 입력 메서드
	public int insert(EmployeeDTO dto) throws Exception {
		
		Connection con = DBConnection.getConnection();
		String sql = "INSERT INTO EMPLOYEES (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, "
				+ "PHONE_NUMBER, HIRE_DATE, JOB_ID, "
				+ "SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID, PASSWORD) "
				+ "VALUES (EMPLOYEES_SEQ.NEXTVAL, ?, ?, ?, ?, SYSDATE, ?, ?, ?, ?, ?, ?)";
		// VALUE 예시) 
		// EMPLOYEES_SEQ.NEXTVAL, 'FIRST', 'LAST', 'E', 'P', SYSDATE, 'AD_VP', 1.1, 0.1, 100, 90, 'PW'
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, dto.getFirst_name());
		st.setString(2, dto.getLast_name());
		st.setString(3, dto.getEmail());
		st.setString(4, dto.getPhone_number());
		st.setString(5, dto.getJob_id());
		st.setString(10, dto.getPassword());
		
		st.setDouble(6, dto.getSalary());
		st.setDouble(7, dto.getCommission_pct());
		
		st.setLong(8, dto.getManager_id());
		st.setLong(9, dto.getDepartment_id());
		
		int result = st.executeUpdate();
		
		DBConnection.disConnection(st, con);
		return result;
		
	}
	

}
