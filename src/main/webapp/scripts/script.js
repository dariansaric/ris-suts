//Displays stored tags
// $(document).ready(
//     function () {
//         $.ajax(
//             {
//                 url: "rest/tag",
//                 data: {},
//                 dataType: "json",
//                 success: function (data) {
//                     let tags = data; // već je JSON zbog dataType gore...
//                     let html = "";
//                     if (0 === tags.length) {
//                         html = "No tags, sorry :("
//                     } else {
//                         for (let i = 0; i < tags.length; i++) {
//                             if (i > 0 && i < tags.length) html += "<br>";
//                             html += "<button class='tag-button' onclick=\"processClick.call(this, \'" + htmlEscape(tags[i]) + "\');\">"
//                                 + tags[i] + "</button><br>";
//                             html += "<div id='" + htmlEscape(tags[i]) + "-Tag'>&nbsp</div>";
//                         }
//                     }
//                     $("#tags").html(html);
//                 }
//             }
//         );
//     });

$(".exper").hover(function () {
    document.getElementById("tit").innerHTML = "<h3>Why wouldn't you?! It's... fff.freee</h3>";
});

function imageClicked() {
    alert("Washigton Redskins, go fund yourself!!");
    $(".exper").attr("src", "https://i.ytimg.com/vi/Jykakik24gY/maxresdefault.jpg");
    document.getElementById("tit").innerHTML = "<h3>Why wouldn't you?! It's... fff...freee</h3>";
}

/**
 * processes a mouse click on the for the provided tag button
 *
 * @param tag tag whose button is pressed
 */
function processClick(tag) {
    if (tag === undefined) {
        alert("Predan je undefined tag, pazi što radiš!!");
        return;
    }

    let html = document.getElementById(tag + "-Tag").innerHTML;
    if (html === "&nbsp;") {
        getImagesForTag.call(this, tag);
    } else {
        document.getElementById(tag + "-Tag").innerHTML = "&nbsp;";
    }
}

function dohvatiFizickuOsobu(oib) {
    $.ajax(
        {
            url: "rest/fosoba/" + htmlEscape(oib),
            data: {},
            dataType: "json",
            success: function (data) {
                $("#osoba-" + htmlEscape(oib) + "-ime").html(data.ime);
                $("#osoba-" + htmlEscape(oib) + "-prezime").html(data.prezime);
                $("#osoba-" + htmlEscape(oib) + "-datumRodjenja").html(data.datumRodjenja);
            }
        }
    )
}

function dohvatiPravnuOsobu(oib) {
    $.ajax(
        {
            url: "rest/posoba/" + htmlEscape(oib),
            data: {},
            dataType: "json",
            success: function (data) {
                $("#osoba-" + htmlEscape(oib) + "-naziv").html(data.naziv);
                $("#osoba-" + htmlEscape(oib) + "-datumOsnivanja").html(data.datumOsnivanja);
                $("#osoba-" + htmlEscape(oib) + "-pocetniKapital").html(data.pocetniKapital);
            }
        }
    )
}

function azurirajPruzatelja(oib) {
    let json = {
        "oib": oib,
        "adresa": $("#pruzatelj-adresa").getAttribute("value")
    };
    $.ajax(
        {
            url: "rest/" + oib,
            data: json,
            success: function (data, textStatus, xhr) {
                alert(xhr.status);

            },
            error: function (status) {
                alert('Neuspješno ažuriran');
            }
        }
    )
}
/**
 * Displays thumbnail images for the provided tag.
 *
 * @param tag tag whose thumbnail images are requested
 */
function getImagesForTag(tag) {
    if (tag === undefined) {
        alert("Predan je undefined tag, pazi što radiš!!");
        return;
    }

    $.ajax(
        {
            url: "rest/tag/" + htmlEscape(tag),
            data: {},
            dataType: "json",
            success: function (data) {
                let images = data;
                let html = "";
                if (images.length === 0) {
                    html = "No images for this tag, sorry."
                } else {
                    for (let i = 0; i < images.length; i++) {
                        html += "<img class='thumbnail' id='tb" + htmlEscape(tag + images[i].source) + "' " +
                            "onclick=\"showGreatImage.call(this, \'" + htmlEscape(tag) + "\',\'" +
                            htmlEscape(images[i].source) + "\');\" " +
                            "src='servlets/image?src=" + htmlEscape(images[i].source) + "&thumb=true'/>";
                    }
                }

                $("#" + htmlEscape(tag) + "-Tag").html(html);
            }
        }
    )
}

/**
 * Displays the original image for the given tag and image name.
 *
 * @param tag requested tag
 * @param imageName requested image
 */
function showGreatImage(tag, imageName) {
    $.ajax(
        {
            url: "rest/tag/image/" + htmlEscape(imageName),
            data: {},
            dataType: "json",
            success: function (data) {
                let image = data;
                let html = "";

                let div = document.getElementById("tb" + tag + imageName);
                html += "<div id='tb" + htmlEscape(tag + imageName) + "'>";
                html += "<img class='greatImage' src='servlets/image?src=" +
                    htmlEscape(image.source) + "&thumb=false' " +
                    "onclick=\"shrinkImage.call(this, \'" + tag + "\',\'" + imageName + "\');\"/>" +
                    "<p class='description'>" + htmlEscape(image.description) + "</p>" +
                    "<p class='tags'>" + htmlEscape(image.tags) + "</p>";
                html += "</div>";

                div.outerHTML = html;
            }
        }
    )
}

/**
 * Shrinks the image to thumbnail size for the provided tag and image name.
 *
 * @param tag image tag
 * @param imageName image name
 */
function shrinkImage(tag, imageName) {
    let div = document.getElementById("tb" + tag + imageName);
    let html = "";

    html += "<img class='thumbnail' id='tb" + tag + imageName + "' " +
        "onclick=\"showGreatImage.call(this, \'" + tag + "\',\'" + imageName + "\');\" " +
        "src='servlets/image?src=" + htmlEscape(imageName) + "&thumb=true'/>";

    div.outerHTML = html;
}

//todo:osmisliti ajax pozive i napisati jsp-ove