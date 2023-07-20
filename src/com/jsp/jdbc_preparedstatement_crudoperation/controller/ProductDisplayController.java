package com.jsp.jdbc_preparedstatement_crudoperation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDisplayController {

	public static void main(String[] args) {
		Connection Connection=null;
		
		try {
			//step-1 load/register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step-2 create connection
			String url="jdbc:mysql://localhost:3306/jdbc_preparedstatement";
			String user="root";
			String pass="root";
			Connection=DriverManager.getConnection(url,user,pass);
			 //step-3 create statement
			
			String displayQuery="select * from product";
			PreparedStatement preparedStatement=Connection.prepareStatement(displayQuery);
			ResultSet resultSet=preparedStatement.executeQuery();
			 while(resultSet.next()) {
				 int id=resultSet.getInt("productid");
				 String name=resultSet.getString("productname");
				 Double price=resultSet.getDouble("productprice");
				String color=resultSet.getString("productcolor");
				
				System.out.println("id="+id);
				System.out.println("name="+name);
				System.out.println("price="+price);
				System.out.println("color="+color);
						 
		         System.out.println("================");
				 
			 }
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				Connection.close();
			}catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
				
		}
	}

}

