package com.iu.c1.employee;

import com.iu.c1.department.DepartmentDTO;

public class Emp_DepartDTO extends EmployeeDTO {
	
	private DepartmentDTO departmentDTO;
	

	public DepartmentDTO getDepartmentDTO() {
		return departmentDTO;
	}

	public void setDepartmentDTO(DepartmentDTO departmentDTO) {
		this.departmentDTO = departmentDTO;
	}

}
