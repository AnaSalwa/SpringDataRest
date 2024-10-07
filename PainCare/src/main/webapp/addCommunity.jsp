<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter une Communauté</title>
</head>
<body>

    <h2>Ajouter une Communauté</h2>

    <form method="post" action="servlet" enctype="multipart/form-data">
        <label for="title">Titre :</label>
        <input type="text" id="title" name="title" required><br>

        <label for="description">Description :</label>
        <textarea id="description" name="description" required></textarea><br>

        <label for="image">Image :</label>
        <input type="file" name="image" />


        

        <input type="hidden" name="action" value="insert">

        <input type="submit" value="Ajouter">
    </form>

    <br>
    <a href="servle?action=list">Retour à la liste des communautés</a>

</body>
</html>
