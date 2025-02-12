package com.winter.app.employees;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;

import com.winter.app.ActionForward;
import com.winter.app.departments.DepartmentDTO;

public class EmployeeService {
	
	private EmployeeDAO dao;
	
	
	// 생성자
	public EmployeeService() {
		this.dao = new EmployeeDAO();
	}
	
	
	// detail
	public void detail(HttpServletRequest request, ActionForward forward) throws Exception {
		
		EmployeeDTO dto = (EmployeeDTO)request.getSession().getAttribute("user");
		
	}
	
	
	
	// login 메서드
	public void login(HttpServletRequest request, ActionForward forward) throws Exception {
		
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmployee_id(Long.parseLong(request.getParameter("employee_id")));
		dto.setPassword(request.getParameter("password"));
		dto = dao.login(dto);
		
		if (dto != null) {
			// index

			
		} else {
			request.setAttribute("result", "로그인 실패");
			request.setAttribute("path", "./login.do");
			forward.setFlag(true);
			forward.setPath("/WEB-INF/views/employees/login.jsp");
			
		}
		
	}
	
	
	// add 메서드
	public void add(HttpServletRequest request, ActionForward forward) throws Exception {
		
		EmployeeDTO dto = new EmployeeDTO();
		//dto.setEmployee_id(0);
		//dto.setDate(null);
		
		dto.setFirst_name(request.getParameter("first_name"));
		dto.setLast_name(request.getParameter("last_name"));
		dto.setEmail(request.getParameter("email"));
		dto.setPhone_number(request.getParameter("phone_number"));
		dto.setJob_id(request.getParameter("job_id"));
		
		//---------------------------------
		dto.setSalary(Double.parseDouble(request.getParameter("salary")) );
		dto.setCommission_pct(Double.parseDouble(request.getParameter("commission_pct")) );
		
		//---------------------------------
		dto.setManager_id(Long.parseLong(request.getParameter("manager_id")) );
		dto.setDepartment_id(Long.parseLong(request.getParameter("department_id")) );
		
		//---------------------------------
		dto.setPassword(request.getParameter("password"));
		
		
		int result = dao.insert(dto);
		
		String str = "사원 등록 실패";
		if(result > 0) {
			str = "사원 등록 성공";
		}
		
		request.setAttribute("result", str);
		forward.setFlag(false);
		forward.setPath("../index.do"); // 웹 브라우저에 있는 url 기준, ex)employees 폴더 기준 홈으로 가려면 ../index.do
		
//		forward.setFlag(true);
//		forward.setPath("/WEB-INF/views/commons/result.jsp");
		
	}
	
	
	//
	public void update(HttpServletRequest request, ActionForward forward) throws Exception {
		
		EmployeeDTO session = (EmployeeDTO)request.getSession().getAttribute("user");
		EmployeeDTO dto = new EmployeeDTO();
		dto.setFirst_name(request.getParameter("first_name"));
		dto.setLast_name(request.getParameter("last_name"));
		dto.setEmployee_id(session.getEmployee_id());
		
		int result = dao.update(dto);
		
		forward.setFlag(false);
		forward.setPath("./mypage.do");
		
	}
	
	
	
	
	
	

}
