package newproject.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import newproject.dao.EmployeeDao;
import newproject.dto.Employee;

@WebServlet("/login")
public class Login extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		
		EmployeeDao dao=new EmployeeDao();
		try {
			Employee e=dao.findbyemail(email);
			if(e.getPassword().equals(password))
					{
				HttpSession session=req.getSession();
				session.setAttribute("email", email);
				session.setAttribute("password", password);

				List<Employee>employees=dao.getallEmployees();
				req.setAttribute("employees", employees);
				RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
				dispatcher.include(req, resp);
					}
			else {
				req.setAttribute("message", "* * * password is wrong enter correct password * * *");
				RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
				dispatcher.include(req, resp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
