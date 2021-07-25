package org.places.users.service;

import org.places.common.config.Constants;
import org.places.common.models.User;
import org.places.common.models.UserCredential;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * public facing APIs for user operations
 */
@Path(Constants.PATH_USERS)
@Produces(MediaType.APPLICATION_JSON)
public class UsersService {

    @POST
    @Path(Constants.PATH_REGISTER)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response registerUser(User user) {
        return Response.ok("User Registered").build();}

    @POST
    @Path(Constants.PATH_REGISTER)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticateUser(UserCredential userCredential) {
        return Response.ok("User Registered").build();}


}
