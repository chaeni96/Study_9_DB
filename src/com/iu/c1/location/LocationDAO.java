package com.iu.c1.location;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.iu.c1.employee.EmployeeDTO;
import com.iu.c1.util.DBConnect;



public class LocationDAO {
	
	private DBConnect dbConnect;
	public LocationDAO() {
		dbConnect = new DBConnect();
	}
	
	
	public LocationDTO getLocation(int employee_id) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		LocationDTO locationDTO = null;
		try {
			con = dbConnect.getConnect();
			
			String sql = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = "
					+ "(SELECT LOCATION_ID FROM DEPARTMENTS WHERE DEPARTMENT_ID = "
					+ "(SELECT DEPARTMENT_ID FROM EMPLOYEES WHERE EMPLOYEE_ID = ? )) ";
			
			st = con.prepareStatement(sql);
			
			st.setInt(1, employee_id);
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				locationDTO = new LocationDTO();
				locationDTO.setLocation_id(rs.getInt("location_id"));
				locationDTO.setStreet_address(rs.getString("street_address"));
				locationDTO.setPostal_code(rs.getString("postal_code"));
				locationDTO.setCity(rs.getString("city"));
				locationDTO.setState_province(rs.getString("state_province"));
				locationDTO.setCountry_id(rs.getString("country_id"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
		}
		return locationDTO;
		
	}
	
	
	//getCount 
	//location의 주소 개수를 리턴하고 출력
	
	public int getCount() {
		
		Connection con = null;
		PreparedStatement st =  null;
		ResultSet rs = null;
		
		int count = 0;
		
		try {
			con = dbConnect.getConnect();
			
			String sql = "SELECT COUNT(LOCATION_ID) FROM LOCATIONS";
			
			st = con.prepareStatement(sql);
			
			rs = st.executeQuery();
			
			rs.next();
			
			//rs.getInt(컬럼명 또는 인덱스 번호)
			count = rs.getInt(1);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
		}
		return count;

	} 
	
	//getSearch
	//주소의 일부를 받아서 검색해서 찾은 것들을 출력
	
	public ArrayList<LocationDTO> getSearch(String search) {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<LocationDTO> ar = new ArrayList<LocationDTO>();
		
		try {
			//1. Connection
			con = dbConnect.getConnect();
			
			//2. SQL문 생성
            //첫번째 방법 String sql = "SELECT * FRON LOCATIONS WHERE STREET_ADDRESS LIKE '%'||?||'%'";
			String sql = "SELECT * FROM LOCATIONS WHERE STREET_ADDRESS LIKE ?";
			
			//3. 미리 전송
			st = con.prepareStatement(sql);
			
			//4. ? 설정
			st.setString(1, "%"+search+"%");
			
			//5. 최종 전송 후 결과 처리
			rs = st.executeQuery();
			
			while(rs.next()) {
				
				LocationDTO locationDTO = new LocationDTO();
				locationDTO.setLocation_id(rs.getInt("location_id"));
				locationDTO.setStreet_address(rs.getString("street_address"));
				locationDTO.setPostal_code(rs.getString("postal_code"));
				locationDTO.setCity(rs.getString("city"));
				locationDTO.setState_province(rs.getString("state_province"));
				locationDTO.setCountry_id(rs.getString("country_id"));
				ar.add(locationDTO);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
		} return ar;
		
		
	}
	
	
	//Location Table에서 id와 일치하는 정보 조회
	public LocationDTO getOne(int location_id) {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		LocationDTO locationDTO = null;
		
		
		try {
			con = dbConnect.getConnect();
			
			System.out.println("DB 연결 성공");
			
			String spl = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = ?";
			
			st = con.prepareStatement(spl);
			
			st.setInt(1, location_id);
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				//출력
				locationDTO = new LocationDTO();
				locationDTO.setLocation_id(rs.getInt("location_id"));
				locationDTO.setStreet_address(rs.getString("street_address"));
				locationDTO.setPostal_code(rs.getString("postal_code"));
				locationDTO.setCity(rs.getString("city"));
				locationDTO.setState_province(rs.getString("state_province"));
				locationDTO.setCountry_id(rs.getString("country_id"));
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {	
				dbConnect.disConnect(rs, st, con);
		}
		
		return locationDTO;
		
	}
	
	
	//LOCATIONS Table을 조회해서 출력
	
	public ArrayList<LocationDTO> getList() {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<LocationDTO> ar = new ArrayList<LocationDTO>();
		
		try {
			//Class.forName(driver);
			System.out.println("Driver 로딩 성공");
			
			con = dbConnect.getConnect();
			
			System.out.println("DB 연결 성공");
			System.out.println(con);
			
			String sql = "SELECT * FROM LOCATIONS";
			
			st = con.prepareStatement(sql);
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				LocationDTO locationDTO = new LocationDTO();
				locationDTO.setLocation_id(rs.getInt("location_id"));
				locationDTO.setStreet_address(rs.getString("street_address"));
				locationDTO.setPostal_code(rs.getString("postal_code"));
				locationDTO.setCity(rs.getString("city"));
				locationDTO.setState_province(rs.getString("state_province"));
				locationDTO.setCountry_id(rs.getString("country_id"));
				ar.add(locationDTO);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
		}
		return ar;
		
	} 

}
