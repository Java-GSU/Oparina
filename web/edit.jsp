<%--
  Created by IntelliJ IDEA.
  User: Alena Oparina
  Date: 04.12.2020
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit product</title>
</head>
<body>
<h3>Edit product</h3>
<form method="post">
    <input type="hidden" value="${product.id}" name="id" />
    <label>Name</label><br>
    <input name="name" value="${product.name}" /><br><br>
    <label>Year</label><br>
    <input name="year" value="${product.year}" type="number" min="100" /><br><br>
    <label>Text</label><br>
    <input name="text" value="${product.text}" /><br><br>
    <input type="submit" value="Send" />
</form>
</body>
</html>