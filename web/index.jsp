<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Poems</title>
</head>
<body>
<h2>Poem List</h2>
<p><a href='<c:url value="/create" />'>New poem</a></p>

<form method="post">
  <label>Name</label><br>
  <input name="nameAuthor"/><br><br>
  <input type="submit" value="Search" />
</form>
<br>
  
<table>
  <tr>Select Poem</tr>
  <tr><th>Name</th><th>Year</th><th>Poem</th></tr>
  <c:forEach var="find" items="${search}">
    <tr><td>${find.name}</td>
      <td>${find.year}</td>
      <td>${find.text}</td>
      <td>
        <a href='<c:url value="/edit?id=${find.id}" />'>Edit</a> |
        <form method="post" action='<c:url value="/delete" />' style="display:inline;">
          <input type="hidden" name="id" value="${find.id}">
          <input type="submit" value="Delete">
        </form>
      </td></tr>
  </c:forEach>
</table>

</body>
</html>
