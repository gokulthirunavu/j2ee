<%@page import="newproject.dto.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
#same1:hover{
background-color: orange;
color: red;
border-size:xx-large;}
#same2:hover{
background-color: orange;
color: red;
border-size:xx-large;}
#same3:hover{
background-color: orange;
color: red;
border-size:xx-large;}
#same4:hover{
background-color: orange;
color: red;
border-size:xx-large;}
#same5:hover{
background-color: orange;
color: red;
border-size:xx-large;}
#same6:hover{
background-color: green;
color: red;
border-size:xx-large;}
</style>
</head>
<body>
<% Employee e=(Employee) request.getAttribute("emp"); %>
<form action="update">
<table>
<tr> <td> <label for="same1">Id:</label> </td><td><input id="same1" type="text" value="<%=e.getId() %>" name="id" readonly="true"></td> </tr>
<tr> <td><label for="same2">Name:</label></td><td><input id="same2" type="text" value="<%=e.getName() %>" name="name"></td> </tr>
<tr> <td><label for="same3">Email:</label></td><td><input id="same3" type="text" value="<%=e.getEmail() %>" name="email"></td> </tr>
<tr> <td><label for="same4">Contact:</label></td><td><input id="same4" type="text" value="<%=e.getContact() %>" name="contact"></td> </tr>
<tr> <td><label for="same5">Password:</label></td><td><input id="same5" type="text" value="<%=e.getPassword() %>" name="password"></td> </tr>
<tr> <td><label for="same6">Submit:</label></td><td><input id="same6" type="submit"></td> </tr>
</table>
</form>
</body>
</html>