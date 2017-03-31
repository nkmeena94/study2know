package com.study2know.db.dao;

import com.study2know.core.entity.Users;
import com.study2know.db.mapper.UsersMapper;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.BatchChunkSize;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.Iterator;
import java.util.Set;



@RegisterMapper(UsersMapper.class)
public interface UsersDAO extends _UsersDAO
{



}
