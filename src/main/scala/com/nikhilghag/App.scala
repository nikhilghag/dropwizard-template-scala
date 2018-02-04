package com.nikhilghag

import com.datasift.dropwizard.scala.ScalaApplication
import com.nikhilghag.resources.HelloWorldResources
import io.dropwizard.setup.{Bootstrap, Environment}


object App extends ScalaApplication[HelloWorldConfiguration] {
  override def init(bootstrap: Bootstrap[HelloWorldConfiguration]) = {
  }

  override def run(configuration: HelloWorldConfiguration, environment: Environment): Unit = {
    val helloWorldResources = new HelloWorldResources(configuration.template, configuration.defaultName)
    environment.jersey().register(helloWorldResources)
  }
}