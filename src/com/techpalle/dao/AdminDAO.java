package com.techpalle.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class AdminDAO
{
	private static Connection con = null; 
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;
	private static final String validateAdmin = "SELECT aname, apass FROM cadmin WHERE aname = ? AND apass = ?";
	public static boolean validateAdmin(String uname, String upass)
	{
		boolean valid = false;
		  try
		  {
		   con = CustomerDAO.connectionStart();
		   ps = con.prepareStatement(validateAdmin);
		   ps.setString(1, uname);
		   ps.setString(2, upass);
		   rs = ps.executeQuery();
		   valid = rs.next();
		  }
		  catch (SQLException e) { e.printStackTrace(); }
		  finally { CustomerDAO.connectionCloseResultSet(); }
		  return valid;
	}
}
