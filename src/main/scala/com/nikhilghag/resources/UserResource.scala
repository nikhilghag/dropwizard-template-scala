package com.nikhilghag.resources

import javax.ws.rs.core.MediaType
import javax.ws.rs.{GET, Path, PathParam, Produces}

import com.nikhilghag.jdbi.MyDAO
import com.nikhilghag.views.UserView

@Path("/user/{id}")
@Produces(Array(MediaType.TEXT_HTML))
class UserResource(myDAO: MyDAO) {
  @GET def getUser(@PathParam("id") id: Int) = {
    new UserView(myDAO.findUserById(id))
  }
}