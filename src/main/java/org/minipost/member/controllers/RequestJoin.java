package org.minipost.member.controllers;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RequestJoin {

    @Email
    @NotBlank
    private String email;
    @NotBlank
    private String password;
    @NotBlank
    private String confirmPassword;
    @NotBlank
    private String userName;
    @NotBlank
    private String mobile;
    @AssertTrue
    private boolean agree;

}
