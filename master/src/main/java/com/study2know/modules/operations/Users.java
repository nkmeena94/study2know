package com.study2know.modules.operations;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.inject.Inject;
import com.study2know.core.DateTimeUtil;
import com.study2know.db.dao.UsersDAO;


/**
 * Created by Naval on 31/3/17.
 */
public class Users {
    private final UsersDAO usersDAO;
    @Inject
    public Users(UsersDAO usersDAO) {
        this.usersDAO = usersDAO;
    }

    public com.study2know.core.entity.Users getUserDetail(Long id){
        return usersDAO.findById(id);
    }

    public int createNewUser(String userDetail){
        com.study2know.core.entity.Users users = new com.study2know.core.entity.Users();
        JsonObject user=(JsonObject) new JsonParser().parse(userDetail).getAsJsonObject();
        if(user.get("mobile_no").getAsString().equals("") || user.get("mobile_no").getAsString().isEmpty()){
            return 0;
        }
        users.setUpdated_on(DateTimeUtil.getTimeStamp());
        users.setCreated_on(DateTimeUtil.getTimeStamp());
        users.setFirst_name(user.get("first_name").getAsString());
        users.setLast_name(user.get("last_name").getAsString());
        users.setEmail_id(user.get("email_id").getAsString());
        users.setMobile_no(user.get("mobile_no").getAsString());
        users.setDate_of_birth(user.get("date_of_birth").getAsString());
        users.setLocation_id(user.get("location_id").getAsLong());
        users.setAddress(user.get("address").getAsString());
        return (int) usersDAO.insert(users);
    }

}
