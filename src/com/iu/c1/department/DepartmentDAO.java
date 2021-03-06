package com.iu.c1.department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iu.c1.employee.EmployeeDTO;
import com.iu.c1.util.DBConnect;

public class DepartmentDAO {
	
	private DBConnect dbConnect;
	
	public DepartmentDAO() {
		dbConnect = new DBConnect();
	}
	
	//getJoin
	
	public Depart_EmpDTO getJoin(DepartmentDTO departmentDTO) {
		Connection con  = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Depart_EmpDTO dto = null;
		
		
		try {
			con = dbConnect.getConnect();
			
			StringBuffer sb = new StringBuffer();
			sb.append("SELECT E.LAST_NAME, E.SALARY, E.HIRE_DATE, D.DEPARTMENT_NAME");
			sb.append(" FROM EMPLOYEES E inner join DEPARTMENTS D");
			sb.append(" USING(DEPARTMENT_ID)");
			sb.append(" WHERE DEPARTMENT_ID = ?");
			
			st = con.prepareStatement(sb.toString());
			
			st.setInt(1, departmentDTO.getDepartment_id());
			
			rs = st.executeQuery();
			dto = new Depart_EmpDTO();
			dto.setAr(new ArrayList<EmployeeDTO>());
			
			while(rs.next()) {
				EmployeeDTO eDto = new EmployeeDTO();
				
				eDto.setLast_name(rs.getString("last_name"));
				eDto.setSalary(rs.getInt("salary"));
				eDto.setHire_date(rs.getDate("hire_date"));
				
				dto.getAr().add(eDto);
				dto.setDepartment_name(rs.getString("department_name"));
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
		}
		return dto;
		
	}

}
