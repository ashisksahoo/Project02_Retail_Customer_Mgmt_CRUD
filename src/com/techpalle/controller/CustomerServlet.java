package com.techpalle.controller;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.techpalle.model.Customer;
import com.techpalle.dao.AdminDAO;
import com.techpalle.dao.CustomerDAO;
@WebServlet("/")
public class CustomerServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String path = request.getServletPath();
		switch (path)
		{
		case "/deleteCustomer":
			deleteCustomer(request, response);
			break;
		case "/updateCustomer":
			updateCustomer(request, response);
			break;
		case "/selectCustomerById":
			selectCustomerById(request, response);
			break;
		case "/formPage":
			redirectToFormPage(request, response);
			break;
		case "/insertCustomer":
			insertCustomer(request, response);
			break;
		case "/listCustomer":
			showAllCustomerDetails(request, response);
			break;
		case "/validateAdmin":
			validateAdmin(request, response);
			break;
		case "/logoutPage":
			logoutPage(request, response);
			break;
		case "/loginPage":
			adminLoginForm(request, response);
			break;
		default:
			projectHomePage(request, response);
			break;
		}
	}
	
	private void projectHomePage(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			RequestDispatcher rd = request.getRequestDispatcher("homepage.jsp");
			rd.forward(request, response);
		}
		catch (IOException | ServletException e) { e.printStackTrace(); }
	}

	private void logoutPage(HttpServletRequest request, HttpServletResponse response) 
	{
		request.getSession(false).invalidate();
		projectHomePage(request, response);
	}

	private void adminLoginForm(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}
		catch (IOException | ServletException e) { e.printStackTrace(); }
	}

	private void validateAdmin(HttpServletRequest request, HttpServletResponse response)
	{
		String name = request.getParameter("tbNameLog");
		String pass = request.getParameter("tbPassLog");
		boolean res = AdminDAO.validateAdmin(name, pass);
		if(res) { showAllCustomerDetails(request, response); }
		else { adminLoginForm(request, response); }
	}
	
	private void deleteCustomer(HttpServletRequest request, HttpServletResponse response)
	{
		int id = Integer.parseInt(request.getParameter("deletebyid"));
		CustomerDAO.deleteCustomer(id);
		try { response.sendRedirect("listCustomer"); }
		catch (IOException e) { e.printStackTrace(); }
	}
	
	private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
	{
		int id = Integer.parseInt(request.getParameter("tbId"));
		String name = request.getParameter("tbName");
		String mail = request.getParameter("tbEmail");
		long mob = Long.parseLong(request.getParameter("tbMobile"));
		Customer cu = new Customer(id, name, mail, mob);
		CustomerDAO.updateCustomer(cu);
		try { response.sendRedirect("listCustomer"); }
		catch (IOException e) { e.printStackTrace(); }
	}
	
	private void selectCustomerById(HttpServletRequest request, HttpServletResponse response)
	{
		int id = Integer.parseInt(request.getParameter("showbyid"));
		Customer cu = CustomerDAO.selectCustomerById(id);
		try
		{
			RequestDispatcher rd = request.getRequestDispatcher("form.jsp");
			request.setAttribute("customer", cu);
			rd.forward(request, response);
		}
		catch (ServletException | IOException e) { e.printStackTrace(); }
	}
	
	private void redirectToFormPage(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			RequestDispatcher rd =  request.getRequestDispatcher("form.jsp");
			rd.forward(request, response);
		}
		catch (ServletException | IOException e) { e.printStackTrace(); }
	}
	
	private void insertCustomer(HttpServletRequest request, HttpServletResponse response)
	{
		String name = request.getParameter("tbName");
		String mail = request.getParameter("tbEmail");
		long mob = Long.parseLong(request.getParameter("tbMobile"));
		Customer cus = new Customer(name, mail, mob);
		CustomerDAO.insertCustomer(cus);
		showAllCustomerDetails(request, response);
	}
	
	private void showAllCustomerDetails(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			ArrayList<Customer> allCustomer = CustomerDAO.showAllCustomer();
			RequestDispatcher rd =  request.getRequestDispatcher("list.jsp");
			request.setAttribute("list", allCustomer);
			rd.forward(request, response);
		}
		catch (ServletException | IOException e) { e.printStackTrace(); }
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}
}
