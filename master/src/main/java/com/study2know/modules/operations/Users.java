package com.study2know.modules.operations;

import com.google.inject.Inject;
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
}
