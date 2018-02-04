package com.nikhilghag.views

import com.nikhilghag.api.User
import io.dropwizard.views.View

class UserView(user: User) extends View("/views/user.ftl") {
  def getUser = user
}
