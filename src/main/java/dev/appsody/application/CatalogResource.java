package dev.appsody.application;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.opentracing.Traced;

import io.opentracing.Tracer;

@Path("/resource")
public class CatalogResource {
	
	@Inject 
    Tracer tracer;

    @GET
    @Traced(value = true, operationName = "aboutCatalog")
    public String getRequest() {
        return "CatalogResource response";
    }
}
