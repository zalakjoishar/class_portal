package com.learn.classPortal.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.learn.classPortal.entity.Role;
import com.learn.classPortal.entity.User;
import com.learn.classPortal.payload.AuthenticationResult;
import com.learn.classPortal.repositories.RoleRepository;
import com.learn.classPortal.repositories.UserRepository;
import com.learn.classPortal.security.jwt.JwtUtils;
import com.learn.classPortal.security.request.LoginRequest;
import com.learn.classPortal.security.request.SignupRequest;
import com.learn.classPortal.security.response.MessageResponse;
import com.learn.classPortal.security.response.UserInfoResponse;
import com.learn.classPortal.security.services.UserDetailImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Override
    public AuthenticationResult login(LoginRequest loginRequest) {
        Authentication authentication = authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        UserDetailImpl userDetails = (UserDetailImpl) authentication.getPrincipal();

        ResponseCookie jwtCookie = jwtUtils.generateJwtCookie(userDetails);

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        UserInfoResponse response = new UserInfoResponse(userDetails.getId(),
                userDetails.getUsername(), roles, userDetails.getUsername(), jwtCookie.toString());

        return new AuthenticationResult(response, jwtCookie);
    }

    @Override
    public ResponseEntity<MessageResponse> register(SignupRequest signUpRequest) {
        if (userRepository.existsByEmailId(signUpRequest.getEmailId())) {
            return ResponseEntity.badRequest().body(new MessageResponse("Error: Username is already taken!"));
        }

//        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
//            return ResponseEntity.badRequest().body(new MessageResponse("Error: Email is already in use!"));
//        }

        // Create new user's account
        User user = new User(signUpRequest.getName(),signUpRequest.getPhoneNo(),signUpRequest.getEmailId(),encoder.encode(signUpRequest.getPassword()));

        String strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null || strRoles.isEmpty()) {
            // Default role if none specified
            Role defaultRole = roleRepository.findByRoleName("ROLE_STUDENT")
                    .orElseThrow(() -> new RuntimeException("Error: Default role is not found."));
            roles.add(defaultRole);
        } else {
          
			switch (strRoles) {
			    case "admin":
			        Role adminRole = roleRepository.findByRoleName("ROLE_ADMIN")
			                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			        roles.add(adminRole);
			
			        break;
			    case "trainer":
			        Role trainerRole = roleRepository.findByRoleName("ROLE_TRAINER")
			                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			        roles.add(trainerRole);
			
			        break;
			        
			    case "coordinator":
			        Role coordinatorRole = roleRepository.findByRoleName("ROLE_COORDINATOR")
			                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			        roles.add(coordinatorRole);
			
			        break;
			}
           
        }
        
        user.setRoles(roles);
        userRepository.save(user);
        System.out.println(user.getRoles());
        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }

    @Override
    public UserInfoResponse getCurrentUserDetails(Authentication authentication) {
        UserDetailImpl userDetails = (UserDetailImpl) authentication.getPrincipal();

        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        UserInfoResponse response = new UserInfoResponse(userDetails.getId(),
                userDetails.getUsername(), roles);

        return response;
    }

    @Override
    public ResponseCookie logoutUser() {
        return jwtUtils.getCleanJwtCookie();
    }


}