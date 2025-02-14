package com.winter.app.accounts;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.winter.app.ActionForward;


@WebServlet("/AccountController")
public class AccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccountService service;
	
       
    
    public AccountController() {
        super();
        service = new AccountService();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ActionForward forward = new ActionForward();
		
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/")+1);
		
		try {
			
			if (uri.equals("make.do")) {
				service.make(request, forward);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
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
