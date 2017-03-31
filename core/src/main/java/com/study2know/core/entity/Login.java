package com.study2know.core.entity;
import java.util.Date;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import com.study2know.core.Types;
import com.study2know.validation.VerifyType;
import io.swagger.annotations.ApiModel;
import com.fasterxml.jackson.annotation.JsonProperty;

@ApiModel
public class Login
{
	
@JsonProperty
private Long id ;
public Long getId() {return id;}
public void setId(Long id) { this.id = id;}

@JsonProperty
private long user_id ;
public long getUser_id() {return user_id;}
public void setUser_id(long user_id) { this.user_id = user_id;}

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

@NotBlank
@Size(max=100)
@JsonProperty
private String password ;
public String getPassword() {return password;}
public void setPassword(String password) { this.password = password;}

@NotBlank
@Size(max=100)
@JsonProperty
private String confirm_password ;
public String getConfirm_password() {return confirm_password;}
public void setConfirm_password(String confirm_password) { this.confirm_password = confirm_password;}

@Size(max=10)
@JsonProperty
private String Otp ;
public String getOtp() {return Otp;}
public void setOtp(String Otp) { this.Otp = Otp;}

@JsonProperty
private Date last_login ;
public Date getLast_login() {return last_login;}
public void setLast_login(Date last_login) { this.last_login = last_login;}

@JsonProperty
private Date created_on ;
public Date getCreated_on() {return created_on;}
public void setCreated_on(Date created_on) { this.created_on = created_on;}

	@Override
        public String toString() {
		return "id:"+id+",user_id:"+user_id+",email_id:"+email_id+",mobile_no:"+mobile_no+",password:"+password+",confirm_password:"+confirm_password+",Otp:"+Otp+",last_login:"+last_login+",created_on:"+created_on;
	}
}


