<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: darian
  Date: 26.05.19.
  Time: 18:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sustav za upravljanje turističkim smještajem</title>
</head>
<body>
<h1>Pregled pružatelja po šiframa</h1>
<ul>
    <jsp:useBean id="lista" scope="request" type="java.util.List"/>
    <c:forEach var="p" items="${lista}">
        <li><a href="${pageContext.request.contextPath}/home/<c:out value="${p.oib}"/>"><c:out value="${p.oib}"/></a>
        </li>
    </c:forEach>
</ul>
</body>
</html>
