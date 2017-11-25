<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.telusko.User,java.util.ArrayList,java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<b><u>Search Result</u></b><br><br>

<%
	List<User> usersList = (List<User>) request.getAttribute("users");
if(usersList.size()>0){
	%>
	<table border="1">
	<tr>
		<th>User Id</th>
		<th>Name</th>
		<th>Age</th>		
	</tr>
	<%	
	for(User u: usersList){
		
		%>
		<tr>
			<td><%out.print(u.getUid());%></td>
			<td><%out.print(u.getUname());%></td>
			<td><%out.print(u.getAge());%></td>		
		</tr>
		<%
	}
	%> 
	</table>
	<%
} else {
	out.println("No match found, please try again");
}	
%>

</body>
</html>