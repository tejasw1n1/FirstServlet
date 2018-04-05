package com.java.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServletEx extends  HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Date d1 = new Date();
		
		//resp.setHeader("refresh", "3");
		
		System.out.println(d1);
		String htmlResp = "<html>"
							+"<body>"
							+"<p>The current time is: "+d1+"</p>"
							+"</body>"
						  +"</html>";
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.print(htmlResp);
	}
}