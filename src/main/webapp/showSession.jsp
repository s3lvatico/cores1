<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: simone
  Date: 26/06/2018
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String heading;
    Integer accessCount = (Integer) session.getAttribute("accessCount");
    if (accessCount == null) {
        heading = "Welcome, newcomer!";
        accessCount = new Integer(1);
    } else {
        heading = "Welcome back!";
        accessCount = new Integer(accessCount.intValue() + 1);
    }

    session.setAttribute("accessCount", accessCount);
%>
<html>
<head>
    <title>showSession</title>

    <link rel="stylesheet" href="css/showSession.css">
</head>
<body>
<h1><%= heading %>
</h1>
<h2>Information on your session</h2>
<table>
    <thead>
    <tr class="tableHeader">
        <th>Info type</th>
        <th>Value</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>ID</td>
        <td><%= session.getId() %>
        </td>
    </tr>
    <tr>
        <td>Creation time</td>
        <td><%= new Date(session.getCreationTime()) %>
        </td>
    </tr>
    <tr>
        <td>Last access</td>
        <td><%= new Date(session.getLastAccessedTime()) %>
        </td>
    </tr>
    <tr>
        <td>Number of accesses</td>
        <td><%= accessCount %>
        </td>
    </tr>
    </tbody>
</table>
</body>
</html>
