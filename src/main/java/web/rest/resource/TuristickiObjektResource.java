package web.rest.resource;

import com.google.gson.Gson;
import model.repository.TuristickiObjekt;
import org.json.JSONObject;
import service.TuristickiObjektService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("objekt")
public class TuristickiObjektResource {
    private static final Gson GSON = new Gson();

    @Path("/{oib}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response dohvatiObjekte(@PathParam("oib") final String oib) {
        List<TuristickiObjekt> lo = TuristickiObjektService.dohvatiObjekte(oib);

        return Response.status(200).entity(GSON.toJson(lo)).build();
    }

    @Path("/update")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response azurirajObjekt(final String json) {
        TuristickiObjekt o = new TuristickiObjekt();
        JSONObject object = new JSONObject(json);
        o.setSifraObjekt(object.getLong("sifraObjekt"));
        o.setOib(object.getString("oib"));
        o.setNaziv(object.getString("naziv"));
        o.setSifraVrsta(object.getLong("sifraVrsta"));

        return Response.status(TuristickiObjektService.azurirajObjekt(o) ? 200 : 304).build();
    }

    @Path("/create")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response stvoriObjekt(final String json) {
        TuristickiObjekt o = new TuristickiObjekt();
        JSONObject j = new JSONObject(json);
        o.setOib(j.getString("oib"));
        o.setNaziv(j.getString("naziv"));
        o.setSifraVrsta(j.getLong("sifraVrsta"));

        return Response.status(TuristickiObjektService.pohraniObjekt(o) ? 200 : 304).build();
    }

    @Path("/delete/{sifra}")
    @DELETE
    public Response ukloniObjekt(@PathParam("sifra") final long sifraObjekt) {
        return Response.status(TuristickiObjektService.izbrisiObjekt(sifraObjekt) ? 200 : 302).build();
    }
}
