package com.iu.c1.location;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.iu.c1.util.DBConnect;

public class LocationDAO {
	
	private DBConnect dbConnect;
	public LocationDAO() {
		dbConnect = new DBConnect();
	}
	
	//Location Table에서 id와 일치하는 정보 조회
	public void getOne(int location_id) {
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			con = dbConnect.getConnect();
			
			System.out.println("DB 연결 성공");
			
			String spl = "SELECT * FROM LOCATIONS WHERE LOCATION_ID = ?";
			
			st = con.prepareStatement(spl);
			
			st.setInt(1, location_id);
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				//출력
				System.out.print(rs.getInt("LOCATION_ID")+"\t");
				System.out.print(rs.getString("STREET_ADDRESS")+"\t");
				System.out.print(rs.getString("POSTAL_CODE")+"\t");
				System.out.print(rs.getString("CITY")+"\t");
				System.out.print(rs.getString("STATE_PROVINCE")+"\t");
				System.out.println(rs.getString("COUNTRY_ID"));
				System.out.println("----------------------------------------------------------------------------------");			}else {
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {	
				dbConnect.disConnect(rs, st, con);
		}
		
		
	}
	
	
	//LOCATIONS Table을 조회해서 출력
	
	public void getList() {
		
		
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
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
				System.out.print(rs.getInt("LOCATION_ID")+"\t");
				System.out.print(rs.getString("STREET_ADDRESS")+"\t");
				System.out.print(rs.getString("POSTAL_CODE")+"\t");
				System.out.print(rs.getString("CITY")+"\t");
				System.out.print(rs.getString("STATE_PROVINCE")+"\t");
				System.out.println(rs.getString("COUNTRY_ID"));
				System.out.println("----------------------------------------------------------------------------------");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			dbConnect.disConnect(rs, st, con);
		}
		
		
	}

}
