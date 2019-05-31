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
<input id="pruzatelj-oib" type="hidden" value="${pruzatelj.oib}">
<table>
    <tr>
        <th>OIB</th>
        <th>Adresa</th>
    </tr>
    <tr>
        <td>${pruzatelj.oib}</td>
        <td><input id="pruzatelj-adresa" type="text" name="adresa" value="${pruzatelj.adresa}"></td>
        <td>
            <button onclick="azurirajPruzatelja('${pruzatelj.oib}')">Ažuriraj</button>
        </td>
    </tr>
    <%--    <input id="pruzatelj-oib" type="hidden" name="oib" value="${pruzatelj.oib}">--%>
    <%--    <label for="pruzatelj-adresa">Adresa</label>--%>
    <%--    <input id="pruzatelj-adresa" type="text" name="adresa" value="${pruzatelj.adresa}">--%>
</table>
<jsp:useBean id="fosoba" scope="request" type="java.lang.Boolean"/>
<c:choose>
    <c:when test="${fosoba}">
        <div id="fosoba-${pruzatelj.oib}"></div>
        <jsp:useBean id="osoba" scope="request" type="model.repository.FizickaOsoba"/>
        <table>
            <tr>
                <th>Ime</th>
                <th>Prezime</th>
                <th>Datum rođenja</th>
            </tr>
            <tr>
                <td><input id="fosoba-${pruzatelj.oib}-ime" type="text"
                           value="${osoba.ime}"></td>
                    <%--                <label for="fosoba-${pruzatelj.oib}-ime">Ime</label>--%>

                <td><input id="fosoba-${pruzatelj.oib}-prezime" type="text"
                           value="${osoba.prezime}"></td>
                    <%--                <label for="fosoba-${pruzatelj.oib}-prezime">Prezime</label>--%>
                <td><input id="fosoba-${pruzatelj.oib}-datumRodjenja" type="date"
                           value="${osoba.datumRodjenja}"></td>
                    <%--                <label for="fosoba-${pruzatelj.oib}-datumRodjenja">Datum rođenja</label>--%>
                <td>
                    <button onclick="azurirajFizickuOsobu('${pruzatelj.oib}')">Ažuriraj</button>
                </td>
            </tr>
        </table>

    </c:when>
    <c:otherwise>
        <div id="posoba-${pruzatelj.oib}"></div>
        <jsp:useBean id="posoba" scope="request" type="model.repository.PravnaOsoba"/>
        <table>
            <tr>
                <th>Naziv</th>
                <th>Početni kapital</th>
                <th>Datum osnivanja</th>
            </tr>
            <tr>
                <td><input id="posoba-${pruzatelj.oib}-naziv" type="text" value="${posoba.naziv}"></td>
                <td><input id="posoba-${pruzatelj.oib}-pocetniKapital" type="number" value="${posoba.pocetniKapital}">
                </td>
                <td><input id="posoba-${pruzatelj.oib}-datumOsnivanja" type="date" value="${posoba.datumOsnivanja}">
                </td>
                <td>
                    <button onclick="azurirajPravnuOsobu('${pruzatelj.oib}')">Ažuriraj</button>
                </td>
            </tr>
        </table>
        <%--        <form>--%>
        <%--            --%>
        <%--            --%>
        <%--            <label for="posoba-${pruzatelj.oib}-naziv">Naziv</label>--%>

        <%--            --%>
        <%--            <label for="posoba-${pruzatelj.oib}-pocetniKapital">Početni kapital</label>--%>
        <%--            --%>
        <%--            <label for="posoba-${pruzatelj.oib}-datumOsnivanja">Datum osnivanja</label>--%>
        <%--        </form>--%>

    </c:otherwise>
</c:choose>

<div id="objekti-${pruzatelj.oib}">
    <table id="objekti-${pruzatelj.oib}">
        <tr>
            <th>Naziv objekta</th>
            <th>Vrsta objekta</th>
        </tr>
        &nbsp
    </table>

</div>

<p>Natrag na <a href="${pageContext.request.contextPath}/home">početnu</a>...</p>
</body>
</html>
