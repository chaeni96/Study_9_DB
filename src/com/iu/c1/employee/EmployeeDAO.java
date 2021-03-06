package com.iu.c1.employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iu.c1.department.DepartmentDTO;
import com.iu.c1.util.DBConnect;

public class EmployeeDAO {
	
	
	private DBConnect dbConnect;
	
	public EmployeeDAO() {
		dbConnect = new DBConnect();
	}

	//getJoin 
	
	public Emp_DepartDTO getJoin(EmployeeDTO employeeDTO) {
		
		Connection con = null;
		PreparedStatement st= null;
		ResultSet rs= null;
		Emp_DepartDTO emp_DepartDTO = null;
		
		try {
			con = dbConnect.getConnect();
			
			/*
			 * String sql = "SELECT E.LAST_NAME, E.SALARY, E.HIRE_DATE, D.DEPARTMENT_NAME "
			 * + "FROM EMPLOYEES E INNER JOIN DEPARTMENTS D " +
			 * "ON(E.DEPARTMENT_ID = D.DEPARTMENT_ID ) " + "WHERE E.EMPLOYEE_ID = ? ";
			 */
			
			StringBuffer sb = new StringBuffer();
			sb.append("SELECT E.LAST_NAME, E.SALARY, E.HIRE_DATE, D.DEPARTMENT_NAME");
			sb.append(" FROM EMPLOYEES E inner join DEPARTMENTS D");
			sb.append(" ON(E.DEPARTMENT_ID = D.DEPARTMENT_ID )");
			sb.append(" WHERE E.EMPLOYEE_ID = ?");
			
			st = con.prepareStatement(sb.toString());
			
			st.setInt(1, employeeDTO.getEmployee_id());
			
			rs = st.executeQuery();
						
			if(rs.next()) {
	
				emp_DepartDTO = new Emp_DepartDTO();
				emp_DepartDTO.setDepartmentDTO(new DepartmentDTO());
				
				emp_DepartDTO.setLast_name(rs.getString("last_name"));
				emp_DepartDTO.setSalary(rs.getInt("salary"));
				emp_DepartDTO.setHire_date(rs.getDate("hire_date"));
				emp_DepartDTO.getDepartmentDTO().setDepartment_name(rs.getString("department_name"));
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			dbConnect.disConnect(rs, st, con);
		}
		return emp_DepartDTO;
	}
	
	
	//getList - 전체 사원 출력
	public ArrayList<EmployeeDTO> getList() {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		//ArrayList 준비
		ArrayList<EmployeeDTO> ar = new ArrayList<EmployeeDTO>();
		
		try {
			//DB 접속
			con = dbConnect.getConnect();
			
			//SQL문 작성
			String sql = "SELECT * FROM EMPLOYEES";
			
			//미리 전송
			st  = con.prepareStatement(sql);
			
			//최종 전송 후 처리
			rs = st.executeQuery();
			
			while(rs.next()) {
				EmployeeDTO employeeDTO = new EmployeeDTO();
				employeeDTO.setEmployee_id(rs.getInt("employee_id"));
				employeeDTO.setFirst_name(rs.getString("first_name"));
				employeeDTO.setLast_name(rs.getString("last_name"));
				employeeDTO.setEmail(rs.getString("email"));
				employeeDTO.setPhone_number(rs.getString("phone_number"));
				employeeDTO.setHire_date(rs.getDate("hire_date"));
				employeeDTO.setJob_id(rs.getString("job_id"));
				employeeDTO.setSalary(rs.getInt("salary"));
				employeeDTO.setCommission_pct(rs.getDouble("commission_pct"));
				employeeDTO.setManager_id(rs.getInt("manager_id"));
				employeeDTO.setDepartment_id(rs.getInt("department_id"));
				ar.add(employeeDTO);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
		}
		return ar;
	}
	
	//2. 사원 번호 입력해서 사원 한명의 정보 출력
		public EmployeeDTO getOne(int employee_id) {
			
			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			EmployeeDTO employeeDTO = null;
			
			try {
				con = dbConnect.getConnect();
				
				String sql = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = ?";
				
				st =con.prepareStatement(sql);
				
				st.setInt(1, employee_id);
				rs = st.executeQuery();
				
				if(rs.next()) {
					employeeDTO = new EmployeeDTO();
					
					employeeDTO.setEmployee_id(rs.getInt("employee_id"));
					employeeDTO.setFirst_name(rs.getString("first_name"));
					employeeDTO.setLast_name(rs.getString("last_name"));
					employeeDTO.setEmail(rs.getString("email"));
					employeeDTO.setPhone_number(rs.getString("phone_number"));
					employeeDTO.setHire_date(rs.getDate("hire_date"));
					employeeDTO.setJob_id(rs.getString("job_id"));
					employeeDTO.setSalary(rs.getInt("salary"));
					employeeDTO.setCommission_pct(rs.getDouble("commission_pct"));
					employeeDTO.setManager_id(rs.getInt("manager_id"));
					employeeDTO.setDepartment_id(rs.getInt("department_id"));
					
				}else {
					System.out.println("정보가 없습니다");
				}
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}finally {
				dbConnect.disConnect(rs, st, con);
				
			}
			return employeeDTO;
		}
		
		//3. Last_name을 검색해서 정보 출력
		
		public ArrayList<EmployeeDTO> getSearch(String search) {
			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			ArrayList<EmployeeDTO> ar = new ArrayList<EmployeeDTO>();
			
			try {
				con = dbConnect.getConnect();
				
				String sql = "SELECT * FROM EMPLOYEES WHERE LAST_NAME LIKE ?";
				
				st = con.prepareStatement(sql);
				
				st.setString(1, "%"+search+"%");
				
				rs = st.executeQuery();
				
				while(rs.next()) {
					
					EmployeeDTO employeeDTO = new EmployeeDTO();
					
					employeeDTO.setEmployee_id(rs.getInt("employee_id"));
					employeeDTO.setFirst_name(rs.getString("first_name"));
					employeeDTO.setLast_name(rs.getString("last_name"));
					employeeDTO.setEmail(rs.getString("email"));
					employeeDTO.setPhone_number(rs.getString("phone_number"));
					employeeDTO.setHire_date(rs.getDate("hire_date"));
					employeeDTO.setJob_id(rs.getString("job_id"));
					employeeDTO.setSalary(rs.getInt("salary"));
					employeeDTO.setCommission_pct(rs.getDouble("commission_pct"));
					employeeDTO.setManager_id(rs.getInt("manager_id"));
					employeeDTO.setDepartment_id(rs.getInt("department_id"));
					ar.add(employeeDTO);
					
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}finally {
				dbConnect.disConnect(rs, st, con);
			}
			return ar;
			
		}
		
		//4. First_name을 검색해서 정보 출력
		
		public ArrayList<EmployeeDTO> getSearch1(String search) {
			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			ArrayList<EmployeeDTO> ar = new ArrayList<EmployeeDTO>();
			
			try {
				con = dbConnect.getConnect();
				
				String sql = "SELECT * FROM EMPLOYEES WHERE FIRST_NAME LIKE ?";
				
				st = con.prepareStatement(sql);
				
				st.setString(1, "%"+search+"%");
				
				rs = st.executeQuery();
				
				while(rs.next()) {
					
					EmployeeDTO employeeDTO = new EmployeeDTO();
					
					employeeDTO.setEmployee_id(rs.getInt("employee_id"));
					employeeDTO.setFirst_name(rs.getString("first_name"));
					employeeDTO.setLast_name(rs.getString("last_name"));
					employeeDTO.setEmail(rs.getString("email"));
					employeeDTO.setPhone_number(rs.getString("phone_number"));
					employeeDTO.setHire_date(rs.getDate("hire_date"));
					employeeDTO.setJob_id(rs.getString("job_id"));
					employeeDTO.setSalary(rs.getInt("salary"));
					employeeDTO.setCommission_pct(rs.getDouble("commission_pct"));
					employeeDTO.setManager_id(rs.getInt("manager_id"));
					employeeDTO.setDepartment_id(rs.getInt("department_id"));
					ar.add(employeeDTO);
					
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}finally {
				dbConnect.disConnect(rs, st, con);
			}
			return ar;
			
		}
		
		//5-1. 전체 평균 급여의 정보 출력
		
		public double getAvg() {
			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			
			double avg = 0.0; // 평균 급여 변수
			
			try {
				con = dbConnect.getConnect();
				
				String sql = "SELECT AVG(SALARY) FROM EMPLOYEES";
				
				st = con.prepareStatement(sql);
				
				rs = st.executeQuery();
				
				rs.next();
				
				avg = rs.getDouble(1);
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}finally {
				dbConnect.disConnect(rs, st, con);
			}
			return avg;
		}
		
		//5-2. 부서별 평균 급여의 정보 출력
		
		public ArrayList<Double> getAvgs() {
			Connection con = null;
			PreparedStatement st = null;
			ResultSet rs = null;
			
			ArrayList<Double> ar  = new ArrayList<Double>();
			
			try {
				con = dbConnect.getConnect();
				
				String sql = "SELECT AVG(SALARY) FROM EMPLOYEES GROUP BY DEPARTMENT_ID";
				
				st = con.prepareStatement(sql);
			
				rs = st.executeQuery();
				
				while(rs.next()) {
					 
					double avg = rs.getDouble(1);
					ar.add(avg);
				
				}
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}finally {
				dbConnect.disConnect(rs, st, con);
			}
			return ar;
		
		}
}
