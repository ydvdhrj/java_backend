package com.connectdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FindStudentData {
	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5433/school";
		String un = "postgres";
		String pwd = "root";
		
		
		try {
			//load the driver
			Class.forName("org.postgresql.Driver");
			
			// make the connection
			Connection connect = DriverManager.getConnection(url,un,pwd);
			
			//right the select query
			String sql = "select * from student";
			
			
			//create statement
			Statement stmt = connect.createStatement();
			
			//execute the query
			ResultSet res = stmt.executeQuery(sql);  //executeQuery -> it is used to execute select queries
			
			while(res.next()) {
				System.out.println(res.getInt(1)+" "+res.getString(2)+" "+res.getString(3)+" "+res.getString(4));
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
