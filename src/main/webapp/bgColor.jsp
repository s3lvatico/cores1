<%--
  Created by IntelliJ IDEA.
  User: simone
  Date: 26/06/2018
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="css/index.css">
    <title>background color</title>
</head>
<%
    String bgColor = request.getParameter("bg");
%>
<body style="background-color: #<%= bgColor %>">
<h2>Selezione del colore di sfondo</h2>
<p>Selezionato: <%=bgColor%></p>
</body>
</html>
