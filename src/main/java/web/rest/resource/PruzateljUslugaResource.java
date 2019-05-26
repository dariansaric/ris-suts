package web.rest.resource;

import com.google.gson.Gson;
import model.repository.FizickaOsoba;
import model.repository.PravnaOsoba;
import model.repository.PruzateljUsluga;
import org.json.JSONObject;
import service.FizickaOsobaService;
import service.PravnaOsobaService;
import service.PruzateljUslugaService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Date;

@Path("/pruzatelj")
public class PruzateljUslugaResource {
    private static final Gson GSON = new Gson();

    @Path("/{oib}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response dohvatiPruzatelj(@PathParam("oib") final String oib) {
        PruzateljUsluga p = PruzateljUslugaService.dohvatiPruzatelja(oib);
        if (p == null) {
            return Response.status(404).build();
        }

        return Response.status(200).entity(GSON.toJson(p)).build();
    }

    @Path("/{oib}")
    @POST
//    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response azurirajPruzatelj(@PathParam("oib") final String oib, final String json) {
        PruzateljUsluga p = new PruzateljUsluga();
        JSONObject o = new JSONObject(json);
        p.setOib(oib);
        p.setAdresa(o.getString("adresa"));

        return Response.status(PruzateljUslugaService.azurirajPruzatelja(p) ? 200 : 304).build();
    }

    @Path("/create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response dodajPruzatelja(final String json) {
        PruzateljUsluga p = new PruzateljUsluga();
        JSONObject o = new JSONObject(json);
        p.setOib(o.getString("oib"));
        p.setAdresa(o.getString("adresa"));

        if (PruzateljUslugaService.pohraniPruzatelja(p)) {
            if (o.has("ime")) {
                FizickaOsoba f = new FizickaOsoba();
                f.setIme(o.getString("ime"));
                f.setPrezime(o.getString("prezime"));
                f.setDatumRodjenja(Date.valueOf(o.getString("datumRodjenja")));
                return Response.status(FizickaOsobaService.pohraniFizickuOsobu(f) ? 200 : 302).build();
            } else {
                PravnaOsoba r = new PravnaOsoba();
                r.setNaziv(o.getString("naziv"));
                r.setDatumOsnivanja(Date.valueOf(o.getString("datumOsnivanja")));
                r.setPocetniKapital(o.getDouble("pocetniKapital"));
                return Response.status(PravnaOsobaService.pohraniPravnuOsobu(r) ? 200 : 302).build();
            }
        }
        return null;
    }
}
