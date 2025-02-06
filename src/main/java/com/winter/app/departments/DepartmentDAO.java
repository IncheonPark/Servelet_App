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
		String sql = "SELECT * FROM DEPARTMENTS ORDER BY DEPARTMENT_ID DESC";
		
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
	public DepartmentDTO getDetail(DepartmentDTO dto) throws Exception {
		
		System.out.println("한개 부서 정보 조회");
		
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT * FROM DEPARTMENTS WHERE DEPARTMENT_ID = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, dto.getDepartment_id());
		
		ResultSet rs = st.executeQuery();				
		
		if(rs.next()) {
			dto.setDepartment_id(rs.getLong("DEPARTMENT_ID"));
			dto.setDepartment_name(rs.getString("DEPARTMENT_NAME"));
			dto.setManager_id(rs.getLong("MANAGER_ID"));
			dto.setLocation_id(rs.getLong("LOCATION_ID"));
			
		} else {
			dto = null;
			
		}
		
		DBConnection.disConnection(rs, st, con);
		return dto;
						
	}
	
	
	//
	public int add(DepartmentDTO dto) throws Exception {
		
		Connection con = DBConnection.getConnection();
		String sql = "INSERT INTO DEPARTMENTS (DEPARTMENT_ID, DEPARTMENT_NAME, MANAGER_ID, "
				+ "LOCATION_ID) VALUES (DEPARTMENTS_SEQ.NEXTVAL, ?, ?, ?)";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, dto.getDepartment_name());
		st.setLong(2, dto.getManager_id());
		st.setLong(3, dto.getLocation_id());
		
		int result = 0;
		result = st.executeUpdate();
		
		DBConnection.disConnection(st, con);
		return result;
		
	}
	
	
	// 부서 삭제
	public int delete(DepartmentDTO dto) throws Exception {
		
		int result = 0;
		Connection con = DBConnection.getConnection();
		String sql = "DELETE DEPARTMENTS WHERE DEPARTMENT_ID = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setLong(1, dto.getDepartment_id());
		
		result = st.executeUpdate();
		
		DBConnection.disConnection(st, con);
		return result;
		
	}
	
	
	// 부서 수정
	public int update(DepartmentDTO dto) throws Exception {
		
		int result = 0;
		Connection con = DBConnection.getConnection();
		String sql = "UPDATE DEPARTMENTS SET DEPARTMENT_NAME = ?, MANAGER_ID = ?, LOCATION_ID = ? "
				+ "WHERE DEPARTMENT_ID = ?";
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,dto.getDepartment_name());
		st.setLong(2,dto.getManager_id());
		st.setLong(3,dto.getLocation_id());
		st.setLong(4,dto.getDepartment_id());
		
		result = st.executeUpdate();
		
		DBConnection.disConnection(st, con);
		return result;
		
	}
	
	
	
	
	
	

}
