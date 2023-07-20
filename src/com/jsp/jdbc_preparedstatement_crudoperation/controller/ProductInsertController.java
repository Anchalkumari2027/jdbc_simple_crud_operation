package com.jsp.jdbc_preparedstatement_crudoperation.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductInsertController {

	public static void main(String[] args) {
		
	Connection connection=null;
			
			try {
				//step-1 load/register driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//step-2 create connection
				String url = "jdbc:mysql://localhost:3306/jdbc_preparedstatement";
				String user = "root";
				String pass = "root";
				
				
			    connection = DriverManager.getConnection(url,user,pass);
			    
			    // step-4 execute query
			    String insertQuery ="insert into product values(?,?,?,?)";
				
				//step-3 create statement
			    		
			    PreparedStatement preparedStatement=connection.prepareStatement(insertQuery);	
			    
			    preparedStatement.setInt(1, 100);
			    preparedStatement.setString(2, "pen");
			    preparedStatement.setDouble(3, 43);
			    preparedStatement.setString(4, "black");
			    
			    preparedStatement.setInt(1, 400);
			    preparedStatement.setString(2, "pencil");
			    preparedStatement.setDouble(3, 50);
			    preparedStatement.setString(4, "grey");
			    
			    
			    preparedStatement.execute();
			    System.out.println("data has inserted sucessfully");
				
			} catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					connection.close();
				}catch(SQLException e) {
					//TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	}
}
