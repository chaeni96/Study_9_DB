package com.iu.c1.employee;

import java.util.ArrayList;

public class EmployeeView {

	//출력 메서드
	
	//정보 한명 출력
	public void view(EmployeeDTO employeeDTO) {
		
		System.out.println(employeeDTO.getEmployee_id());
		System.out.println(employeeDTO.getFirst_name());
		System.out.println(employeeDTO.getLast_name());
		System.out.println(employeeDTO.getEmail());
		System.out.println(employeeDTO.getPhone_number());
		System.out.println(employeeDTO.getHire_date());
		System.out.println(employeeDTO.getJob_id());
		System.out.println(employeeDTO.getSalary());
		System.out.println(employeeDTO.getCommission_pct());
		System.out.println(employeeDTO.getManager_id());
		System.out.println(employeeDTO.getDepartment_id());
		
	}
	
	//정보 여러개 출력
	
	public void view(ArrayList<EmployeeDTO> ar) {
		for(int i = 0; i<ar.size();i++) {
			this.view(ar.get(i));
			System.out.println("------------------");
		}
		
	}
	
	//전체 평균 급여 출력
	public void view(double avg) {
		System.out.println("전체 평균 급여 : "+avg);
	}
	
	//부서별 평균 급여 출력
	public void view1(ArrayList<Double> ar) {
		
			for(int i = 0; i<ar.size(); i++) {
				System.out.println(ar.get(i));
			}
		
		
	}

}
