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
background-color: orange;
color: red;
border-size:xx-large;}
#same7:hover{
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
<form action="signup">
<table> 
<tr><td><label for="same1">Id:</label></td> <td><input id="same1" type="text" name="id" placeholder="enter your id" required="required"></td> </tr>
<tr><td><label for="same2">Name:</label></td> <td><input id="same2" type="text" name="name" placeholder="enter your name" required="required"></td> </tr>
<tr><td><label for="same3">Email:</label></td> <td><input id="same3" type="text" name="email" placeholder="enter your email" required="required"></td> </tr>
<tr><td><label for="same4">Contact:</label></td> <td><input id="same4" type="text" name="contact" placeholder="enter your contact" required="required"></td> </tr>
<tr><td><label for="same5">Password:</label></td> <td><input id="same5" type="text" name="password" placeholder="enter your password" required="required"></td> </tr>
<tr><td><label for="same6">Confirmpassword:</label></td> <td><input id="same6" type="text" name="confirmpassword" placeholder="enter your Confirmpassword" required="required"></td> </tr>
<tr> <td> <label for="same7">Submit:</label> </td> <td><input id="same7" type="submit"></td> </tr>
</table>

</form>

</body>
</html>