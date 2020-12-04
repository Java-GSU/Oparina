<%--
  Created by IntelliJ IDEA.
  User: Alena Oparina
  Date: 04.12.2020
  Time: 21:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create product</title>
</head>
<body>
<h3>New product</h3>
<form method="post">
    <label>Name</label><br>
    <input name="name"/><br><br>
    <label>Year</label><br>
    <input name="year" type="number" min="100" /><br><br>
    <label>Text</label><br>
    <input name="text"/><br><br>
    <input type="submit" value="Save" />
</form>
</body>
</html>
