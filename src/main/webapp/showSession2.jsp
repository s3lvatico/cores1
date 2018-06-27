<%@ page import="org.gmnz.web.beans.AccessInfo" %>
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
    AccessInfo accessInfo = (AccessInfo) session.getAttribute("accessInfo");
    if (accessInfo == null) {
        heading = "Welcome, newcomer!";
        accessInfo = new AccessInfo();
    } else {
        heading = "Welcome back!";
        accessInfo.updateAccessCount();
    }

    session.setAttribute("accessInfo", accessInfo);
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
        <td><%= accessInfo.getSessionCreationDate() %>
        </td>
    </tr>
    <tr>
        <td>Last access</td>
        <td><%= new Date(session.getLastAccessedTime()) %>
        </td>
    </tr>
    <tr>
        <td>Number of accesses</td>
        <td><%= accessInfo.getAccessCount() %>
        </td>
    </tr>
    </tbody>
</table>
<% String contextName = application.getServletContextName();
    System.out.printf("nome contesto [%s]%n", contextName);
%>
<a href="<%= contextName %>/logout"> Clear session data</a>
</body>
</html>
