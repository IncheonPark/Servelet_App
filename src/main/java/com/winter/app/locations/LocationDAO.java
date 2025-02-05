package com.winter.app.locations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.winter.app.utils.DBConnection;

public class LocationDAO {
	
	
	
	//--------------------
	public List<LocationDTO> getList() throws Exception {
		
		System.out.println("지역 정보 리스트 조회");
		
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT * FROM LOCATIONS ORDER BY LOCATION_ID DESC";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		List<LocationDTO> list = new ArrayList<LocationDTO>();
		
		while (rs.next()) {
			
			LocationDTO dto = new LocationDTO();
			dto.setLocation_id(rs.getLong("LOCATION_ID"));
			dto.setStreet_address(rs.getString("STREET_ADDRESS"));
			dto.setPostal_code(rs.getString("POSTAL_CODE"));
			dto.setCity(rs.getString("CITY"));
			dto.setState_province(rs.getString("STATE_PROVINCE"));
			dto.setCountry_id(rs.getString("COUNTRY_ID"));
			
			list.add(dto);
			
		}
		
		DBConnection.disConnection(rs, st, con);
		return list;
		
	}
	
	
	//--------------------
	public LocationDTO getDetail(LocationDTO dto) throws Exception {
		
		System.out.println("한개의 지역 정보 조회");
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = ?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, dto.getLocation_id());
		
		ResultSet rs = st.executeQuery();			
		
		if (rs.next()) {			
			dto.setLocation_id(rs.getLong("LOCATION_ID"));
			dto.setStreet_address(rs.getString("STREET_ADDRESS"));
			dto.setPostal_code(rs.getString("POSTAL_CODE"));
			dto.setCity(rs.getString("CITY"));
			dto.setState_province(rs.getString("STATE_PROVINCE"));
			dto.setCountry_id(rs.getString("COUNTRY_ID"));
			
		} else {
			dto = null;
		}
		
		DBConnection.disConnection(rs, st, con);
		return dto;
		
	}
	
	
	//--------------------
	public int add(LocationDTO dto) throws Exception {
		
		Connection con = DBConnection.getConnection();
		String sql = "INSERT INTO LOCATIONS (LOCATION_ID, STREET_ADDRESS, "
				+ "POSTAL_CODE, CITY, STATE_PROVINCE, COUNTRY_ID) "
				+ "VALUES (LOCATIONS_SEQ.NEXTVAL, ?, ?, ?, ?, ?)";
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, dto.getStreet_address());
		st.setString(2, dto.getPostal_code());
		st.setString(3, dto.getCity());
		st.setString(4, dto.getState_province());
		st.setString(5, dto.getCountry_id());				
		
		int result = st.executeUpdate();
		
		DBConnection.disConnection(st, con);
		return result;
		
	}
	
	
	
	

}
