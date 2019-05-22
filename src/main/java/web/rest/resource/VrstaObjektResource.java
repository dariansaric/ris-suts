package web.rest.resource;

import com.google.gson.Gson;
import service.VrstaObjektService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/vrsta")
public class VrstaObjektResource {
    private static final Gson GSON = new Gson();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response dohvatiVrste() {
        return Response.status(200).entity(GSON.toJson(VrstaObjektService.dohvatiVrste())).build();
    }

    @Path("/{vrsta}")
    public Response dohvatiVrstu(@PathParam("vrsta") final long vrsta) {
        return Response.status(200).entity(VrstaObjektService.dohvatiVrstu(vrsta)).build();
    }
}
