package com.winter.app.users;

import javax.servlet.http.HttpServletRequest;

import com.winter.app.ActionForward;

public class UserService {
	
	private UserDAO dao;
	
	
	public UserService() {
		dao = new UserDAO();
	}
	
	public void add(HttpServletRequest request, ActionForward forward) throws Exception {
		UserDTO dto = new UserDTO();
		dto.setUserName(request.getParameter("userName"));
		dto.setPassword(request.getParameter("password"));
		dto.setName(request.getParameter("name"));
		dto.setPhone(request.getParameter("phone"));
		dto.setEmail(request.getParameter("email"));		
		
		int result = dao.add(dto);
		
		if (result > 0) {
			
			
			
		} else {
			
			
		}
		
	}
	
	
}
