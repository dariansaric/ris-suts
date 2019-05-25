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
    <title><c:out value="${pruzatelj.oib}"/></title>
    <script src="scripts/htmlescaping.js"></script>
    <%--        <script>--%>
    <%--            $().ready(--%>
    <%--                function () {--%>
    <%--                    let oib = $("#pruzatelj-oib").val();--%>
    <%--                    $.ajax({--%>
    <%--                        url: "rest/objekt/" + oib,--%>
    <%--                        type: 'GET',--%>
    <%--                        data: {},--%>
    <%--                        dataType: "json",--%>
    <%--                        success: function (data) {--%>
    <%--                            let objekti = data;--%>
    <%--                            let html = "<ul>";--%>
    <%--                            for (let i = 0; i < objekti.length; i++) {--%>
    <%--                                let o = data[i];--%>
    <%--                                html += "<form>";--%>
    <%--                                html += "<input id='objekt-" + o.sifraObjekt + "' type='hidden' name='sifraObjekt' " +--%>
    <%--                                    "value='" + o.sifraObjekt + "'/>";--%>
    <%--                                html += "<input id='objekt-" + o.oib + "-oib' type='hidden' name='oib' " +--%>
    <%--                                    "value='" + o.oib + "'/>";--%>
    <%--                                html += "<input id='objekt-" + o.sifraObjekt + "-naziv' type='text' value='" + o.naziv + "'/>" +--%>
    <%--                                    "<label for='objekt-" + o.sifraObjekt + "-naziv'>Naziv</label>";--%>
    <%--                                html += "</form>";--%>
    <%--                                html += "<button onclick='azurirajObjekt(\'" + o.sifraObjekt + "\')'>Ažuriraj</button>";--%>
    <%--                                //todo: html += "<button >Izbriši</button>";--%>
    <%--                                //todo:vrsta objekta--%>
    <%--                            }--%>

    <%--                            html += "</ul>";--%>
    <%--                            //todo: dodavanje novog objekta--%>
    <%--                            $("#objekti").html(html);--%>
    <%--                        }--%>
    <%--                    });--%>
    <%--                }--%>
    <%--            );--%>

    <%--            function htmlEscape(str) {--%>
    <%--                return String(str)--%>
    <%--                    .replace(/&/g, '&amp;')--%>
    <%--                    .replace(/"/g, '&quot;')--%>
    <%--                    .replace(/'/g, '&#39;')--%>
    <%--                    .replace(/</g, '&lt;')--%>
    <%--                    .replace(/>/g, '&gt;');--%>
    <%--            }--%>

    <%--            function azurirajPruzatelja(oib) {--%>
    <%--                let json = {--%>
    <%--                    "oib": oib,--%>
    <%--                    "adresa": $("#pruzatelj-adresa").val()--%>
    <%--                };--%>
    <%--                $.ajax(--%>
    <%--                    {--%>
    <%--                        url: "rest/pruzatelj/" + oib,--%>
    <%--                        type: 'POST',--%>
    <%--                        contentType: "application/json",--%>
    <%--                        data: JSON.stringify(json),--%>
    <%--                        success: function (data, textStatus, xhr) {--%>
    <%--                            alert(xhr.status);--%>

    <%--                        },--%>
    <%--                        error: function (status) {--%>
    <%--                            alert('Neuspješno ažuriran');--%>
    <%--                        }--%>
    <%--                    }--%>
    <%--                )--%>
    <%--            }--%>

    <%--            function azurirajFizickuOsobu(oib) {--%>
    <%--                let json = {--%>
    <%--                    oib: oib,--%>
    <%--                    ime: $("#fosoba-" + oib + "-ime").val(),--%>
    <%--                    prezime: $("#fosoba-" + oib + "-prezime").val(),--%>
    <%--                    datumRodjenja: $("#fosoba-" + oib + "-datumRodjenja").val()--%>
    <%--                };--%>
    <%--                $.ajax(--%>
    <%--                    {--%>
    <%--                        url: "rest/fosoba/" + oib,--%>
    <%--                        type: 'POST',--%>
    <%--                        contentType: "application/json",--%>
    <%--                        data: JSON.stringify(json),--%>
    <%--                        success: function (data, textStatus, xhr) {--%>
    <%--                            alert(xhr.status);--%>
    <%--                        },--%>
    <%--                        error: function (status) {--%>
    <%--                            alert('Neuspješno ažuriran');--%>
    <%--                        }--%>
    <%--                    }--%>
    <%--                )--%>
    <%--            }--%>

    <%--            function azurirajPravnuOsobu(oib) {--%>
    <%--                let json = {--%>
    <%--                    oib: oib,--%>
    <%--                    naziv: $("#posoba-" + oib + "-naziv").val(),--%>
    <%--                    datumOsnivanja: $("#posoba-" + oib + "-datumOsnivanja").val(),--%>
    <%--                    pocetniKapital: $("#posoba-" + oib + "-pocetniKapital").val()--%>
    <%--                };--%>
    <%--                $.ajax(--%>
    <%--                    {--%>
    <%--                        url: "rest/posoba/" + oib,--%>
    <%--                        type: 'POST',--%>
    <%--                        contentType: "application/json",--%>
    <%--                        data: JSON.stringify(json),--%>
    <%--                        success: function (data, textStatus, xhr) {--%>
    <%--                            alert(xhr.status);--%>
    <%--                        },--%>
    <%--                        error: function (status) {--%>
    <%--                            alert('Neuspješno ažuriran');--%>
    <%--                        }--%>
    <%--                    }--%>
    <%--                )--%>
    <%--            }--%>

    <%--            function azurirajObjekt(sifraObjekt) {--%>

    <%--            }--%>
    <%--          </script> --%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="scripts/script.js"></script>
</head>
<body>
<form>
    <input id="pruzatelj-oib" type="hidden" name="oib" value="<c:out value="${pruzatelj.oib}"/>">
    <label for="pruzatelj-adresa">Adresa</label>
    <input id="pruzatelj-adresa" type="text" name="adresa" value="<c:out value="${pruzatelj.adresa}"/>">
    <%--    <input type="submit" onsubmit="azurirajPruzatelja('<c:out value="${pruzatelj.oib}"/>')">--%>
</form>
<button onclick="azurirajPruzatelja('<c:out value="${pruzatelj.oib}"/>')">Ažuriraj</button>
<jsp:useBean id="fosoba" scope="request" type="java.lang.Boolean"/>
<c:choose>
    <c:when test="${fosoba}">
        <div id="fosoba-${pruzatelj.oib}"></div>
        <form onsubmit="dohvatiFizickuOsobu(<c:out value="${pruzatelj.oib}"/>)">
            <jsp:useBean id="osoba" scope="request" type="model.repository.FizickaOsoba"/>
            <input id="fosoba-<c:out value="${pruzatelj.oib}-ime"/>" type="text"
                   value="<c:out value="${osoba.ime}"/>">
            <label for="fosoba-<c:out value="${pruzatelj.oib}-ime"/>">Ime</label>

            <input id="fosoba-<c:out value="${pruzatelj.oib}-prezime"/>" type="text"
                   value="<c:out value="${osoba.prezime}"/>">
            <label for="fosoba-<c:out value="${pruzatelj.oib}-prezime"/>">Prezime</label>
            <input id="fosoba-<c:out value="${pruzatelj.oib}-datumRodjenja"/>" type="date"
                   value="<c:out value="${osoba.datumRodjenja}"/>">
            <label for="fosoba-<c:out value="${pruzatelj.oib}-datumRodjenja"/>">Datum rođenja</label>
        </form>
        <button onclick="azurirajFizickuOsobu('<c:out value="${pruzatelj.oib}"/>')">Ažuriraj</button>
    </c:when>
    <c:otherwise>
        <div id="posoba-${pruzatelj.oib}"></div>
        <form onsubmit="dohvatiPravnuOsobu(<c:out value="${pruzatelj.oib}"/>)">
            <jsp:useBean id="posoba" scope="request" type="model.repository.PravnaOsoba"/>
            <input id="posoba-<c:out value="${pruzatelj.oib}-naziv"/>" type="text"
                   value="<c:out value="${posoba.naziv}"/>">
            <label for="posoba-<c:out value="${pruzatelj.oib}-naziv"/>">Naziv</label>

            <input id="posoba-<c:out value="${pruzatelj.oib}-pocetniKapital"/>" type="number"
                   value="<c:out value="${posoba.pocetniKapital}"/>">
            <label for="posoba-<c:out value="${pruzatelj.oib}-pocetniKapital"/>">Početni kapital</label>
            <input id="posoba-<c:out value="${pruzatelj.oib}-datumOsnivanja"/>"
                   value="<c:out value="${posoba.datumOsnivanja}"/>">
            <label for="posoba-<c:out value="${pruzatelj.oib}-datumOsnivanja"/>">Datum osnivanja</label>
        </form>
        <button onclick="azurirajPravnuOsobu('<c:out value="${pruzatelj.oib}"/>')">Ažuriraj</button>
    </c:otherwise>
</c:choose>

<div id="objekti-<c:out value="${pruzatelj.oib}"/>">
    &nbsp
</div>
</body>
</html>
