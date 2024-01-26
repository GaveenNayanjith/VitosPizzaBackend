package com.vitosonline.dtos;

import com.vitosonline.enums.UserRole;

public class UserDto {
    private long id;
    private String name;
    private String email;
    private String password;
    private UserRole userRole;

    public UserDto() {
    }

    public void setId(final long id) {
        this.id = id;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public void setUserRole(final UserRole userRole) {
        this.userRole = userRole;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }

    public UserRole getUserRole() {
        return this.userRole;
    }
}

