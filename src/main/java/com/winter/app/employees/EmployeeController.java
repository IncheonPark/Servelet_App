package com.winter.app.employees;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.winter.app.ActionForward;

/**
 * Servlet implementation class EmployeeController
 */
@WebServlet("/EmployeeController")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService employeeService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
        super();
        // TODO Auto-generated constructor stub
        employeeService = new EmployeeService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("사원 관리 컨트롤 doGet 실행");
		
		String uri = request.getRequestURI();		
		uri = uri.substring(uri.lastIndexOf("/")+1);
		
		ActionForward actionForward = new ActionForward();
		
		try {
			if(uri.equals("join.do")) {
				
				String method = request.getMethod();
				
				if(method.toUpperCase().equals("POST")) {
					employeeService.add(request, actionForward);
					
				} else {
					actionForward.setFlag(true);
					actionForward.setPath("/WEB-INF/views/employees/join.jsp");
					
				}
				
			} else if(uri.equals("login.do")) {
				
				String method = request.getMethod();
				
				if(method.toUpperCase().equals("POST")) {
					employeeService.login(request, actionForward);
					
				} else {
					actionForward.setFlag(true);
					actionForward.setPath("/WEB-INF/views/employees/login.jsp");
					
				}
			} else if (uri.equals("update.do")) {
				
				String method = request.getMethod();
				
				if(method.toUpperCase().equals("POST")) {
					employeeService.update(request, actionForward);
					
				} else {
					actionForward.setFlag(true);
					employeeService.detail(request, actionForward);
					
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(actionForward.isFlag()) {
			RequestDispatcher view = request.getRequestDispatcher(actionForward.getPath());
			view.forward(request, response);
			
		} else {
			//Flag가 false라면 redirect 실행
			response.sendRedirect(actionForward.getPath());
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	

}