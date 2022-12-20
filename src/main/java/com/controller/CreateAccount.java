package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Bank;
import com.dao.BankDao;

/**
 * Servlet implementation class CreateAccount
 */
@WebServlet("/CreateAccount")
public class CreateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		Bank b=new Bank();
		PrintWriter writer=response.getWriter();
		
		int accNo=Integer.parseInt(request.getParameter("acc_no"));
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		int ifsc=Integer.parseInt(request.getParameter("ifsc"));
		
		b.setAcc_no(accNo);
		b.setName(name);
		b.setAddress(address);
		b.setIfsc(ifsc);
		
		int ans=BankDao.insert(b);
		
		if(ans>0) {
			writer.print("Account created..");
			RequestDispatcher dispatcher=request.getRequestDispatcher("LoginBank.jsp");
			dispatcher.include(request, response);
		}else {
			writer.print("Error!!");
			RequestDispatcher dispatcher=request.getRequestDispatcher("LoginBank.jsp");
			dispatcher.include(request, response);
		}
	
	
	}

}
