package com.nikhilghag.api

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.validator.constraints.Length

case class Saying(@JsonProperty val id: Long,
                  @Length(max = 3) @JsonProperty val content: String)
