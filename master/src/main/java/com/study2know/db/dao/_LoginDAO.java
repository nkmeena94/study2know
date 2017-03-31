package com.study2know.db.dao;

import com.study2know.core.entity.Login;
import org.skife.jdbi.v2.sqlobject.*;
import java.util.Date;
import java.util.Set;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import com.study2know.db.mapper.LoginMapper;


public interface _LoginDAO
{
  @SqlQuery("select  id ,  user_id ,  email_id ,  mobile_no ,  password ,  confirm_password ,  otp ,  last_login ,  created_on from login where id =:key")
  Login findById(@Bind("key") Long id);

  @SqlQuery("select * from login")
  Set<Login> loadAll();

  @SqlUpdate("delete from login where id = :key")
  int remove(@Bind("key") Long id);
  
  @GetGeneratedKeys
  @SqlUpdate("insert into login ( id ,  user_id ,  email_id ,  mobile_no ,  password ,  confirm_password ,  otp ,  last_login ,  created_on) values ( :id ,  :user_id ,  :email_id ,  :mobile_no ,  :password ,  :confirm_password ,  :Otp ,  :last_login ,  :created_on)")
  long insert(@BindBean Login obj);

  @SqlUpdate("update login set  user_id = :user_id ,  email_id = :email_id ,  mobile_no = :mobile_no ,  password = :password ,  confirm_password = :confirm_password ,  otp = :Otp ,  last_login = :last_login ,  created_on = :created_on where id = :id")
  int update(@BindBean Login obj);
}
