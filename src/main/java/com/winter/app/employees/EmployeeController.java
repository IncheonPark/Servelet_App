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
 * Servlet implementation class EmployeeContoller
 */
@WebServlet("/EmployeeContoller")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EmployeeService service;
	
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
        super();
        service = new EmployeeService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("부서 관리 컨트롤러 doGet실행");
		
		ActionForward forward = new ActionForward();
		
		
		try {
			String method = request.getMethod();
			if (method.toUpperCase().equals("POST")) {
				service.add(request, forward);
				
			} else {
				forward.setFlag(true);
				forward.setPath("/WEB-INF/views/employees/add.jsp");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		if(forward.isFlag()) {
			RequestDispatcher view = request.getRequestDispatcher(forward.getPath());			
			view.forward(request, response);
			
		} else {
			// redirect
			response.sendRedirect(forward.getPath());
			
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
