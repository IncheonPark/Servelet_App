package com.winter.app.locations;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LocationController
 */
@WebServlet("/LocationController")
public class LocationController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	LocationDAO locationDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocationController() {
        super();
        locationDAO = new LocationDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String result = useSubString(request.getRequestURI());
		
		//
		if (result.equals("list.do")) {
			//locationDAO.getList();

		} else if (result.equals("detail.do")) {
			//locationDAO.getDetail();

		} else {
			System.out.println("Sorry, URL's not correct");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	//
	private String useSubString(String data) {
		String result = data.substring(data.lastIndexOf("/")+1);
		
		System.out.println(result + " useSubString 메서드");
		return result;
	}
	

}
