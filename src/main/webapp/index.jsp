<%--
  Created by IntelliJ IDEA.
  User: darian
  Date: 24.05.19.
  Time: 08:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <jsp:useBean id="pruzatelj" scope="request" type="model.repository.PruzateljUsluga"/>
    <title>${pruzatelj.oib}</title>
    <script src="${pageContext.request.contextPath}/scripts/htmlescaping.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/scripts/script.js"></script>
</head>
<body>
<form>
    <input id="pruzatelj-oib" type="hidden" name="oib" value="${pruzatelj.oib}">
    <label for="pruzatelj-adresa">Adresa</label>
    <input id="pruzatelj-adresa" type="text" name="adresa" value="${pruzatelj.adresa}">
</form>
<button onclick="azurirajPruzatelja('${pruzatelj.oib}')">Ažuriraj</button>
<jsp:useBean id="fosoba" scope="request" type="java.lang.Boolean"/>
<c:choose>
    <c:when test="${fosoba}">
        <div id="fosoba-${pruzatelj.oib}"></div>
        <form>
            <jsp:useBean id="osoba" scope="request" type="model.repository.FizickaOsoba"/>
            <input id="fosoba-${pruzatelj.oib}-ime" type="text"
                   value="${osoba.ime}">
            <label for="fosoba-${pruzatelj.oib}-ime">Ime</label>

            <input id="fosoba-${pruzatelj.oib}-prezime" type="text"
                   value="${osoba.prezime}">
            <label for="fosoba-${pruzatelj.oib}-prezime">Prezime</label>
            <input id="fosoba-${pruzatelj.oib}-datumRodjenja" type="date"
                   value="${osoba.datumRodjenja}">
            <label for="fosoba-${pruzatelj.oib}-datumRodjenja">Datum rođenja</label>
        </form>
        <button onclick="azurirajFizickuOsobu('${pruzatelj.oib}')">Ažuriraj</button>
    </c:when>
    <c:otherwise>
        <div id="posoba-${pruzatelj.oib}"></div>
        <form>
            <jsp:useBean id="posoba" scope="request" type="model.repository.PravnaOsoba"/>
            <input id="posoba-${pruzatelj.oib}-naziv" type="text"
                   value="${posoba.naziv}">
            <label for="posoba-${pruzatelj.oib}-naziv">Naziv</label>

            <input id="posoba-${pruzatelj.oib}-pocetniKapital" type="number"
                   value="${posoba.pocetniKapital}">
            <label for="posoba-${pruzatelj.oib}-pocetniKapital">Početni kapital</label>
            <input id="posoba-${pruzatelj.oib}-datumOsnivanja" type="date"
                   value="${posoba.datumOsnivanja}">
            <label for="posoba-${pruzatelj.oib}-datumOsnivanja">Datum osnivanja</label>
        </form>
        <button onclick="azurirajPravnuOsobu('${pruzatelj.oib}')">Ažuriraj</button>
    </c:otherwise>
</c:choose>

<div id="objekti-${pruzatelj.oib}">
    &nbsp
</div>
<form>
    <input type="hidden" name="oib" value="${pruzatelj.oib}">
    <label for="novi-objekt-naziv">Naziv</label>
    <input id="novi-objekt-naziv" placeholder="naziv" type="text">
    <div id="novi-objekt-vrsta-div">
        &nbsp;
    </div>
</form>
<button onclick="dodajObjekt('${pruzatelj.oib}')">Dodaj novi objekt</button>

<p>Natrag na <a href="${pageContext.request.contextPath}/home">početnu</a>...</p>
</body>
</html>
