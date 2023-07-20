package com.jsp.jdbc_preparedstatement_crudoperation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDeleteController {

	public static void main(String[] args) {
		Connection connection=null;
		
		try {
			//step-1 load  /register Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//step-2 create connection
			
			String url="jdbc:mysql://localhost:3306/jdbc_preparedstatement";
			String user="root";
			String password="root";
			
		    connection=DriverManager.getConnection(url,user,password);
		    
		    //step -3 create statement
		    String deletQuery="delete from product where productid=?";
		    PreparedStatement preparedStatement=connection.prepareStatement(deletQuery);
		    preparedStatement.setInt(1, 300);
		    
		    int a=preparedStatement.executeUpdate();
		    
		    if(a==1) {
		    	System.out.println("data is deleted sucessfully");
		    }else {
		    	System.err.println("giver id is not present");
		    }
			
		} catch (ClassNotFoundException |SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			}catch(SQLException e) {
				//TODO Auto-generate catch block
				e.printStackTrace();
			}
		}
		

	}

}
