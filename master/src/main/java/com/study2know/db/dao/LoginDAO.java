package com.study2know.db.dao;

import com.study2know.db.mapper.LoginMapper;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

/**
*	Table structure
*	select  id ,  user_id ,  email_id ,  mobile_no ,  password ,  confirm_password ,  otp ,  last_login ,  created_on from login where id =:key
*	 user_id = :user_id ,  email_id = :email_id ,  mobile_no = :mobile_no ,  password = :password ,  confirm_password = :confirm_password ,  otp = :Otp ,  last_login = :last_login ,  created_on = :created_on where id = :id
*/

@RegisterMapper(LoginMapper.class)
public interface LoginDAO extends _LoginDAO
{
}
