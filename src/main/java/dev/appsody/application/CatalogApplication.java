package dev.appsody.application;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import dev.appsody.application.client.InventoryServiceClient;
import dev.appsody.application.rest.InventoryRefreshTask;

@ApplicationPath("/")
@Singleton
@Startup
public class CatalogApplication extends Application {
	
	@Inject
    @RestClient
    private InventoryServiceClient invClient;

    @PostConstruct
    public void init() {
        InventoryRefreshTask inv = new InventoryRefreshTask(invClient);
        inv.start();
    }

}
