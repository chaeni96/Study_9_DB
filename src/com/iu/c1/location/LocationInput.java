package com.iu.c1.location;

import java.util.Scanner;

public class LocationInput {
	
	
	public LocationDTO inputId(Scanner sc) {
		System.out.println("Location Id를 입력하세요");
		
		LocationDTO locationDTO = new LocationDTO();
		
		int location_id = sc.nextInt();
		
		locationDTO.setLocation_id(location_id);
		
		return locationDTO;
		
	}

}
