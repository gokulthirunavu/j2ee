<%@page import="newproject.dto.Employee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
<style>
th{
border-color: red;
color:yellow;
background-color: orange;}
td{
border-color: blue;
color:green;
background-color: skyblue;}
th,td,table{border-collapse: collapse;}</style>

</head>
<body>
<% List<Employee> employees =(List)request.getAttribute("employees"); %>
<table border="2px" solid black>
<tr>
<th>id</th>
<th>name</th>
<th>email</th>
<th>contact</th>
<th>password</th>
<th>edit</th>
<th>delete</th>
</tr>
<% for(Employee e:employees) { %>
<tr>
<td><%= e.getId() %></td>
<td><%= e.getName() %></td>
<td><%= e.getEmail() %></td>
<td><%= e.getContact() %></td>
<td><%= e.getPassword() %></td>
<td><a href="edit?id=<%= e.getId() %>">edit</a></td>
<td><a href="delete?id=<%= e.getId() %>">delete</a></td>

</tr>
<%} %>
</table>

<a href="signup.jsp">add</a>
<a href="signout">signout</a>
</body>
</html>