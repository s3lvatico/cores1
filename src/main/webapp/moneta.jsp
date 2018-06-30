<%--
  Created by IntelliJ IDEA.
  User: simone
  Date: 26/06/2018
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="css/moneta.css">
    <title>testa o croce</title>
</head>
<body>
<h2>Lancio della moneta</h2>
<h3>Risultato</h3>
<%
    if (Math.random() < .5) {
%>
<p class="testa">è uscito TESTA</p>
<%
    }
    else
    {
%>
<p class="croce">hai fatto CROCE</p>
<%
    }
%>
</body>
</html>
