package com.vitosonline.services.auth;

import com.vitosonline.dtos.SignupRequest;
import com.vitosonline.dtos.UserDto;

public interface AuthService {
    UserDto createUser(SignupRequest signupRequest);
}