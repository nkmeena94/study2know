package com.study2know.db.mapper;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
import java.sql.*;
import com.study2know.core.entity.Users;

public class UsersMapper implements ResultSetMapper<Users>
{
  public Users map(int index, ResultSet r, StatementContext ctx) throws SQLException
  { 
    Users obj = new Users();
     obj.setUser_id(r.getLong("user_id"));
 obj.setFirst_name(r.getString("first_name"));
 obj.setLast_name(r.getString("last_name"));
 obj.setEmail_id(r.getString("email_id"));
 obj.setMobile_no(r.getString("mobile_no"));
 obj.setAddress(r.getString("address"));
 obj.setLocation_id(r.getLong("location_id"));
 obj.setDate_of_birth(r.getString("date_of_birth"));
 obj.setUpdated_on(r.getTimestamp("updated_on"));
 obj.setCreated_on(r.getTimestamp("created_on"));
	
    return obj;	
  }
}
