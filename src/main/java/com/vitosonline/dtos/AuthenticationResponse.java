package com.vitosonline.dtos;

public record AuthenticationResponse(String jwt) {
    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String jwt() {
        return this.jwt;
    }
}
