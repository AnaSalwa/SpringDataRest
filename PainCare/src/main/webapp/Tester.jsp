<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.JAVA.Bean.UserBean" %>
<%@ page import="com.JAVA.Bean.PhotoBean" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Base64" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%-- Obtenez l'utilisateur depuis la session --%>
<% UserBean user = (UserBean) request.getSession().getAttribute("User"); %>

<%-- Obtenez la liste des photos depuis la requête --%>
<c:forEach items="${photos}" var="photo" varStatus="loopStatus">
    <%-- Affichez l'image uniquement lors de la dernière itération --%>
    <c:if test="${loopStatus.last}">
        <c:if test="${not empty photo and not empty photo.photoBase64}">
            <img class="card-img" src="data:image/jpeg;base64, ${photo.photoBase64}" alt="Card image" width="80" height="300" />
        </c:if>
    </c:if>
</c:forEach>
