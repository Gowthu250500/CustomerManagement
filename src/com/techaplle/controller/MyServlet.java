package com.techaplle.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techpalle.dao.DataAccess;
import com.techpalle.model.Customer;
import com.techpalle.util.SuccessPage;


@WebServlet("/")
public class MyServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String path = request.getServletPath();
		
		switch(path)
		{
		case"/logCustomer":
			validCustomer(request, response);
			break;
		case"/regCustomer":
			insertCustomer(request, response);
			break;
		case"/reg":
			getRegistrationPage(request, response);
			break;
		case"/log":
			getLoginPage(request, response);
			break;
			default:
				getStartUpPage(request, response);
				break;
		}
	}

	
	private void validCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
		String e = request.getParameter("tbEmail");
		String p = request.getParameter("tbPass");
		
		boolean res = DataAccess.validCustomer(e, p);
		
		if(res)
		{
			try
			{
				RequestDispatcher rd = request.getRequestDispatcher("success.jsp");
				
				SuccessPage sp = new SuccessPage();
				request.setAttribute("successDetails", sp);
				
				rd.forward(request, response);
			} 
			catch (ServletException | IOException e1) 
			{
				e1.printStackTrace();
			}
		}
		else
		{
			getLoginPage(request, response);
		}
	}


	private void insertCustomer(HttpServletRequest request, HttpServletResponse response) 
	{
		String n = request.getParameter("tbCname");
		String e = request.getParameter("tbCemail");
		long m = Long.parseLong(request.getParameter("tbMob"));
		String p = request.getParameter("tbCpass");
		String s = request.getParameter("ddlStates");
		
		Customer c = new Customer(n, e, m, p, s);
		
		DataAccess.insertCustomer(c);
		
		getLoginPage(request, response);

	}


	private void getRegistrationPage(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			RequestDispatcher rd = request.getRequestDispatcher("customer_registration.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException | IOException e) 
		{
			e.printStackTrace();
		}
	}


	private void getLoginPage(HttpServletRequest request, HttpServletResponse response) 
	{
		try
		{
			RequestDispatcher rd = request.getRequestDispatcher("customer_login.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException | IOException e) 
		{
			e.printStackTrace();
		}
	}


	private void getStartUpPage(HttpServletRequest request, HttpServletResponse response) 
	{
		try
		{
			RequestDispatcher rd = request.getRequestDispatcher("customer_management.jsp");
			rd.forward(request, response);
		} 
		catch (ServletException | IOException e) 
		{
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}

