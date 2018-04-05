package com.java.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InputForm extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String usrnm = req.getParameter("usrnm");
		String pwd = req.getParameter("pass");
		String htmlResp = "<html><body>user name you entered is:" +usrnm 
							+"<br>The password you entered is: "+pwd
							+"</body></html>";
		resp.setContentType("html/text");
		PrintWriter out = resp.getWriter();
		out.print(htmlResp);
	}
}
