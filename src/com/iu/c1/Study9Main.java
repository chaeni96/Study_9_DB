package com.iu.c1;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iu.c1.department.Depart_EmpDTO;
import com.iu.c1.department.DepartmentDAO;
import com.iu.c1.department.DepartmentDTO;
import com.iu.c1.employee.EmployeeController;
import com.iu.c1.location.LocationController;
import com.iu.c1.location.LocationDAO;
import com.iu.c1.location.LocationDTO;
import com.iu.c1.location.LocationView;
import com.iu.c1.util.DBConnect;

public class Study9Main {

	public static void main(String[] args) {
	
		// 메인 메서드
		
		LocationController lc = new LocationController();
		lc.start();
		
		
		/*
		 * LocationDAO locationDAO = new LocationDAO(); 
		 * LocationDTO locationDTO = new LocationDTO(); 
		 * locationDTO.setLocation_id(1000);
		 * locationDTO = locationDAO.getOne(locationDTO);
		 *  if(locationDTO != null) {
		 * System.out.println(locationDTO.getLocation_id());
		 * System.out.println(locationDTO.getStreet_address());
		 * System.out.println(locationDTO.getCity()); }else {
		 * System.out.println("조회 실패"); }
		 */
		
		
		
	}
 
}
