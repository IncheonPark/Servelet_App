package com.winter.app.departments;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.winter.app.ActionForward;

public class DepartmentService {
	
	private DepartmentDAO dao;
	
	public DepartmentService() {
		this.dao = new DepartmentDAO();
	}
	
	
	public ActionForward getList(HttpServletRequest request, ActionForward forward) throws Exception {
		
		List<DepartmentDTO> list = dao.getList();
		request.setAttribute("list", list);		
		
		forward.setFlag(true);
		forward.setPath("/WEB-INF/views/departments/list.jsp");
		
		return forward;
		
	}
	
	//
	public ActionForward getDetail(HttpServletRequest request, ActionForward forward) throws Exception {
		
		String d_id = request.getParameter("department_id");
		DepartmentDTO dto = new DepartmentDTO();
		
		dto.setDepartment_id(Long.parseLong(d_id));
		dto = dao.getDetail(dto);
		request.setAttribute("dto", dto);		
		
		forward.setFlag(true);
		forward.setPath("/WEB-INF/views/departments/detail.jsp");
		
		return forward;
		
	}
	
	
	//
	public void add(HttpServletRequest request, ActionForward forward) throws Exception {
		
		DepartmentDTO dto = new DepartmentDTO();
		dto.setDepartment_name(request.getParameter("department_name"));
		dto.setManager_id(Long.parseLong(request.getParameter("manager_id")));
		dto.setLocation_id(Long.parseLong(request.getParameter("location_id")));
		
		int result = dao.add(dto);
		
		String str = "부서 등록 실패";
		if(result > 0) {
			str = "부서 등록 성공";
		}
		
		request.setAttribute("result", str);
		
		forward.setFlag(true);
		forward.setPath("/WEB-INF/views/commons/result.jsp");
		
	}
	
	
	// 1. DB에서 수정할 데이터 조회 (input 태그 위에 뿌리는 역할 (기존 값을 보여줘야 하니까)
	public void update(HttpServletRequest request, ActionForward actionForward) throws Exception {
		DepartmentDTO dto = new DepartmentDTO();
		dto.setDepartment_id(Long.parseLong(request.getParameter("department_id")));
		dto = dao.getDetail(dto);
		
		request.setAttribute("dto", dto);
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/departments/update.jsp");
		
	}
	
	// 2. 데이터 수정 (input에 입력 받은 값으로 실제로 수정)
	public void updateProcess(HttpServletRequest request, ActionForward actionForward) throws Exception {
		
		String name = request.getParameter("department_name");
		String m_id = request.getParameter("manager_id");
		String l_id = request.getParameter("location_id");
		String d_id = request.getParameter("department_id");
		
		DepartmentDTO dto = new DepartmentDTO();
		dto.setDepartment_name(name);
		dto.setManager_id(Long.parseLong(m_id));
		dto.setLocation_id(Long.parseLong(l_id));
		dto.setDepartment_id(Long.parseLong(d_id));	
		
		int isDone = dao.update(dto);
		
		String result = "부서 수정 실패";
		
		if (isDone > 0 ) {
			result = "부서 수정 성공";
		}
		
		request.setAttribute("result", result);
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/commons/result.jsp");
		
	}
	
	
	// delete
	public void delete(HttpServletRequest request, ActionForward actionForward) throws Exception {
		
		DepartmentDTO dto = new DepartmentDTO();
		dto.setDepartment_id(Long.parseLong(request.getParameter("department_id")));
		int result = dao.delete(dto);
		
		
		String str = "부서 삭제 실패";
		
		if (result > 0 ) {
			str = "부서 삭제 성공";
		}
		
		request.setAttribute("result", str);
		actionForward.setFlag(true);
		actionForward.setPath("/WEB-INF/views/commons/result.jsp");
		
	}
	
	
	
	

}
