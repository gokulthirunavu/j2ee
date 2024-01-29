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

@WebServlet("/signup")
public class Signup extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		long contact=Long.parseLong(req.getParameter("contact"));
		String password=req.getParameter("password");
		String confirmpassword=req.getParameter("confirmpassword");
		
		Employee e=new Employee();
		e.setId(id);
		e.setName(name);
		e.setEmail(email);
		e.setContact(contact);
		e.setPassword(password);
		e.setConfirmpassword(confirmpassword);
		
		
		if(e.getPassword().equals(confirmpassword))
		{
			EmployeeDao dao=new EmployeeDao();
			try {
				int res= dao.saveEmployee(e);
				if(res>0)
				{
					RequestDispatcher dispatcher=req.getRequestDispatcher("index.jsp");
					dispatcher.include(req, resp);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else
		{
			req.setAttribute("message", "* * * password and confirmpassword is mismatch enter correctly* * *");
			RequestDispatcher dispatcher=req.getRequestDispatcher("signup.jsp");
			dispatcher.include(req, resp);
		}
		
		
	}

}
