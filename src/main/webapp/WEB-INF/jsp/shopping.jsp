<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
    <title>Shopping</title>
    <style>
        td {padding: 10px 10px 3px 0px;}
    </style>
</head>
<body>
    <h3>My Shopping List</h3>

    <form action="shopping" method="post">
        <table>
            <tr>
                <input type="submit" value="Add" style="margin-right: 10px; padding: 0px 15px">
                <input type="text" name="name" minlength="2" required>
            </tr>
        </table>
    </form>

    <table>
        <c:forEach items="${shoppingitems}" var="shoppingitem">
            <tr>
                <td>
                    <a href="/delete-shoppingitem?id=${shoppingitem.id}"><input type="submit" value="Delete"/></a>
                </td>
                <td><c:out escapeXml="true" value="${shoppingitem.name}"/></td>
            </tr>sh
        </c:forEach>
    </table>

</body>
</html>