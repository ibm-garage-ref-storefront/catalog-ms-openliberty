package dev.appsody.application;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/resource")
public class CatalogResource {

    @GET
    public String getRequest() {
        return "CatalogResource response";
    }
}
