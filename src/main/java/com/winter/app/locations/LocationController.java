package com.winter.app.locations;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.winter.app.ActionForward;

/**
 * Servlet implementation class LocationController
 */
@WebServlet("/LocationController")
public class LocationController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	LocationDAO locationDAO;
	LocationService service;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocationController() {
        super();
        locationDAO = new LocationDAO();
        service = new LocationService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("지역 관리 컨트롤러 실행");
		String uri = request.getRequestURI();
		uri = uri.substring(uri.lastIndexOf("/")+1);
		
		ActionForward forward = new ActionForward();
		
		try {			
			
			switch(uri) {
			
			case "list.do" :
				service.getList(request, forward);
				
				break;
				
			case "detail.do" :
				service.getDetail(request, forward);
				
				break;
				
			case "add.do" :
				String addMethod = request.getMethod();
				if (addMethod.toUpperCase().equals("POST")) {
					service.add(request, forward);
					
				} else {
					forward.setFlag(true);
					forward.setPath("/WEB-INF/views/locations/add.jsp");
					
				}
				
				break;
				
			case "update.do" :
				String updateMethod = request.getMethod();
				
				if (updateMethod.toUpperCase().equals("POST")) {
					System.out.println("update() 실행합니다.");
					service.update(request, forward);
					
				} else {					
					service.select_forUpdate(request, forward);
					
				}
				
				break;
				
			case "delete.do" :
				service.delete(request, forward);
				
				break;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		System.out.println("result : " + request.getAttribute("result"));
		String path = forward.getPath();
		System.out.println("path : " + path);
		
		//jsp 연결
		//path : jsp의 경로(절대 경로)
		RequestDispatcher view = request.getRequestDispatcher(path);
		// jsp fowarding
		System.out.println("view : " + view);
		view.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
		
	

}
