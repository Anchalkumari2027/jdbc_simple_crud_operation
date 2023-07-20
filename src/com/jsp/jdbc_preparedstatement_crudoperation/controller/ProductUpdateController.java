package com.jsp.jdbc_preparedstatement_crudoperation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductUpdateController {

	public static void main(String[] args) {
		Connection connection=null;
		 
		try {
			//step-1:load /register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step-2: create connection
			String url="jdbc:mysql://localhost:3306/jdbc_preparedstatement";
			String user="root";
			String pass="root";
			
			connection=DriverManager.getConnection(url,user,pass);
			String updateColorQuery="update product set productcolor=? where productid=?";
			//step -3: create Statement
			
			PreparedStatement preparedStatement=connection.prepareStatement(updateColorQuery);
			preparedStatement.setString(1,"aqua");
			preparedStatement.setInt(2,200);
			int a=preparedStatement.executeUpdate();
			if(a==1) {
				System.out.println("data is updated successfully");
			}else {
				System.err.println("giver data is not present");
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				//TODO auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
