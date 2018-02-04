package com.nikhilghag.core

import java.sql.ResultSet

import com.nikhilghag.api.User
import org.skife.jdbi.v2.StatementContext
import org.skife.jdbi.v2.tweak.ResultSetMapper

class UserMapper extends ResultSetMapper[User] {
  override def map(i: Int, resultSet: ResultSet, statementContext: StatementContext) = {
      new User(resultSet.getInt("id"), resultSet.getString("name"))
  }
}
