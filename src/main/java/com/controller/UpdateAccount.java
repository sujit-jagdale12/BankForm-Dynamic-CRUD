package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Bank;
import com.dao.BankDao;

/**
 * Servlet implementation class UpdateAccount
 */
@WebServlet("/UpdateAccount")
public class UpdateAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Bank bank=new Bank();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id=Integer.parseInt(request.getParameter("id"));
		bank=BankDao.getAccountId(id);
		
		HttpSession httpSession=request.getSession();
		httpSession.setAttribute("account", bank);
		
		response.sendRedirect("updateAccount.jsp");
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		int ac=Integer.parseInt(request.getParameter("acc_no"));
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		int ifsc=Integer.parseInt(request.getParameter("ifsc"));
		
		bank.setAcc_no(ac);
		bank.setName(name);
		bank.setAddress(address);
		bank.setIfsc(ifsc);
		int a=BankDao.updateAccount(bank);
		
		PrintWriter writer=response.getWriter();
		if(a>0) {
			writer.print("Updated..");
			RequestDispatcher dispatcher=request.getRequestDispatcher("View.jsp");
			dispatcher.include(request, response);
		}
		else {
			writer.print("Not Updated..");
			RequestDispatcher dispatcher=request.getRequestDispatcher("View.jsp");
			dispatcher.include(request, response);
		}
	}

}
