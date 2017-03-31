package com.study2know.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.study2know.core.Types;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * Created by anurag on 07/08/15.
 */
public class RegisterRequest {
    public String name;
    @NotNull
    @NotBlank
    @Pattern(regexp = "[0-9]{10}")
    public String phone;
    public Date dob;
    public Types.Gender gender;
    @NotNull
    @NotBlank
    public String deviceId;

    public RegisterRequest() {

    }

    @JsonCreator
    public RegisterRequest(@JsonProperty("name") String name,
                           @JsonProperty("phone") String phone,
                           @JsonProperty("dob") Date dob,
                           @JsonProperty("gender") Types.Gender gender,
                           @JsonProperty("deviceId") String deviceId) {
        this.name = name;
        this.phone = phone;
        this.dob = dob;
        this.gender = gender;
        this.deviceId = deviceId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Date getDob() {
        return dob;
    }

    public Types.Gender getGender() {
        return gender;
    }

    public String getDeviceId() {
        return deviceId;
    }
}
