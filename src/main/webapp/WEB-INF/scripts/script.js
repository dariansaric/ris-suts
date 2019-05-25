$(document).ready(
    function () {
        let oib = $("#pruzatelj-oib").val();
        $.ajax({
            url: "rest/objekt/" + oib,
            type: 'GET',
            data: {},
            dataType: "json",
            success: function (data) {
                let objekti = data;
                let html = "<ul>";
                for (let i = 0; i < objekti.length; i++) {
                    let o = data[i];
                    html += "<li><form>";
                    html += "<input id='objekt-" + o.sifraObjekt + "' type='hidden' name='sifraObjekt' " +
                        "value='" + o.sifraObjekt + "'/>";
                    html += "<input id='objekt-" + o.sifraObjekt + "-oib' type='hidden' name='oib' " +
                        "value='" + o.oib + "'/>";
                    html += "<input id='objekt-" + o.sifraObjekt + "-naziv' type='text' value='" + o.naziv + "'/>" +
                        "<label for='objekt-" + o.sifraObjekt + "-naziv'>Naziv</label>";
                    html += "</form>";
                    html += "<button onclick='azurirajObjekt(\'" + o.sifraObjekt + "\')'>Ažuriraj</button></li>";
                    //todo: html += "<button >Izbriši</button>";
                    //todo:vrsta objekta
                }

                html += "</ul>";
                //todo: dodavanje novog objekta
                $("#objekti-" + oib).html(html);
            }
        });
    });

// function htmlEscape(str) {
//     return String(str)
//         .replace(/&/g, '&amp;')
//         .replace(/"/g, '&quot;')
//         .replace(/'/g, '&#39;')
//         .replace(/</g, '&lt;')
//         .replace(/>/g, '&gt;');
//}

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

function azurirajFizickuOsobu(oib) {
    let json = {
        oib: oib,
        ime: $("#fosoba-" + oib + "-ime").val(),
        prezime: $("#fosoba-" + oib + "-prezime").val(),
        datumRodjenja: $("#fosoba-" + oib + "-datumRodjenja").val()
    };
    $.ajax(
        {
            url: "rest/fosoba/" + oib,
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
            url: "rest/posoba/" + oib,
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

function azurirajObjekt(sifraObjekt) {

}