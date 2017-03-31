package com.study2know.db.dao;

import com.study2know.core.entity.Users;
import com.study2know.db.mapper.UsersMapper;
import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.BatchChunkSize;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.Iterator;
import java.util.Set;

/**
*	Table structure
*	select  id ,  name ,  gender ,  email ,  phone ,  birthday ,  address ,  photo_url ,  anniversary ,  facebook_id ,  facebook_access_token ,  facebook_data ,  fcm_token ,  device ,  is_verified ,  status ,  joined_at ,  joined_at_type ,  updated_on ,  created_on from users where id =:key
*	 name = :name ,  gender = :gender ,  email = :email ,  phone = :phone ,  birthday = :birthday ,  address = :address ,  photo_url = :photo_url ,  anniversary = :anniversary ,  facebook_id = :facebook_id ,  facebook_access_token = :facebook_access_token ,  facebook_data = :facebook_data ,  fcm_token = :fcm_token ,  device = :device ,  is_verified = :is_verified ,  status = :status ,  joined_at = :joined_at ,  joined_at_type = :joined_at_type ,  updated_on = :updated_on ,  created_on = :created_on where id = :Id
*/

@RegisterMapper(UsersMapper.class)
public interface UsersDAO extends _UsersDAO
{
    @SqlQuery("select  * from users where deviceid =:key")
    Users findByDeviceId(@Bind("key") String deviceId);

    @SqlQuery("select  * from users where phone =:key")
    Users findByMobile(@Bind("key") String phone);

    @SqlQuery("select * from users where email=:email")
    Users findByEmail(@Bind("email")String email);

    @SqlUpdate("update users set password = :password where id = :id")
    int updatePasswordById(@Bind("id")Long id , @Bind("password")String password);

    @SqlBatch("insert into users ( id ,  name ,  gender ,  email ,  phone ,  birthday ,  address ,  photo_url ,  anniversary ,  facebook_id ,  facebook_access_token ,  facebook_data ,  fcm_token ,  device ,  is_verified ,  status ,  joined_at ,  joined_at_type ,  updated_on ,  created_on) values ( :Id ,  :name ,  :gender ,  :email ,  :phone ,  :birthday ,  :address ,  :photo_url ,  :anniversary ,  :facebook_id ,  :facebook_access_token ,  :facebook_data ,  :fcm_token ,  :device ,  :is_verified ,  :status ,  :joined_at ,  :joined_at_type ,  :updated_on ,  :created_on)")
    @BatchChunkSize(1000)
    void insertBulk(@BindBean Iterator<Users> users);


}
