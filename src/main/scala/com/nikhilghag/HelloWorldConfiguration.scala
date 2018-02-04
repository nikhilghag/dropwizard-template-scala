package com.nikhilghag

import com.datasift.dropwizard.scala.validation.constraints.NotEmpty
import com.fasterxml.jackson.annotation.JsonProperty
import io.dropwizard.Configuration

case class HelloWorldConfiguration(@NotEmpty @JsonProperty val template: String,
                                   @NotEmpty @JsonProperty val defaultName: String = "Stranger") extends Configuration
