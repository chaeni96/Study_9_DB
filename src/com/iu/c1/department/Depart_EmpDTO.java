package com.iu.c1.department;

import java.util.ArrayList;

import com.iu.c1.employee.EmployeeDTO;

public class Depart_EmpDTO extends DepartmentDTO {
	
	private ArrayList<EmployeeDTO> ar;

	public ArrayList<EmployeeDTO> getAr() {
		return ar;
	}

	public void setAr(ArrayList<EmployeeDTO> ar) {
		this.ar = ar;
	}

}
