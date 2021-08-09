package com.iu.c1;

import java.sql.Connection;
import java.sql.SQLException;

import com.iu.c1.location.LocationDAO;
import com.iu.c1.util.DBConnect;

public class Study9Main {

	public static void main(String[] args) {
		
		LocationDAO locationDAO = new LocationDAO();
		locationDAO.getList();
		
		
	}

}
