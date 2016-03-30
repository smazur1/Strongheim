<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Aggregate Grades</title>
</head>
<body>
<h2>Aggregate Grades</h2>
<br/>
<c:choose>
    <c:when test="${version.equals('1')}">
       The average for student: <c:out value="${studentid}"/> is : <c:out value="${average}"/>
    </c:when>
    <c:when test="${version.equals('2')}">
       The average for student: <c:out value="${studentid}"/>  , and type: <c:out value="${type}"/>
       , is : <c:out value="${average}"/>
    </c:when>
    <c:when test="${version.equals('3')}">
    For assignment type: <c:out value="${type}"/> , the maximum grade is: <c:out value="${max}"/>
     , the minimum grade is: <c:out value="${min}"/>
    </c:when>
    <c:otherwise>
    </c:otherwise>
</c:choose>








</body>
</html>