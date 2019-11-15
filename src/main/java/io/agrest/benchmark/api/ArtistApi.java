package io.agrest.benchmark.api;

import io.agrest.Ag;
import io.agrest.DataResponse;
import io.agrest.benchmark.db1.Artist;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Configuration;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

@Path("cayenne")
public class ArtistApi {

    @Context
    private Configuration configuration;

    @GET
    public DataResponse<Artist> get(@Context UriInfo uri) {
        return Ag.select(Artist.class, configuration)
                .uri(uri)
                .get();
    }
}
