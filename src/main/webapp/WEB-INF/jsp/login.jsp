<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head><title>Login</title></head>
<body>
    <p>${empty redirectMessage ? "Type your password:" : redirectMessage}</p>

    <form action="login" method="post">
        <input type="password" name="password" placeholder="Password.."/><br><br>
        <input type="submit" value="Sign in">
    </form>
</body>
</html>