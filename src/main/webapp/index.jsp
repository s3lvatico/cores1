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
    <title>titolo jsp</title>
</head>
<body>
<table>
    <tr>
        <td>A seguire, la data di oggi: <%= new java.util.Date() %>
        </td>
        <td><h3>informazioni ottenute dagli oggetti impliciti</h3>
            <p>
            <ul>
                <li>Request Url : <%= request.getRequestURL()%>
                </li>
                <li>Query String : <%= request.getQueryString()%>
                </li>
                <li>Response headers: <%= response.getHeaderNames()%>
                </li>
                <li>Response status: <%= response.getStatus()%>
                </li>
                <li>Response Character Encoding: <%= response.getCharacterEncoding()%>
                </li>
                <li>
                    Nuova sessione? : <%= session.isNew()%>
                </li>
                <li>
                    Data creazione sessione: <%= session.getCreationTime() %>
                </li>
                <li>
                    Attributi sessione: <%= session.getAttributeNames() %>
                </li>
                <li>
                    Servlet context information: <%= application.getServerInfo()%>
                </li>
            </ul>
            </p>
        </td>
    </tr>
    <tr>
        <td><h3>Altre robe</h3>
            <p>
                Tipo un numero casuale: <%= Math.random()%>
            </p>
        </td>
        <td>
            <%-- qui sotto c'è un esempio di scriptlet --%>
            <%-- scriptlet == FRAMMENTO di codice java --%>
            <%
                String queryData = request.getQueryString();
                out.println("attached query: " + queryData);
            %>
        </td>
    </tr>
</table>
</body>
</html>
