<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
    <h1>Error</h1>
    <p>${error}</p>
    <%-- Ajoutez cette section pour afficher l'exception --%>
    <% if (pageContext.getAttribute("javax.servlet.error.exception") != null) { %>
        <pre><%= pageContext.getAttribute("javax.servlet.error.exception").toString() %></pre>
    <% } %>
</body>
</html>
