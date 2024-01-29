package newproject.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import newproject.dto.Employee;

public class EmployeeDao
{
	public Connection getConnection() throws SQLException
	{
		Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedata?user=root&password=root@123");
		return conn;
	}
	
	public int saveEmployee(Employee e) throws SQLException
	{
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("insert into new_table values(?,?,?,?,?)");
		pst.setInt(1, e.getId());
		pst.setString(2, e.getName());
		pst.setString(3, e.getEmail());
		pst.setLong(4, e.getContact());
		pst.setString(5, e.getPassword());
		
		int res=pst.executeUpdate();
		return res;
	}
	
	public Employee findbyid( int id) throws SQLException
	{
		Connection con =getConnection();
		PreparedStatement pst=con.prepareStatement("select * from new_table where id=?");
		pst.setInt(1, id);
		ResultSet rs=pst.executeQuery();
		Employee emp=new Employee();
		    rs.next();
			emp.setId(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setEmail(rs.getString(3));
			emp.setContact(rs.getLong(4));
			emp.setPassword(rs.getString(5));
		return emp;
	}
	
	public Employee findbyemail(String email) throws SQLException
	{
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("select * from new_table where email=?");
		pst.setString(1, email);
		ResultSet rs=pst.executeQuery();
		Employee emp=new Employee();
		while(rs.next())
		{
			emp.setId(rs.getInt(1));
			emp.setName(rs.getString(2));
			emp.setEmail(rs.getString(3));
			emp.setContact(rs.getLong(4));
			emp.setPassword(rs.getString(5));
		}
		return emp;
	}
	
	
	public int updateEmployee(Employee e) throws SQLException
	{
		Connection con =getConnection();
		PreparedStatement pst=con.prepareStatement("update new_table set name=?,email=?,contact=?,password=? where id=?");
		pst.setInt(5, e.getId());
		pst.setString(1, e.getName());
		pst.setString(2, e.getEmail());
		pst.setLong(3, e.getContact());
		pst.setString(4, e.getPassword());
		
		return pst.executeUpdate();
	}
	
	public int deleteemployee(int id) throws SQLException
	{
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("delete from new_table where id=?");
		pst.setInt(1, id);
		return pst.executeUpdate();
	}
	
	public List<Employee> getallEmployees() throws SQLException
	{
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("select * from new_table");
		ResultSet rs=pst.executeQuery();
		
		List<Employee> e=new ArrayList();
		while(rs.next())
		{
			Employee e1=new Employee();
			e1.setId(rs.getInt(1));
			e1.setName(rs.getString(2));
			e1.setEmail(rs.getString(3));
			e1.setContact(rs.getLong(4));
			e1.setPassword(rs.getString(5));
			e.add(e1);
		}
		return e;
	}
	
	
}



