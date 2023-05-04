package com.techpalle.dao;
import java.sql.*;
import java.util.ArrayList;
import com.techpalle.model.Customer;
public class CustomerDAO
{
	private static Connection con = null; 
	private static Statement s = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	private static Customer cust = null;
	private static final String dbDriver = "com.mysql.cj.jdbc.Driver";
	private static final String dbUrl = "jdbc:mysql://localhost:3306/customer_management";
	private static final String dbUsername = "root";
	private static final String dbPassword = "admin";
	private static final String showAllCustomer = "SELECT * FROM customer";
	private static final String insertCustomer = "INSERT INTO customer(cname, cemail, cmobile) VALUES(?, ?, ?)";
	private static final String selectCustomerById = "SELECT * FROM customer WHERE cid = ?";
	private static final String updateCustomer = "UPDATE customer SET cname = ?, cemail = ?, cmobile = ?  WHERE cid = ?";
	private static final String deleteCustomer = "DELETE FROM customer WHERE cid = ?";
	
	public static Connection connectionStart()
	{
		try
		{
			Class.forName(dbDriver);
			con = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
		}
		catch (ClassNotFoundException | SQLException e) { e.printStackTrace(); }
		return con;
	}
	
	public static Connection connectionClosePreparedStatement()
	{
		try
		{
			if(ps != null) { ps.close(); } 
			if(con != null) { con.close(); } 
		}
		catch (SQLException e) { e.printStackTrace(); }
		return con;
	}
	
	public static Connection connectionCloseStatement()
	{
		try 
		{
			if(rs != null) { rs.close(); } 
			if(s != null) { s.close(); } 
			if(con != null) { con.close(); }
		}
		catch (SQLException e) { e.printStackTrace(); }
		return con;
	}
	
	public static Connection connectionCloseResultSet()
	{
		try 
		{
			if(rs != null) { rs.close(); } 
			if(ps != null) { ps.close(); } 
			if(con != null) { con.close(); }
		}
		catch (SQLException e) { e.printStackTrace(); }
		return con;
	}
	
	public static ArrayList<Customer> showAllCustomer()
	{
		ArrayList<Customer> list = new ArrayList<Customer>();
		try
		{
			con = connectionStart();
			s = con.createStatement();
			rs = s.executeQuery(showAllCustomer);
			while (rs.next())
			{
				int id = rs.getInt("cid");
				String name = rs.getString("cname");
				String mail = rs.getString("cemail");
				Long mob = rs.getLong("cmobile");
				cust = new Customer(id, name, mail, mob);
				list.add(cust);
		   }
		}
		catch (SQLException e) { e.printStackTrace(); }
		finally { connectionCloseStatement(); }
		return list;
	}
	
	public static void insertCustomer(Customer cus)
	{
		try
		{
			con = connectionStart();
			ps = con.prepareStatement(insertCustomer);
			ps.setString(1, cus.getCname()); 
			ps.setString(2, cus.getCemail()); 
			ps.setLong(3, cus.getCmobile());
			ps.executeUpdate();
			System.out.println("data inserted successfully\n");
		}
		catch (SQLException e)
		{
			if(e instanceof SQLIntegrityConstraintViolationException)
			{
				System.out.println("duplicate entry of email\n");
			}
		}
		finally { connectionClosePreparedStatement(); }
	}
	
	public static Customer selectCustomerById(int id)
	{
		try
		{
			con = connectionStart();
			ps = con.prepareStatement(selectCustomerById);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			rs.next();
			int cusid = rs.getInt("cid");
			String cusname = rs.getString("cname");
			String cusmail = rs.getString("cemail");
			long cusmob = rs.getLong("cmobile");
			cust = new Customer(cusid, cusname, cusmail, cusmob);
		}
		catch (SQLException e) { e.printStackTrace(); }
		finally { connectionCloseResultSet(); }
		return cust;
	}
	
	public static void updateCustomer(Customer cus)
	{
		try
		{
			con = connectionStart();
			ps = con.prepareStatement(updateCustomer);
			ps.setString(1, cus.getCname());
			ps.setString(2, cus.getCemail()); 
			ps.setLong(3, cus.getCmobile());
			ps.setInt(4, cus.getCid());
			ps.executeUpdate();
			System.out.println("data updated successfully\n");
		}
		catch ( SQLException e) { e.printStackTrace(); }
		finally { connectionClosePreparedStatement(); }
	}
	
	public static void deleteCustomer(int id)
	{
		try
		{
			con = connectionStart();
			ps = con.prepareStatement(deleteCustomer);
			ps.setInt(1, id);
			ps.executeUpdate();
			System.out.println("data deleted successfully\n");
		}
		catch (SQLException e) { e.printStackTrace(); }
		finally { connectionClosePreparedStatement(); }
	}
	
}
