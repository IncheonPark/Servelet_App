package com.winter.app.products;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.winter.app.ActionForward;


@WebServlet("/ProductController")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductService service;
       
    
    public ProductController() {
        super();
        service = new ProductService();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Product doGet 실행");
		ActionForward forward = new ActionForward();
				
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		//getURI 가져오면 ? 뒤에 파라미터는 자동으로 지워진다. > 파싱 따로 안해도 됨
		if(uri.contains("?")) {
			uri = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf("?"));
			System.out.println("uri : " + uri);
			
		} else {
			uri = uri.substring(uri.lastIndexOf("/")+1);
			
		}
		
		
		try {
			
			if (uri.equals("list.do")) {
				service.getList(request, forward);
				
			} else if (uri.equals("detail.do")) {
				service.getDetail(request, forward);
				
			} else if (uri.equals("add.do")) {
				
				String method = request.getMethod();
				if (method.toUpperCase().equals("POST")) {
					service.add(request, forward);
					
				} else {
					forward.setFlag(true);
					forward.setPath("/WEB-INF/views/products/add.jsp");
					
				}
				
			} else if (uri.equals("update.do")) {
				
				String method = request.getMethod();
				if (method.toUpperCase().equals("POST")) {
					service.update(request, forward);
					
				} else {
					service.getDetail_forUpdate(request, forward);
					forward.setFlag(true);
					forward.setPath("/WEB-INF/views/products/update.jsp");
					
				}
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		
		
		// 확인용 출력문
		System.out.println("forward flag : " + forward.isFlag());
		System.out.println("forward path : " + forward.getPath());
		
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
