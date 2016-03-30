<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>


<style>
table, th, td {
    border: 1px solid black;
    border-collapse: collapse;
}
th, td {
    padding: 15px;
}
th {
    text-align: left;
}
</style>
</head>
<body>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <table style="width:100%">
  <tr>
    <th>Student ID</th>
    <th>Assignment</th>
    <th>Type</th>
    <th>Date</th>
    <th>Grade</th>
    </tr>
    
    	
  
    	
    <c:forEach var="item" items="${assignments}" >
    <tr>      
    <td><c:out value="${item.studentid }"/></td>
    <td><c:out value="${item.assignment }"/></td>
    <td><c:out value="${item.type }"/></td>
    <td><c:out value="${item.assigndate }"/></td>
    <td><c:out value="${item.grade }"/></td>
   
    </tr>
</c:forEach>	
    
    
    
    </table> 
   
   
 


</body>
</html>