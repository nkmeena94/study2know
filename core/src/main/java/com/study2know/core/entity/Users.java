package com.study2know.core.entity;
import java.util.Date;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import com.study2know.core.Types.*;
import com.study2know.validation.*;
import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonProperty;

@ApiModel
public class Users
{
	
@JsonProperty
private Long user_id ;
public Long getUser_id() {return user_id;}
public void setUser_id(Long user_id) { this.user_id = user_id;}

@Size(max=100)
@JsonProperty
private String first_name ;
public String getFirst_name() {return first_name;}
public void setFirst_name(String first_name) { this.first_name = first_name;}

@Size(max=100)
@JsonProperty
private String last_name ;
public String getLast_name() {return last_name;}
public void setLast_name(String last_name) { this.last_name = last_name;}

@Size(max=100)
@JsonProperty
private String email_id ;
public String getEmail_id() {return email_id;}
public void setEmail_id(String email_id) { this.email_id = email_id;}

@NotBlank
@Size(max=100)
@JsonProperty
private String mobile_no ;
public String getMobile_no() {return mobile_no;}
public void setMobile_no(String mobile_no) { this.mobile_no = mobile_no;}

@Size(max=100)
@JsonProperty
private String Address ;
public String getAddress() {return Address;}
public void setAddress(String Address) { this.Address = Address;}

@JsonProperty
private long location_id ;
public long getLocation_id() {return location_id;}
public void setLocation_id(long location_id) { this.location_id = location_id;}

@Size(max=100)
@JsonProperty
private String date_of_birth ;
public String getDate_of_birth() {return date_of_birth;}
public void setDate_of_birth(String date_of_birth) { this.date_of_birth = date_of_birth;}

@JsonProperty
private Date updated_on ;
public Date getUpdated_on() {return updated_on;}
public void setUpdated_on(Date updated_on) { this.updated_on = updated_on;}

@JsonProperty
private Date created_on ;
public Date getCreated_on() {return created_on;}
public void setCreated_on(Date created_on) { this.created_on = created_on;}

	@Override
        public String toString() {
		return "user_id:"+user_id+",first_name:"+first_name+",last_name:"+last_name+",email_id:"+email_id+",mobile_no:"+mobile_no+",Address:"+Address+",location_id:"+location_id+",date_of_birth:"+date_of_birth+",updated_on:"+updated_on+",created_on:"+created_on;
	}
}


