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
    <title>Edit poem</title>
</head>
<body>
<h3>Edit poem</h3>
<form method="post">
    <input type="hidden" value="${find.id}" name="id" />
    <label>Year</label><br>
    <input name="year" value="${find.year}" type="number" min="100" /><br><br>
    <label>Text</label><br>
    <textarea rows="10" cols="45" name="text" value="${find.text}"></textarea><br><br>
    <input type="submit" value="Send" />
</form>
</body>
</html>
