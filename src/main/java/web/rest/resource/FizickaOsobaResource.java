package web.rest.resource;

import com.google.gson.Gson;
import model.repository.FizickaOsoba;
import org.json.JSONObject;
import service.FizickaOsobaService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Date;

@Path("/fosoba")
public class FizickaOsobaResource {
    private static final Gson GSON = new Gson();

    @Path("/{oib}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response dohvatiOsobu(@PathParam("oib") final String oib) {
        FizickaOsoba o = FizickaOsobaService.dohvatiFizickuOsobu(oib);

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
        FizickaOsoba p = new FizickaOsoba();
        JSONObject o = new JSONObject(json);
        p.setOib(o.getString("oib"));
        p.setIme(o.getString("ime"));
        p.setPrezime(o.getString("prezime"));
        p.setDatumRodjenja(Date.valueOf("datumRodjenja"));

        return Response.status(FizickaOsobaService.azuzirajFizickuOsobu(p) ? 200 : 304).build();
    }


}
