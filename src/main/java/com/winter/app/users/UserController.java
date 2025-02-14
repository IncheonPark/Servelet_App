package com.winter.app.users;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.winter.app.ActionForward;
import com.winter.app.accounts.AccountController;


@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService service;
	
       
    
    public UserController() {
        super();
        service = new UserService();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();
		
		System.out.println("User doGet 실행");
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/")+1);
		
		try {			
			if (uri.equals("join.do")) {
				
				String method = request.getMethod();
				if (method.toUpperCase().equals("POST")) {
					System.out.println("join.do.post 실행");
					
					String result = null;
					int reply = service.add(request, forward);
					
					if (reply > 0) {
						result = "가입 성공";
					}
					request.setAttribute("result", result);
					request.setAttribute("path", "/index.do");
					forward.setFlag(true);
					forward.setPath("/WEB-INF/views/commons/result.jsp");
					
				} else { //get
					forward.setFlag(true);
					forward.setPath("/WEB-INF/views/users/join.jsp");
				}
				
			} else if (uri.equals("login.do")){
				
				Cookie[] cookies = request.getCookies();
				for(Cookie cookie : cookies) {
					System.out.println(cookie.getName());
					System.out.println(cookie.getValue());
				}
				
				String method = request.getMethod();
				if (method.toUpperCase().equals("POST")) {
					service.login(request, forward);
					
				} else {
					forward.setFlag(true);
					forward.setPath("/WEB-INF/views/users/login.jsp");
					
				}
				
				
			} else if (uri.equals("logout.do")) {
				
				HttpSession session = request.getSession();
//				방법1 session.setAttribute("user", null);
//				방법2 session.removeAttribute("user");
//				방법3 session.removeValue("user"); 디프리케이티드
				session.invalidate();
				forward.setFlag(false);
				forward.setPath("../index.do");
				
			} else if (uri.equals("mypage.do")) {
				
				service.detail(request, forward);
				service.getList(request, forward);
				
				forward.setFlag(true);
				forward.setPath("/WEB-INF/views/users/mypage.jsp");
				
			} else if (uri.equals("update.do")) {
				
				String method = request.getMethod();
				if (method.toUpperCase().equals("POST")) {
										
					String result = null;
					int reply = service.update(request, forward);
					
					if (reply > 0) {
						result = "수정 성공";
					}
					request.setAttribute("result", result);
					request.setAttribute("path", "./mypage.do");
					forward.setFlag(true);
					forward.setPath("/WEB-INF/views/commons/result.jsp");
					
				} else {
					service.detail(request, forward);
					
					forward.setFlag(true);
					forward.setPath("/WEB-INF/views/users/update.jsp");
					
				}
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
			
		}
		
		// 확인용 출력문
		System.out.println("forward flag : " + forward.isFlag());
		System.out.println("forward path : " + forward.getPath());
		
		// 지정된 경로로 보내기
		if (forward.isFlag()) {
			RequestDispatcher view = request.getRequestDispatcher(forward.getPath());
			view.forward(request, response);
			
			
		} else {
			response.sendRedirect(forward.getPath());
			
		}
				
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		
		
		
		
	}

}
