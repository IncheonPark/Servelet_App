package com.winter.app.tests.departments;

import java.util.List;

import com.winter.app.departments.DepartmentDAO;
import com.winter.app.departments.DepartmentDTO;

public class DepartmentDAOTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DepartmentDAO dao = new DepartmentDAO();
		try {
			List<DepartmentDTO> list = dao.getList();
			
			System.out.println(list.size());
			
			DepartmentDTO dto = dao.getDetail();
			
			System.out.println(dto.getDepartment_name());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}

}
