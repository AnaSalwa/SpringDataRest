<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
</head>
<body>


   <%@ page import=" com.JAVA.Bean.UserBean" %>

					
                      

<%
    // Récupérer l'utilisateur depuis la session
    UserBean user = (UserBean) request.getSession().getAttribute("User");

    // Vérifier si l'utilisateur est connecté
    if (user != null) {
%>
        <h1>Bienvenue <%= user.getPrenom() %> <%= user.getNom() %> sur le tableau de bord</h1>
        <p>Votre ID: <%= user.getId() %></p>
        <p>Votre Email: <%= user.getEmail() %></p>
        <!-- Ajoutez d'autres informations selon vos besoins -->
<%
    } else {
        // Rediriger vers la page d'erreur si l'utilisateur n'est pas connecté
        response.sendRedirect("error.jsp");
    }
%>

</body>
</html>
