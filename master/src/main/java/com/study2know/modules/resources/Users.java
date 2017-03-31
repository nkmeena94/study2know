package com.study2know.modules.resources;

import com.codahale.metrics.annotation.ExceptionMetered;
import com.codahale.metrics.annotation.Timed;
import com.google.inject.Inject;
import com.sun.el.parser.ParseException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Naval on 31/3/17.
 */
@Path("/api/study2know/users")
@Produces(MediaType.APPLICATION_JSON)
@Api("Users Operation")

public class Users {

    private final com.study2know.modules.operations.Users users;
    @Inject
    public Users(com.study2know.modules.operations.Users users) {
        this.users = users;
    }

    @GET
    @Timed
    @ExceptionMetered
    @Path("/getuserdetail/{user_id}")
    @ApiOperation(value = "Loads all the books Details")
    public com.study2know.core.entity.Users getUserDetail(@PathParam("user_id") Long user_id) throws ParseException {
       return users.getUserDetail(user_id);
    }
}
