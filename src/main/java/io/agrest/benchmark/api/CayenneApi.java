package io.agrest.benchmark.api;

import io.agrest.Ag;
import io.agrest.DataResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Path("cayenne")
public class CayenneApi {

    @Context
    private Configuration configuration;

    @GET
    public DataResponse<Object> get(@Context UriInfo uri) {
        return Ag.select(Object.class, configuration)
                .uri(uri)
                .get();
    }
}
