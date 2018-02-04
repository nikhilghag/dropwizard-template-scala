package com.nikhilghag

import com.datasift.dropwizard.scala.ScalaApplication
import com.nikhilghag.healthcheck.TemplateHealthCheck
import com.nikhilghag.jdbi.MyDAO
import com.nikhilghag.resources.{HelloWorldResources, JDBITestResource, UserResource}
import io.dropwizard.jdbi.DBIFactory
import io.dropwizard.setup.{Bootstrap, Environment}
import io.dropwizard.views.ViewBundle


object App extends ScalaApplication[HelloWorldConfiguration] {
  override def init(bootstrap: Bootstrap[HelloWorldConfiguration]) = {
    bootstrap.addBundle(new ViewBundle[HelloWorldConfiguration])
  }

  override def run(configuration: HelloWorldConfiguration, environment: Environment): Unit = {
    val helloWorldResources = new HelloWorldResources(configuration.template, configuration.defaultName)

    val templateHealthCheck = new TemplateHealthCheck(configuration.template)
    val dBIFactory = new DBIFactory()
    val jdbi = dBIFactory.build(environment, configuration.database, "mysql")
    val myDAO = jdbi.onDemand(classOf[MyDAO])

    environment.jersey().register(helloWorldResources)
    environment.jersey().register(new JDBITestResource(myDAO))
    environment.jersey().register(new UserResource(myDAO))
    environment.healthChecks().register("Template", templateHealthCheck)
  }
}