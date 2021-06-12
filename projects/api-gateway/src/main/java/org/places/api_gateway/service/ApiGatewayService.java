package org.places.api_gateway.service;

import org.places.api_gateway.config.Constants;
import org.places.places.common.models.Place;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * public facing APIs
 */
@Path(Constants.PATH_API_GATEWAY)
@Produces(MediaType.APPLICATION_JSON)
public class ApiGatewayService {


    /**
     * Creates a new place
     */
    @POST
    @Path(Constants.PATH_CREATE_PLACE)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createPlace(Place place) {
        return Response.ok("created place").build();
    }

    /**
     * Searches places based on passed filters
     */
    @GET
    @Path(Constants.PATH_SEARCH_PLACES)
    public Response searchPlaces(@QueryParam("lat") Integer latitude,
                              @QueryParam("long") Integer longitude,
                              @QueryParam("radius") Integer radius,
                              @QueryParam("type") String type,
                              @QueryParam("name") String placeName) {
        return Response.ok("searched places").build();
    }

    /**
     * Creates a new review
     */
    @POST
    @Path(Constants.PATH_CREATE_REVIEW)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createReview(String reviewInfo) {
        return Response.ok("created review").build();
    }
}
