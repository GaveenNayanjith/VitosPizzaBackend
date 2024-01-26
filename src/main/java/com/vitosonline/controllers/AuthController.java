package com.vitosonline.controllers;

import com.vitosonline.dtos.AuthenticationRequest;
import com.vitosonline.dtos.AuthenticationResponse;
import com.vitosonline.dtos.SignupRequest;
import com.vitosonline.dtos.UserDto;
import com.vitosonline.services.auth.AuthService;
import com.vitosonline.util.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/api/auth"})
public class AuthController {
    private final AuthService authService;
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    public AuthController(AuthService authService, AuthenticationManager authenticationManager, UserDetailsService userDetailsService, JwtUtil jwtUtil) {
        this.authService = authService;
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping({"/signup"})
    public ResponseEntity<?> signupUser(@RequestBody SignupRequest signupRequest) {
        UserDto createdUserDto = this.authService.createUser(signupRequest);
        return createdUserDto == null ? new ResponseEntity("User creation failed! Please Try again!", HttpStatus.BAD_REQUEST) : new ResponseEntity(createdUserDto, HttpStatus.CREATED);
    }

    @PostMapping({"/login"})
    public AuthenticationResponse createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest, HttpServletResponse response) throws IOException {
        try {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException var5) {
            throw new BadCredentialsException("Incorrect username or password!");
        } catch (DisabledException var6) {
            response.sendError(404, "User Not Active!");
            return null;
        }

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(authenticationRequest.getEmail());
        String jwt = this.jwtUtil.generateToken(userDetails.getUsername());
        return new AuthenticationResponse(jwt);
    }
}

