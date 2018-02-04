package com.nikhilghag.healthcheck

import com.codahale.metrics.health.HealthCheck
import com.codahale.metrics.health.HealthCheck.Result

class TemplateHealthCheck(template: String) extends HealthCheck {
  override def check() = {
    val saying = String.format(template, "TEST")

    if (saying.equals("Hello, TEST!"))
      Result.healthy()
    else
      Result.unhealthy("Template is not in following format - Hello, {name}!")
  }
}
