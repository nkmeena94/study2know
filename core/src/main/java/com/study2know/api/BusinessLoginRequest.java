package com.study2know.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.study2know.core.Types;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * Created by kurtesy on 30/9/15.
 */
@JsonIgnoreProperties
public class BusinessLoginRequest {
    @NotNull
    @NotBlank
    private final String userId;
    @NotNull
    @NotBlank
    private final String password;
    @NotNull
    private final Types.Role role;
    @NotNull
    @NotBlank
    private final String deviceId;

    @JsonCreator
    public BusinessLoginRequest(@JsonProperty("userId") String userId,
                                @JsonProperty("password") String password,
                                @JsonProperty("role") Types.Role role,
                                @JsonProperty("deiceveId") String deviceId) {
        this.userId = userId;
        this.password = password;
        this.role = role;
        this.deviceId = deviceId;
    }

    public String getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public Types.Role getRole() {
        return role;
    }

    public String getDeviceId() {
        return deviceId;
    }
}
