package com.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FindEmployeeData {
	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5433/school";
		String un = "postgres";
		String pwd = "root";
		
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection connect = DriverManager.getConnection(url,un,pwd);
			
			String sql = "select * from employee";
			
			Statement stmt = connect.createStatement();
			
			ResultSet res = stmt.executeQuery(sql);
			
			while(res.next()) {
				System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getDouble(3)+" "+res.getString(4));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
