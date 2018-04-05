package com.java.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateProfileServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String regNo = req.getParameter("regno");
		String pwd = req.getParameter("pass");
		String isAdmin = req.getParameter("isadmin");
		
		String courseValues[] = req.getParameterValues("course");
		
		String stdFirNm = req.getParameter("stdfirnm");
		String stdMdlNm = req.getParameter("stdmdlnm");
		String stdLstNm = req.getParameter("stdlstnm");
		
		String guaFirNm = req.getParameter("guafirnm");
		String guaMdlNm = req.getParameter("guamdlnm");
		String guaLstNm = req.getParameter("gualstnm");
		
		String presentAddr1 = req.getParameter("addr1");
		String presentAddr2 = req.getParameter("addr2");
		String presentLnmark = req.getParameter("lnmark");
		String presentCity = req.getParameter("city");
		String presentPincode = req.getParameter("pincode");
		
		String permanentAdr1 = req.getParameter("adr1");
		String permanentAdr2 = req.getParameter("adr2");
		String permanentLndmark = req.getParameter("lndmark");
		String permanentCty = req.getParameter("cty");
		String permanentPncode = req.getParameter("pncode");
		
		String htmlResp="<html>"
							+"<p>Reg No is:" +regNo+"</p>"
							+"<p>Password is:" +pwd+"</p>"
							+"<p>Is Admin : "+isAdmin+"</p>"
							+"</br>"
							+"<p>The courses you selected are: "+ courseValues
							+"<p>Student First name is:" +stdFirNm+"</p>"
							+"<p>Student Second name is:" +stdMdlNm+"</p>"
							+"<p>Student Last name is: "+stdLstNm+"</p>"
							+"</br>"
							
							+"<p>Guardian First name is:" +guaFirNm+"</p>"
							+"<p>Guardian Middle name is:" +guaMdlNm+"</p>"
							+"<p>Guardian last name : "+guaLstNm+"</p>"
							+"</br>"
							
							+"<p>Address1:" +presentAddr1+"</p>"
							+"<p>Address2:" +presentAddr2+"</p>"
							+"<p>Landmark: "+presentLnmark+"</p>"
							+"<p>Present city is:" +presentCity+"</p>"
							+"<p>Present Pincode is:" +presentPincode+"</p>"
							+"</br>"
							
							+"<p>Address1 : "+permanentAdr1+"</p>"
							+"<p>Address2:" +permanentAdr2+"</p>"
							+"<p>Landmark:" +permanentLndmark+"</p>"
							+"<p>Permanent City: "+permanentCty+"</p>"
							+"<p>Permanent Pincode:"+permanentPncode+"</p>"
						+"</html>";
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println(htmlResp);
	}
	

}
