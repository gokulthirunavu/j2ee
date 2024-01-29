package newproject.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import newproject.dao.EmployeeDao;
import newproject.dto.Employee;

@WebServlet("/update")
public class Update extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		long contact=Long.parseLong(req.getParameter("contact"));
		String password=req.getParameter("password");
		
		Employee e=new Employee();
		e.setId(id);
		e.setName(name);
		e.setEmail(email);
		e.setContact(contact);
		e.setPassword(password);
		
		EmployeeDao dao=new EmployeeDao();
		
		try {
			if(email!=null&&password!=null)
			{
				dao.updateEmployee(e);
				req.setAttribute("employees", dao.getallEmployees());
				RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
				dispatcher.include(req, resp);
			}
			else
			{
				req.setAttribute("message", "please login first");
				RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
				dispatcher.include(req, resp);
			}
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
