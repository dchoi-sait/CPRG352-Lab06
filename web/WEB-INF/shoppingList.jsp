<%-- 
    Document   : shoppingList
    Created on : Oct 19, 2021, 10:27:24 PM
    Author     : 775262
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <div>Hello, ${username} <a href='<c:url value="ShoppingList?action=logout"/>'>Logout</a></div>
        <h2>List</h2>
        <form method="POST" action="ShoppingList">
            <label>Add item:</label>
            <input type="text" name="item" value="">
            <input type="submit" value="Add">
            <input type="hidden" name="action" value="add">
        </form>

        <form method="POST" action="ShoppingList">
            <c:forEach var="el" items="${items}" varStatus="loop">
                <input id="${loop.getIndex()}" type="radio" name="itemEl" value="${el}"><label for="${loop.getIndex()}">${el}</label>
                <br/>
            </c:forEach>
            <input type="submit" value="Delete">
            <input type="hidden" name="action" value="delete">
        </form>
    </body>
</html>
