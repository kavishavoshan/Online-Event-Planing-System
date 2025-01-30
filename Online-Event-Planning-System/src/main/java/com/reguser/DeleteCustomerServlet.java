package com.reguser;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/DeleteCustomerServlet")
public class DeleteCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		boolean isTrue;
		
		isTrue = regUserDBUtil.deletecustomer(id);
		
		if(isTrue == true) {
			
			RequestDispatcher dis = request.getRequestDispatcher("Registration.jsp");
			dis.forward(request, response);
			
		}
		else {
			
			List<Customer> cusD = regUserDBUtil.getcustomerDetails(id);
			request.setAttribute("cusD",cusD);
			
			RequestDispatcher dis = request.getRequestDispatcher("UserProfile.jsp");
			dis.forward(request, response);
			
		}  

		
		
	}

}