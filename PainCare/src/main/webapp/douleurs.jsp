<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="com.JAVA.Bean.UserBean" %>
<%@ page import="com.JAVA.Bean.DouleurBean" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Liste des Douleurs</title>
</head>
<body>

   
   <c:forEach var="douleur" items="${douleurs}">
    ${douleur.id}
    <p>${douleur.degre}</p>
    <p>${douleur.localisation}</p>
        <p>${douleur.date}</p>
    

</c:forEach>

</body>
</html>
