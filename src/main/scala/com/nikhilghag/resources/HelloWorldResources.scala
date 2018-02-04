package com.nikhilghag.resources

import java.util.concurrent.atomic.AtomicLong
import javax.ws.rs.core.MediaType
import javax.ws.rs.{GET, Path, Produces, QueryParam}

import com.nikhilghag.api.Saying

@Path("/hello-world")
@Produces(Array(MediaType.APPLICATION_JSON))
class HelloWorldResources(template: String, name: String) {
  val resourceTemplate = template
  val defaultName = name
  val counter: AtomicLong = new AtomicLong()

  @GET
  def sayHello(@QueryParam("name") name: Option[String]): Saying = {
    val value = String.format(resourceTemplate, name.getOrElse(defaultName))
    return new Saying(counter.incrementAndGet(), value)
  }

}
