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

@WebServlet("/delete")
public class Delete extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session=req.getSession();
		String email=(String) session.getAttribute("email");
		String password=(String) session.getAttribute("password");
		
		int id=Integer.parseInt(req.getParameter("id"));
		EmployeeDao dao=new EmployeeDao();
		
		try {
			 
			if(email != null && password != null)
			{
				dao.deleteemployee(id);
				List<Employee>employees=dao.getallEmployees();
				req.setAttribute("employees", employees);
				RequestDispatcher dispatcher=req.getRequestDispatcher("display.jsp");
				dispatcher.include(req, resp);
				
			}
			else {
				req.setAttribute("message", "please login first");
				RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
				dispatcher.include(req, resp);
				
				
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
