package com.learn.classPortal.service;

import com.learn.classPortal.payload.AuthenticationResult;
import com.learn.classPortal.security.request.LoginRequest;
import com.learn.classPortal.security.request.SignupRequest;
import com.learn.classPortal.security.response.MessageResponse;
import com.learn.classPortal.security.response.UserInfoResponse;

import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;

public interface AuthService {

    AuthenticationResult login(LoginRequest loginRequest);

    ResponseEntity<MessageResponse> register(SignupRequest signUpRequest);

    UserInfoResponse getCurrentUserDetails(Authentication authentication);

    ResponseCookie logoutUser();
}