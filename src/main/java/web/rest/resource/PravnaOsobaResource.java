package web.rest.resource;

import com.google.gson.Gson;
import model.repository.PravnaOsoba;
import org.json.JSONObject;
import service.PravnaOsobaService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Date;

public class PravnaOsobaResource {
    private static final Gson GSON = new Gson();

    //todo: frontend
    @Path("/{oib}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response dohvatiOsobu(@PathParam("oib") final String oib) {
        PravnaOsoba o = PravnaOsobaService.dohvatiPravnuOsobu(oib);

        if (o == null) {
            return Response.status(404).build();
        }

        return Response.status(200).entity(GSON.toJson(o)).build();
    }

    @Path("/{oib}")
    @POST
//    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response azurirajOsobu(@PathParam("oib") final String oib, final String json) {
        PravnaOsoba p = new PravnaOsoba();
        JSONObject o = new JSONObject(json);
        p.setOib(o.getString("oib"));
        p.setNaziv(o.getString("naziv"));
        p.setDatumOsnivanja(Date.valueOf(o.getString("datumOsnivanja")));
        p.setPocetniKapital(o.getDouble("pocetniKapital"));

        return Response.status(PravnaOsobaService.azuzirajPravnuOsobu(p) ? 200 : 304).build();
    }
}
