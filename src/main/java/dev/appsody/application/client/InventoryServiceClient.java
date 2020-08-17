package dev.appsody.application.client;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Dependent
@RegisterRestClient
@RegisterProvider(InventoryResponseExceptionMapper.class)
public interface InventoryServiceClient {

    // We could use NotFoundException or ServiceUnavailableException,
    // but here we'll demonstrate how to use and write your own exception.
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    List<Item> getAllItems() throws UnknownUrlException, ServiceNotReadyException;

}
