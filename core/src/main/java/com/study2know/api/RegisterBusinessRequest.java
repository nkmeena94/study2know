package com.study2know.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.study2know.core.Types;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by anuj on 04/10/15.
 */
public class RegisterBusinessRequest {
    private final String name;
    @NotNull
    @NotBlank
    @Pattern(regexp = "[0-9]{10}")
    private final String phone;
    @NotNull
    @NotBlank
    @Email
    private final String email;
    @NotBlank
    @NotNull
    @JsonProperty
    private final String category;
    @NotBlank
    @NotNull
    @JsonProperty
    private final String password;
    @NotNull
    @JsonProperty
    private final Types.Role role;


    @JsonCreator
    public RegisterBusinessRequest(@JsonProperty("name") String name,
                                   @JsonProperty("phone") String phone,
                                   @JsonProperty("email") String email,
                                   @JsonProperty("category") String category,
                                   @JsonProperty("password") String password,
                                   @JsonProperty("role") Types.Role role) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.category = category;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getCategory() {
        return category;
    }

    public Types.Role getRole() {
        return role;
    }

    public String getPassword() {
        return password;
    }
}
