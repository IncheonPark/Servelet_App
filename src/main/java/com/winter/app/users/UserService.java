package com.winter.app.users;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.winter.app.ActionForward;
import com.winter.app.accounts.AccountDTO;

public class UserService {
	
	private UserDAO dao;
	
	
	public UserService() {
		dao = new UserDAO();
	}
	
	
	public int add(HttpServletRequest request, ActionForward forward) throws Exception {
		
		UserDTO dto = new UserDTO();
		dto.setUserName(request.getParameter("userName"));
		dto.setPassword(request.getParameter("password"));
		dto.setName(request.getParameter("name"));
		dto.setPhone(request.getParameter("phone"));
		dto.setEmail(request.getParameter("email"));		
		
		int result = dao.add(dto);
		
		
		return result;
		
	}
	
	public void login(HttpServletRequest request, ActionForward forward) throws Exception {
		
		UserDTO dto = new UserDTO();
		dto.setUserName(request.getParameter("userName"));
		dto.setPassword(request.getParameter("password"));
		dto = dao.login(dto);
		
		if (dto != null) {
			// index로 이동
			HttpSession session = request.getSession();
			
			session.setAttribute("user", dto);
			forward.setFlag(false);
			forward.setPath("../index.do");
//			forward.setFlag(true);
//			forward.setPath("/WEB-INF/views/index.jsp");
//			request.setAttribute("user", dto);
//			forward.setPath("/index.do");
			
		} else {
			//
			request.setAttribute("result", "로그인 실패");
			request.setAttribute("path", "./login.do");
			forward.setFlag(true);
			forward.setPath("/WEB-INF/views/commons/result.jsp");
			
		}
		
	}
	
	
	//
	public void detail(HttpServletRequest request, ActionForward forward) {
		
		// 로그인 되어있는 동안 (세션이 살아있을 동안) 쓸 수 있다.
		UserDTO dto = (UserDTO) request.getSession().getAttribute("user");
		
		//dao.detail은 생략하였다. dto에 이미 모든 멤버 정보가 있기 때문에.
		request.setAttribute("user", dto);
		
		
	}
	
		
	//
	public int update(HttpServletRequest request, ActionForward forward) throws Exception {
		
		UserDTO dto = new UserDTO();
		dto.setUserName(request.getParameter("userName"));
		dto.setPassword(request.getParameter("password"));
		dto.setName(request.getParameter("name"));
		dto.setPhone(request.getParameter("phone"));
		dto.setEmail(request.getParameter("email"));
		
		
		request.getSession().setAttribute("user", dto);
		int result = dao.update(dto);
		
		return result;
		
	}
	
	
	//
	public void getList(HttpServletRequest request, ActionForward forward) throws Exception {
		
		UserDTO userDTO = (UserDTO)request.getSession().getAttribute("user");	
		AccountDTO dto = new AccountDTO();
		dto.setUserName(userDTO.getUserName());
		
		List<AccountDTO> list = dao.getList(dto);
		
		request.setAttribute("list", list);
		
		
	}
	
	
	
}
