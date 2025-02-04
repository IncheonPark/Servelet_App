package com.winter.app.locations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.winter.app.utils.DBConnection;

public class LocationDAO {
	
	
	
	//
	public List<LocationDTO> getList() throws Exception {
		
		System.out.println("지역 정보 리스트 조회");
		
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT * FROM LOCATIONS";
		
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
	
	
	//
	public LocationDTO getDetail() throws Exception {
		
		System.out.println("한개의 지역 정보 조회");
		Connection con = DBConnection.getConnection();
		
		String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = ?";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setLong(1, 1000);
		
		ResultSet rs = st.executeQuery();
		
		LocationDTO dto = new LocationDTO();
		
		while (rs.next()) {
			
			dto.setLocation_id(rs.getLong("LOCATION_ID"));
			dto.setStreet_address(rs.getString("STREET_ADDRESS"));
			dto.setPostal_code(rs.getString("POSTAL_CODE"));
			dto.setCity(rs.getString("CITY"));
			dto.setState_province(rs.getString("STATE_PROVINCE"));
			dto.setCountry_id(rs.getString("COUNTRY_ID"));
			
		}
		
		DBConnection.disConnection(rs, st, con);
		return dto;
		
		
		
	}

}
