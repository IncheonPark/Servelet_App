package com.winter.app.accounts;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.winter.app.ActionForward;
import com.winter.app.users.UserDTO;

public class AccountService {
	
	
	private AccountDAO dao;
	
	
	public AccountService() {
		dao = new AccountDAO();
		
	}
	
	
	//
	public void make(HttpServletRequest request, ActionForward forward) throws Exception {
		
		System.out.println("Service make() 실행");
		UserDTO userDTO = (UserDTO)request.getSession().getAttribute("user");		
		String productNum = request.getParameter("productNum");
		System.out.println("session, userName : " + userDTO);
		System.out.println("request, productNum : " + productNum);
		
		if (userDTO != null) {
			
			System.out.println("make() when not null 실행");
			String userName = userDTO.getUserName();
			AccountDTO dto = new AccountDTO();
			dto.setUserName(userName);
			dto.setProductNum(Long.parseLong(productNum));
					
			int isDone = dao.make(dto);
			String result = "계좌 생성 실패";
			
			if (isDone > 0) {
				result = "계좌 생성 성공";
				
			}
			
			request.setAttribute("result", result);
			request.setAttribute("path", "../users/mypage.do");
			
		} else {
			System.out.println("make() when null 실행");
			String result = "로그인을 해주세요";
			request.setAttribute("result", result);
			request.setAttribute("path", "../users/login.do");
			
		}
		
		
		forward.setFlag(true);
		forward.setPath("/WEB-INF/views/commons/result.jsp");
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
