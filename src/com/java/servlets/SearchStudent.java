package com.java.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;

public class SearchStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int regNo = Integer.parseInt(request.getParameter("regNo"));
		
		Connection con = null;
		PreparedStatement pstmt=null;
		Statement stmt = null;
		ResultSet rs = null;
		
		System.out.println(regNo);
		
		try 
		{

			//1.Load the Driver
			Driver driverRef = new Driver();
			DriverManager.registerDriver(driverRef);
			
			//2.Get the DB connection via "Driver"			
			String dbUrl = "jdbc:mysql://localhost:3306/BECME20_DB?user=root&password=teju";
			
			//getConnection with only 1 String parameter- dbUrl
			con = DriverManager.getConnection(dbUrl);
			
			//3.Issue "SQL Queries" via "Connection"
			//String query=" insert into Employee values(?, ?) ";
			
			//to update a record in table...
			/*String query =" update students_info "
						  + " set firstName='Seenu', middleName='NA', lastName='R K' "
						  + " where regNo=6 ";*/
			
			//to delete a record from table...
			String query = " delete from students_info where regNo= 4 ";
			
			stmt = con.createStatement();
			int n=stmt.executeUpdate(query);
			
			//process the result set
			System.out.println(n);
			
			String htmlResp;
			
			htmlResp="<html><body>" +
					"<h4>" +
					"<font color=\"red\"" +n+" : Not Present!!! </font></h4>"+
					"</body>" +
					"</html>";
			
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println(htmlResp);
			
			/*
			if(rs.next()){
				int regNO = rs.getInt("regNO");
				String fNm = rs.getString("firstName");
				String mNm = rs.getString("middleName");
				String lNm = rs.getString("lastName");
				
				htmlResp = "<html><head><title>Student Info...</title></head>" +
						" <body> <table>" +
						"<tr background-color=\"green\">" +
							"<td>RegNo</td>" +
							"<td>First Name</td>" +
							"<td>Middle Name</td>" +
							"<td>Last Name</td>" +
						"</tr>" +
						"<tr>" +
							"<td>" +regNO +"</td>" +
							"<td>" +fNm +"</td>" +
							"<td>" +mNm +"</td>" +
							"<td>" +lNm +"</td>" +
						"</tr>" +
						"</table>" +
						"</body></html>";
				
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println(htmlResp);
			}
			else{
				int regNO = rs.getInt("regNO");
				htmlResp="<html><body>" +
						"<h4>" +
						"<font color=\"red\"" +regNO+" : Not Present!!! </font></h4>"+
						"</body>" +
						"</html>";
				
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println(htmlResp);
			}*/

		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			//5.Close all the "JDBC Objects"
				try {
					if(con!=null){
						con.close();
					}
					if(pstmt!=null){
						pstmt.close();
					}
					if(rs!=null){
						rs.close();
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		

	}

}
