package com.nikhilghag

import javax.validation.constraints.NotNull

import com.datasift.dropwizard.scala.validation.constraints.{NotEmpty, Valid}
import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration
import io.dropwizard.db.DataSourceFactory

case class HelloWorldConfiguration(@NotEmpty @JsonProperty val template: String,
                                   @NotEmpty @JsonProperty val defaultName: String = "Stranger",
                                   @NotNull @Valid @JsonProperty("database") val database: DataSourceFactory = new DataSourceFactory) extends Configuration
