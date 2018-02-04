package com.nikhilghag.jdbi

import com.nikhilghag.api.User
import com.nikhilghag.core.UserMapper
import org.skife.jdbi.v2.sqlobject.customizers.Mapper

trait MyDAO {

  import org.skife.jdbi.v2.sqlobject.{Bind, SqlQuery, SqlUpdate}

  @SqlUpdate("insert into something (id, name) values (:id, :name)") def insert(@Bind("id") id: Int, @Bind("name") name: String): Unit

  @SqlQuery("select id,name from something where id = :id")
  @Mapper(classOf[UserMapper]) def findUserById(@Bind("id") id: Int): User

}
