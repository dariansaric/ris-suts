package web.rest.resource;

import com.google.gson.Gson;
import model.repository.PruzateljUsluga;
import org.json.JSONObject;
import service.PruzateljUslugaService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

//todo:stvaranje pruzatelja
}
