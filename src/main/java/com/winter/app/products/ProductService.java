package com.winter.app.products;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.winter.app.ActionForward;

public class ProductService {
	
	private ProductDAO dao;
	
	
	
	public ProductService() {
		dao = new ProductDAO();
	}
	
	
	//
	public void getList(HttpServletRequest request, ActionForward forward) throws Exception {
		
		List<ProductDTO> list = dao.getList();
		request.setAttribute("list", list);
		forward.setFlag(true);
		forward.setPath("/WEB-INF/views/products/list.jsp");
		
	}
	
	
	//
	public void getDetail(HttpServletRequest request, ActionForward forward) throws Exception {
		
		System.out.println("parameter는? : " + request.getParameter("productNum"));
		System.out.println("세션 atr는? : " + request.getSession().getAttribute("dtoSS"));
		
		ProductDTO dto = new ProductDTO();
		
		if (request.getParameter("productNum") != null) {
			dto.setProductNum(Long.parseLong(request.getParameter("productNum")));
			
		} else {
			dto = (ProductDTO)request.getSession().getAttribute("dtoSS");
			
		}
		
		dto = dao.getDetail(dto);
		
		request.setAttribute("dtoRQ", dto);
		request.getSession().setAttribute("dtoSS", dto);
		forward.setFlag(true);
		forward.setPath("/WEB-INF/views/products/detail.jsp");
		
	}
	
	
	//
	public void add(HttpServletRequest request, ActionForward forward) throws Exception {
		
		ProductDTO dto = new ProductDTO();
		dto.setProductName(request.getParameter("productName"));
		dto.setProductRate(Double.parseDouble(request.getParameter("productRate")));
		dto.setProductDate(Date.valueOf(request.getParameter("productDate")));
		dto.setProductDetail(request.getParameter("productDetail"));
		
		int isDone = dao.add(dto);
		
		String result = "상품 입력에 실패했습니다";
		if (isDone > 0) {
			result = "상품 입력에 성공했습니다";
		}
		
		request.setAttribute("result", result);
		request.setAttribute("path", "./list.do");
		forward.setFlag(true);
		forward.setPath("/WEB-INF/views/commons/result.jsp");
		
	}
	
	
	// getDetail_forUpdate
	public void getDetail_forUpdate(HttpServletRequest request, ActionForward forward) throws Exception {
		
		getDetail(request, forward);		
		
		forward.setFlag(true);
		forward.setPath("/WEB-INF/views/products/update.jsp");
		
	}
	
	
	// update
	public void update(HttpServletRequest request, ActionForward forward) throws Exception {
		
		ProductDTO dto = new ProductDTO();
		dto.setProductName(request.getParameter("productName"));
		dto.setProductRate(Double.parseDouble(request.getParameter("productRate")));
		dto.setProductDate(Date.valueOf(request.getParameter("productDate")));
		dto.setProductDetail(request.getParameter("productDetail"));
		dto.setProductNum(Long.parseLong(request.getParameter("productNum")));
		
		int isDone = dao.update(dto);
		
		String result = "상품 수정에 실패했습니다";
		if (isDone > 0) {
			result = "상품 수정에 성공했습니다";
		}
		
		request.setAttribute("result", result);
		request.setAttribute("path", "./detail.do");
		forward.setFlag(true);
		forward.setPath("/WEB-INF/views/commons/result.jsp");
		
	}
	
	
	
	
	

}
