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
    <title>
        <jsp:useBean id="pruzatelj" scope="request" type="model.repository.PruzateljUsluga"/>
        <c:out value="${pruzatelj.oib}"/></title>
    <%--        <script src="scripts/htmlescaping.js"></script>--%>
    <script>
        function htmlEscape(str) {
            return String(str)
                .replace(/&/g, '&amp;')
                .replace(/"/g, '&quot;')
                .replace(/'/g, '&#39;')
                .replace(/</g, '&lt;')
                .replace(/>/g, '&gt;');
        }

        function azurirajPruzatelja(oib) {
            let json = {
                "oib": oib,
                "adresa": $("#pruzatelj-adresa").val()
            };
            $.ajax(
                {
                    url: "rest/pruzatelj/" + oib,
                    type: 'POST',
                    contentType: "application/json",
                    data: JSON.stringify(json),
                    success: function (data, textStatus, xhr) {
                        alert(xhr.status);

                    },
                    error: function (status) {
                        alert('Neuspješno ažuriran');
                    }
                }
            )
        }
    </script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <%--    <script src="/scripts/script.js"></script>--%>
</head>
<body>
<form id="pruzatelj-<c:out value="${pruzatelj.adresa}"/>">
    <input type="hidden" name="oib" value="<c:out value="${pruzatelj.oib}"/>">
    <input id="pruzatelj-adresa" type="text" name="adresa" value="<c:out value="${pruzatelj.adresa}"/>">
    <label for="pruzatelj-adresa">Adresa</label>
</form>
<button onclick="azurirajPruzatelja('<c:out value="${pruzatelj.oib}"/>')">Ažuriraj</button>
<jsp:useBean id="fosoba" scope="request" type="java.lang.Boolean"/>
<c:choose>
<c:when test="${fosoba}">
    <div id="fosoba-${pruzatelj.oib}"></div>
    <form onsubmit="dohvatiFizickuOsobu(<c:out value="${pruzatelj.oib}"/>)">
        <input id="fosoba-<c:out value="${pruzatelj.oib}-ime"/>" type="text"
               value="<jsp:useBean id="osoba" scope="request" type="model.repository.FizickaOsoba"/>
        <c:out value="${osoba.ime}"/>">
        <label for="fosoba-<c:out value="${pruzatelj.oib}-ime"/>">Ime</label>

        <input id="fosoba-<c:out value="${pruzatelj.oib}-prezime"/>" type="text"
               value="<c:out value="${osoba.prezime}"/>">
        <label for="fosoba-<c:out value="${pruzatelj.oib}-prezime"/>">Prezime</label>
            <%--todo:datum rođenja--%>
    </form>
</c:when>
<c:otherwise>
<div id="posoba-${pruzatelj.oib}"></div>
<form onsubmit="dohvatiPravnuOsobu(<c:out value="${pruzatelj.oib}"/>)"> <%--todo:azuriranje osoba--%>
    <input id="posoba-<c:out value="${pruzatelj.oib}-naziv"/>" type="text"
           value="<jsp:useBean id="posoba" scope="request" type="model.repository.PravnaOsoba"/>
        <c:out value="${posoba.naziv}"/>">
    <label for="posoba-<c:out value="${pruzatelj.oib}-naziv"/>">Naziv</label>

    <input id="posoba-<c:out value="${pruzatelj.oib}-pocetniKapital"/>" type="number"
        <%--           value="<jsp:useBean id="osoba" scope="request" type="model.repository.PravnaOsoba"/>--%>
        <c:out value="${posoba.pocetniKapital}"/>">
    <label for="posoba-<c:out value="${pruzatelj.oib}-pocetniKapital"/>">Početni kapital</label>
    </c:otherwise>
    </c:choose>
</body>
</html>
