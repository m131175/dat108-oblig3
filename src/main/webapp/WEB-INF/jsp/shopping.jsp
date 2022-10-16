<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <title>Shopping</title>
</head>
<body>
    <h3>My Shopping List</h3>

    <form action="shopping" method="post">
        <table>
            <tr>
                <input type="submit" value="Add" style="margin-right: 10px; padding: 0px 15px">
                <input type="text" name="shoppingItem">
            </tr>
        </table>
    </form>

    <table>
        <c:forEach items="${shoppingitems}" var="shoppingitem">
            <tr>
                <td>${shoppingitem}</td>
                <td><a href="delete-shoppingitem?id=${shoppingitem.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>

</body>
</html>