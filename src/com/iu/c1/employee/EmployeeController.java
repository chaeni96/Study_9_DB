package com.iu.c1.employee;

import java.util.ArrayList;

public class EmployeeController {
	
	private EmployeeDAO employeeDAO;
	private EmployeeView employeeView;
	
	public EmployeeController() {
		employeeDAO = new EmployeeDAO();
		employeeView = new EmployeeView();
	}
	
	public void start() {
		//1. 전체 사원 출력
		//ArrayList<EmployeeDTO> ar = employeeDAO.getList();
		//employeeView.view(ar);
		
		//2. 사원 번호를 입력해서 사원 한명 정보 출력
		//EmployeeDTO employeeDTO = employeeDAO.getOne(150);
		//employeeView.view(employeeDTO);
		
		//3. last_name을 검색해서 정보 출력
		// ArrayList<EmployeeDTO> ar2 = employeeDAO.getSearch("Jones");
		// employeeView.view(ar2);
		
		//4. First_name을 검색해서 정보 출력
		//ArrayList<EmployeeDTO> ar3 = employeeDAO.getSearch1("Steven");
		//employeeView.view(ar3);
		
		//5-1. 전체 평균 급여
		//double avg = employeeDAO.getAvg();
		//employeeView.view(avg);
		
		//5-2. 부서별 평균 급여
		ArrayList<Double> avgs = employeeDAO.getAvgs();
		employeeView.view1(avgs);
	}
}
