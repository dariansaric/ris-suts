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
        <li><a href="${pageContext.request.contextPath}/home/${p.oib}">${p.oib}</a>
        </li>
    </c:forEach>
</ul>

<h1>Dodaj novog pružatelja</h1>
<form>
    <input id="novi-pruzatelj-oib" type="text" name="oib" placeholder="OIB pružatelja">
    <label for="novi-pruzatelj-oib">OIB</label>
    <input id="novi-pruzatelja-adresa" type="text" name="adresa" placeholder="adresa...">
    <label for="novi-pruzatelja-adresa">Adresa</label>
    <input type="radio" name="osoba" value="f" onclick="otvoriFormuFizickaOsoba()">Fizička osoba
    <input type="radio" name="osoba" value="p" onclick="otvoriFormuPravnaOsoba()">Pravna osoba
    <div id="novi-pruzatelja-osoba">
        &nbsp
    </div>
</form>
<button onclick="dodajPruzatelja()">Dodaj Pružatelja</button>
</body>
</html>
