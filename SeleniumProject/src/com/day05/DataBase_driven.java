package com.day05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//import com.mysql.jdbc.Driver;

public class DataBase_driven {
	static String dbURL = "jdbc:mysql://localhost:3306/schema1";
	static String uname = "anv246";
	static String password = "Password@1";
	
	public static void main(String args[]) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //com.mysql.jdbc.Driver class is deprecated and hence, mentioned new driver class path
			Connection con = DriverManager.getConnection(dbURL, uname, password);
			if(con!=null) {
				System.out.println("connection to database successful");
			}
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from studentdetails;");
			
			while(rs.next()) {
				
				String stud_id = rs.getString("id");
				String stud_name = rs.getString(2);
				String age = rs.getString(3);
				System.out.println(stud_id+" "+stud_name+" "+age);
			}
			//rs.close(); we don't need to call close method for resultset object if the statement object is closed. because when statement obj is closed, the resultset obj(if one exists)  is also closed
			PreparedStatement create = con.prepareStatement("create table if not exists test2_table(name varchar(25) not null, age int not null, PRIMARY KEY(name));");
			create.executeUpdate();
			System.out.println("table created successfully");
			create.close();
			stmt.close();
			con.close();
			
		} catch (SQLException | ClassNotFoundException e) {
			
			e.printStackTrace();
			System.out.println("connection to database failed");
		}
		amazondata();
		
	}

	public static void amazondata() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con1 = DriverManager.getConnection(dbURL, uname, password);
			Statement stmt = con1.createStatement();
			ResultSet rs = stmt.executeQuery("select * from amazon_data;");
			while(rs.next()) {
				String prod = rs.getString(2);
				String cat = rs.getString(3);
				System.out.println(prod+" "+cat);
			}
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
