<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style >
#same1:hover{
background-color: pink;
color: red;
border-size:xx-large;}
#same2:hover{
background-color: pink;
color: red;
border-size:xx-large;}
#same3:hover{
background-color: green;
color: red;
border-size:xx-large;}
</style>
</head>
<body>

<% String message =(String) request.getAttribute("message"); %>
<% if(message!=null) { %>
<h1><%= message %></h1>
<%} %>

<form action="login">
<table>
 <tr> <td> <label for="same1">Email:</label></td> <td><input id="same1" type="text" name="email" placeholder="enter your email" required="required" ></td> </tr> 
 <tr> <td> <label for="same2">Password:</label></td> <td><input id="same2" type="text" name="password" placeholder="enter your password" required="required"></td> </tr>
 <tr> <td> <label for="same3">Submit:</label> </td> <td><input id="same3" type="submit"></td> </tr>
 </table>

</form>

</body>
</html>