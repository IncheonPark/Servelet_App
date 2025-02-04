package com.winter.app.departments;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.winter.app.utils.DBConnection;

public class DepartmentDAO {
	
	
	
	
	// 모든 부서의 리스트 조회
	public List<DepartmentDTO> getList() throws Exception {
		
		System.out.println("부서 리스트 조회");
		
		Connection con = DBConnection.getConnection();
		String sql = "SELECT * FROM DEPARTMENTS";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		List<DepartmentDTO> list = new ArrayList<DepartmentDTO>();
				
		while (rs.next()) {
			DepartmentDTO departmentDTO = new DepartmentDTO();
			departmentDTO.setDepartment_id(rs.getLong("DEPARTMENT_ID"));
			departmentDTO.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			departmentDTO.setManager_id(rs.getLong("MANAGER_ID"));
			departmentDTO.setLocation_id(rs.getLong("LOCATION_ID"));
			list.add(departmentDTO);
		}
		
		DBConnection.disConnection(rs, st, con);
		return list;
		
	}
	
	
	
	// 한 부서의 정보 조회
	public DepartmentDTO getDetail() throws Exception {
		
		System.out.println("한개 부서 정보 조회");
		
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1, "100");
		
		ResultSet rs = st.executeQuery();
		
		DepartmentDTO dto = new DepartmentDTO();
		
		while(rs.next()) {
			dto.setDepartment_id(rs.getLong("DEPARTMENT_ID"));
			dto.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			dto.setManager_id(rs.getLong("MANAGER_ID"));
			dto.setLocation_id(rs.getLong("LOCATION_ID"));
		}
		
		DBConnection.disConnection(rs, st, con);
		return dto;
						
	}
	

}
