package com.study2know.db.dao;

import com.study2know.core.entity.Users;
import org.skife.jdbi.v2.sqlobject.*;
import java.util.Date;
import java.util.Set;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import com.study2know.db.mapper.UsersMapper;


public interface _UsersDAO
{
  @SqlQuery("select  user_id ,  first_name ,  last_name ,  email_id ,  mobile_no ,  address ,  location_id ,  date_of_birth ,  updated_on ,  created_on from users where user_id =:key")
  Users findById(@Bind("key") Long user_id);

  @SqlQuery("select * from users")
  Set<Users> loadAll();

  @SqlUpdate("delete from users where user_id = :key")
  int remove(@Bind("key") Long user_id);
  
  @GetGeneratedKeys
  @SqlUpdate("insert into users ( user_id ,  first_name ,  last_name ,  email_id ,  mobile_no ,  address ,  location_id ,  date_of_birth ,  updated_on ,  created_on) values ( :user_id ,  :first_name ,  :last_name ,  :email_id ,  :mobile_no ,  :Address ,  :location_id ,  :date_of_birth ,  :updated_on ,  :created_on)")
  long insert(@BindBean Users obj);

  @SqlUpdate("update users set  first_name = :first_name ,  last_name = :last_name ,  email_id = :email_id ,  mobile_no = :mobile_no ,  address = :Address ,  location_id = :location_id ,  date_of_birth = :date_of_birth ,  updated_on = :updated_on ,  created_on = :created_on where user_id = :user_id")
  int update(@BindBean Users obj);
}