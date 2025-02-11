package com.winter.app.locations;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.winter.app.ActionForward;

public class LocationService {
	
	
	private LocationDAO dao;
	
	
	public LocationService() {
		dao = new LocationDAO();
	}
	
	
	//
	public void getList(HttpServletRequest request, ActionForward forward) throws Exception {
		
		List<LocationDTO> list = dao.getList();
		System.out.println(list.get(0).getStreet_address());
		request.setAttribute("list", list);
		
		forward.setFlag(true);
		forward.setPath("/WEB-INF/views/locations/list.jsp");
		
	}
	
	//
	public void getDetail(HttpServletRequest request, ActionForward forward) throws Exception {
		
		String l_id = request.getParameter("location_id");
		long id = Long.parseLong(l_id);
		LocationDTO dto = new LocationDTO();
		dto.setLocation_id(id);
		dto = dao.getDetail(dto);
		
		request.setAttribute("dto", dto);
		forward.setFlag(true);
		forward.setPath("/WEB-INF/views/locations/detail.jsp");
		
		System.out.println("getPath" + forward.getPath());
						
	}
	
	
	//
	public void add(HttpServletRequest request, ActionForward forward) throws Exception {
		
		LocationDTO dto = new LocationDTO();
		dto.setStreet_address(request.getParameter("street_address"));
		dto.setPostal_code(request.getParameter("postal_code"));
		dto.setCity(request.getParameter("city"));
		dto.setState_province(request.getParameter("state_province"));
		dto.setCountry_id(request.getParameter("country_id"));
		
		int isDone = dao.add(dto);
		
		String result = "지역 등록 실패";
		if (isDone > 0 ) {
			result = "지역 등록 성공";
		}
		
		request.setAttribute("result", result);
		forward.setFlag(true);
		forward.setPath("/WEB-INF/views/commons/result.jsp");
				
	}
	
	
	//
	public void select_forUpdate(HttpServletRequest request, ActionForward forward) throws Exception {
		
		LocationDTO dto = new LocationDTO();
		String id = request.getParameter("location_id");
		dto.setLocation_id(Long.parseLong(id));
		
		dto = dao.getDetail(dto);
		
		request.setAttribute("dto", dto);
		forward.setFlag(true);
		forward.setPath("/WEB-INF/views/locations/update.jsp");
		
	}
	
	
	
	//
	public void update(HttpServletRequest request, ActionForward forward) throws Exception {		
		
		LocationDTO dto = new LocationDTO();
		dto.setStreet_address(request.getParameter("street_address"));
		dto.setPostal_code(request.getParameter("postal_code"));
		dto.setCity(request.getParameter("city"));
		dto.setState_province(request.getParameter("state_province"));
		dto.setCountry_id(request.getParameter("country_id"));
		dto.setLocation_id(Long.parseLong(request.getParameter("location_id")));
		
		int isDone = dao.update(dto);
		
		String result = "지역 업데이트 실패";
		if (isDone > 0) {
			result = "지역 업데이트 성공";
		}
		
		request.setAttribute("result", result);
		forward.setFlag(true);
		forward.setPath("/WEB-INF/views/commons/result.jsp");
		
	}
	
	
	//
	public void delete(HttpServletRequest request, ActionForward forward) throws Exception {
		
		String id = request.getParameter("location_id");
		long l_id = Long.parseLong(id);
		LocationDTO dto = new LocationDTO();
		dto.setLocation_id(l_id);
		
		int isDone = dao.delete(dto);
		
		String result = "지역 삭제 실패";
		if (isDone > 0) {
			result = "지역 삭제 성공";
		}
		
		request.setAttribute("result", result);
		forward.setFlag(true);
		forward.setPath("/WEB-INF/views/commons/result.jsp");
		
	}

	
	
	
	
}
