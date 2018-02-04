package com.nikhilghag.resources

import javax.ws.rs._
import javax.ws.rs.core.{MediaType, Response, UriBuilder}

import com.nikhilghag.jdbi.MyDAO

@Path("/jdbi-test")
@Produces(Array(MediaType.APPLICATION_JSON))
class JDBITestResource(myDAO: MyDAO) {

  @POST
  def postSomething(@QueryParam("id") id: Int, @QueryParam("name") name: String): Response = {
    myDAO.insert(id, name)

    Response.created(UriBuilder.fromResource(classOf[JDBITestResource])
      .build())
      .build()
  }

  @GET
  def getSomething(@QueryParam("id") id: Int): Response = {
    Response.ok(myDAO.findUserById(id))
      .build()
  }
}
