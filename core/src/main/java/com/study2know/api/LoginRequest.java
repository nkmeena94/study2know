package com.study2know.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by kurtesy on 30/9/15.
 */
@JsonIgnoreProperties
public class LoginRequest {
    @NotNull
    @NotBlank
    private final String userId;
    @NotNull
    @NotBlank
    private final String password;
    @NotNull
    @NotBlank
    private final String deviceId;

    @JsonCreator
    public LoginRequest(@JsonProperty("userId") String userId,
                        @JsonProperty("password") String password,
                        @JsonProperty("deviceId") String deviceId) {
        this.userId = userId;
        this.password = password;
        this.deviceId = deviceId;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getDeviceId() {
        return deviceId;
    }

}
