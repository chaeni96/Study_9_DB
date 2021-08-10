package com.iu.c1.location;

import java.util.ArrayList;

public class LocationController {
	
	private LocationDAO locationDAO;
	private LocationView locationView;
	
	public LocationController() {
		locationDAO = new LocationDAO();
		locationView = new LocationView();
	}
	
	
	public void start() {
		
		int count = locationDAO.getCount();
		locationView.view(count);

		//DB에서 Location Table의 모든 정보 조회
		ArrayList<LocationDTO> ar = locationDAO.getList();
		locationView.view(ar);
		
		
		LocationDTO locationDTO = locationDAO.getOne(1000);
		locationView.view(locationDTO);
		
		
		ArrayList<LocationDTO> ar2 = locationDAO.getSearch("Vi");
		locationView.view(ar2);
		
		LocationDTO locationDTO2 = locationDAO.getLocation(100);
		locationView.view(locationDTO2);
	}

}
