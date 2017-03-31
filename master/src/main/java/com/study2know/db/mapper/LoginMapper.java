package com.study2know.db.mapper;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
import java.sql.*;
import com.study2know.core.entity.Login;

public class LoginMapper implements ResultSetMapper<Login>
{
  public Login map(int index, ResultSet r, StatementContext ctx) throws SQLException
  { 
    Login obj = new Login();
     obj.setId(r.getLong("id"));
 obj.setUser_id(r.getLong("user_id"));
 obj.setEmail_id(r.getString("email_id"));
 obj.setMobile_no(r.getString("mobile_no"));
 obj.setPassword(r.getString("password"));
 obj.setConfirm_password(r.getString("confirm_password"));
 obj.setOtp(r.getString("otp"));
 obj.setLast_login(r.getTimestamp("last_login"));
 obj.setCreated_on(r.getTimestamp("created_on"));
	
    return obj;	
  }
}
