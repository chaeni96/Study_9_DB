package com.iu.c1;

import java.sql.Connection;
import java.sql.SQLException;

import com.iu.c1.department.Depart_EmpDTO;
import com.iu.c1.department.DepartmentDAO;
import com.iu.c1.department.DepartmentDTO;
import com.iu.c1.employee.EmployeeController;
import com.iu.c1.location.LocationController;
import com.iu.c1.location.LocationDAO;
import com.iu.c1.util.DBConnect;

public class Study9Main {

	public static void main(String[] args) {
	
		// 메인 메서드
		
		//LocationController lc  = new LocationController();
		//lc.start();
		
		//EmployeeController ec = new EmployeeController();
		//ec.start();
		
		DepartmentDAO dao = new DepartmentDAO();
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setDepartment_id(80);
		
		Depart_EmpDTO dto = dao.getJoin(departmentDTO);
		
		System.out.println(dto.getDepartment_name());
		
		for(int i=0;i<dto.getAr().size();i++) {
			System.out.println("=========================");
			System.out.println(dto.getAr().get(i).getLast_name());
			System.out.println(dto.getAr().get(i).getSalary());
			System.out.println(dto.getAr().get(i).getHire_date());
			System.out.println("=========================");
		}
		
	}

}
