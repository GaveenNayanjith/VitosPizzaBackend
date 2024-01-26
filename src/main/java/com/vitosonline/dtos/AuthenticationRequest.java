package com.vitosonline.dtos;

public class AuthenticationRequest {
    private String email;
    private String password;

    public AuthenticationRequest() {
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setPassword(final String password) {
        this.password = password;
    }
}

