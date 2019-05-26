function otvoriFormuFizickaOsoba() {
    let html = "";
    html += "<input id='fosoba-ime' type='text' placeholder='Ime'><label for='fosoba-ime'>Ime</label>";
    html += "<input id='fosoba-prezime' type='text' placeholder='Prezime'><label for='fosoba-prezime'>Prezime</label>";
    html += "<input id='fosoba-datumRodjenja' type='date'><label for='fosoba-datumRodjenja'>Datum rođenja</label>";

    $("#novi-pruzatelja-osoba").html(html);
}

function otvoriFormuPravnaOsoba() {
    let html = "";
    html += "<input id='posoba-naziv' type='text' placeholder='Naziv'><label for='posoba-naziv'>Naziv</label>";
    html += "<input id='posoba-datumOsnivanja' type='date'><label for='fosoba-datumOsnivanja'>Datum osnivanja</label>";
    html += "<input id='posoba-pocetniKapital' type='number' placeholder='Početni kapital...'><label for='posoba-pocetniKapital'>Početni kapital</label>";

    $("#novi-pruzatelja-osoba").html(html);
}

function dodajPruzatelja() {
    let json = {};
    if ($("input[type=radio][name=osoba]").val() === "f") {
        json = {
            oib: $("#novi-pruzatelj-oib").val(),
            adresa: $("#novi-pruzatelja-adresa").val(),
            ime: $("#fosoba-ime").val(),
            prezime: $("#fosoba-prezime").val(),
            datumRodjenja: $("#fosoba-datumRodjenja").val()
        };

    } else {
        json = {
            oib: $("#novi-pruzatelj-oib").val(),
            adresa: $("#novi-pruzatelja-adresa").val(),
            naziv: $("#posoba-naziv").val(),
            datumOsnivanja: $("#fosoba-datumOsnivanja").val(),
            pocetniKapital: $("#fosoba-pocetniKapital").val()
        };
    }

    $.ajax({
        url: "/suts/rest/pruzatelj/create",
        data: JSON.stringify(json),
        contentType: "application/json",
        dataType: json,
        success: function () {
            url = "http://localhost:8080/suts/home/" + json.oib;
        }
    })
}