package com.iu.c1;

import java.sql.Connection;
import java.sql.SQLException;

import com.iu.c1.employee.EmployeeController;
import com.iu.c1.location.LocationController;
import com.iu.c1.location.LocationDAO;
import com.iu.c1.util.DBConnect;

public class Study9Main {

	public static void main(String[] args) {
	
		// 메인 메서드
		
		LocationController lc  = new LocationController();
		lc.start();
		
		EmployeeController ec = new EmployeeController();
		ec.start();
	}

}
