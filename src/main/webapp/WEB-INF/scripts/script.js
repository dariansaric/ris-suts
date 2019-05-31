let vrste = [];
$(document).ready(function () {
    dohvatiVrste();
    dohvatiObjekte();
});

function azurirajPruzatelja(oib) {
    let json = {
        "oib": oib,
        "adresa": $("#pruzatelj-adresa").val()
    };
    $.ajax(
        {
            url: "/suts/rest/pruzatelj/" + oib,
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

function azurirajFizickuOsobu(oib) {
    let json = {
        oib: oib,
        ime: $("#fosoba-" + oib + "-ime").val(),
        prezime: $("#fosoba-" + oib + "-prezime").val(),
        datumRodjenja: $("#fosoba-" + oib + "-datumRodjenja").val()
    };
    $.ajax(
        {
            url: "/suts/rest/fosoba/" + oib,
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

function azurirajPravnuOsobu(oib) {
    let json = {
        oib: oib,
        naziv: $("#posoba-" + oib + "-naziv").val(),
        datumOsnivanja: $("#posoba-" + oib + "-datumOsnivanja").val(),
        pocetniKapital: $("#posoba-" + oib + "-pocetniKapital").val()
    };
    $.ajax(
        {
            url: "/suts/rest/posoba/" + oib,
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

function azurirajObjekt(sifraObjekt, oib) {
    let json = {
        sifraObjekt: sifraObjekt,
        oib: $("#objekt-" + sifraObjekt + "-oib").val(),
        naziv: $("#objekt-" + sifraObjekt + "-naziv").val(),
        sifraVrsta: $("#objekt-" + sifraObjekt + "-vrsta").val()
    };

    $.ajax({
        url: "suts/rest/objekt/update",
        type: 'POST',
        contentType: "application/json",
        data: JSON.stringify(json),
        success: function (data, textStatus, xhr) {
            alert(xhr.status);
        },
        error: function (status) {
            alert(status);
        }
    })
}

function dohvatiObjekte() {
    let oib = $("#pruzatelj-oib").val();
    $.ajax({
        url: "/suts/rest/objekt/" + oib,
        type: 'GET',
        data: {},
        dataType: "json",
        success: function (data) {
            let objekti = data;
            let html = "<table>";
            html += "<tr><th>Naziv objekta</th><th>Vrsta objekta</th></tr>";
            for (let i = 0; i < objekti.length; i++) {
                let o = data[i];
                html += "<tr>";
                // html += "<td><input id='objekt-" + o.sifraObjekt + "' type='hidden' name='sifraObjekt' " +
                //     "value='" + o.sifraObjekt + "'/></td>";
                // html += "<td><input id='objekt-" + o.sifraObjekt + "-oib' type='hidden' name='oib' " +
                //     "value='" + o.oib + "'/></td>";
                html += "<td><input id='objekt-" + o.sifraObjekt + "-naziv' type='text' value='" + o.naziv + "'/></td>";
                // "<label for='objekt-" + o.sifraObjekt + "-naziv'>Naziv</label>";
                html += "<td><select id='objekt-" + o.sifraObjekt + "-vrsta'>";
                for (let j = 0; j < vrste.length; j++) {
                    if (vrste[j].sifraVrsta === o.sifraVrsta) {
                        html += "<option value='" + vrste[j].sifraVrsta + "' selected>" + vrste[j].nazivVrsta + "</option>";
                    } else {
                        html += "<option value='" + vrste[j].sifraVrsta + "'>" + vrste[j].nazivVrsta + "</option>";
                    }
                }
                html += "</select></td>";
                let s = "azurirajObjekt(" + o.sifraObjekt + ", '" + o.oib + "')";
                html += "<td><button onclick=\"" + s + "\">Ažuriraj</button>";
                s = "izbrisiObjekt(" + o.sifraObjekt + ")";
                html += "<button onclick=\"" + s + "\">Izbriši</button></td></tr>";
            }

            html += "<tr>" +
                "<td><input id=\"novi-objekt-naziv\" placeholder=\"naziv\" type=\"text\"></td>" +
                "<td><select id='novi-objekt-vrsta'>";
            for (let j = 0; j < vrste.length; j++) {
                html += "<option value='" + vrste[j].sifraVrsta + "'>" + vrste[j].nazivVrsta + "</option>";
            }
            let s = "dodajObjekt('" + oib + "')";
            html += "</td><td><button onclick=\"" + s + "\">Dodaj novi objekt</button>";
            html += "</td></tr></table>";
            $("#objekti-" + oib).html(html);
        }
    });
}

function dohvatiVrste() {
    $.ajax({
        url: "/suts/rest/vrsta",
        type: "GET",
        data: {},
        dataType: "json",
        success: function (data) {
            vrste = data;
            let html = "<label for='novi-objekt-vrsta'>Vrsta objekta</label><select id='novi-objekt-vrsta'>";
            for (let i = 0; i < vrste.length; i++) {
                html += "<option value='" + vrste[i].sifraVrsta + "'>" + vrste[i].nazivVrsta + "</option>";
            }

            html += "</select>";
            $("#novi-objekt-vrsta-div").html(html);
        }
    });
}

function dodajObjekt(oib) {
    let json = {
        oib: oib,
        naziv: $("#novi-objekt-naziv").val(),
        sifraVrsta: $("#novi-objekt-vrsta").val()
    };

    $.ajax({
        url: "/suts/rest/objekt/create",
        data: JSON.stringify(json),
        type: 'POST',
        contentType: "application/json",
        success: function (data, textStatus, xhr) {
            alert(xhr.status);
            dohvatiObjekte();
            $("#novi-objekt-naziv").val("");

        },
        error: function (status) {
            alert(status);
        }
    })
}

function izbrisiObjekt(sifraObjekt) {
    $.ajax({
        url: "/suts/rest/objekt/delete/" + sifraObjekt,
        type: 'DELETE',
        data: {},
        success: function (dat, textStatus, xhr) {
            alert(xhr.status);
            dohvatiObjekte();
        }
    })
}