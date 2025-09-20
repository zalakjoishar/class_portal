package com.learn.classPortal.security.request;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String name;

    @NotBlank
    @Size(max = 50)
    @Email
    private String emailId;
    
    @NotBlank
    @Size(max = 10)
    private String phoneNo;

    private String role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
    

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}