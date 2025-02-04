package com.winter.app.tests.locations;

import java.util.List;

import com.winter.app.locations.LocationDAO;
import com.winter.app.locations.LocationDTO;

public class LocationDAOTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LocationDAO dao = new LocationDAO();
		
		try {		
		List<LocationDTO> list = dao.getList();
		System.out.println(list.size());
		
		LocationDTO dto = dao.getDetail();
		System.out.println(dto.getStreet_address());
		
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		

	}

}
