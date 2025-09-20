package com.learn.classPortal.security;

import com.learn.classPortal.security.services.UserDetailServiceImpl;
import com.learn.classPortal.security.jwt.AuthEntryPointJwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.learn.classPortal.security.jwt.AuthTokenFilter;


@Configuration
@EnableWebSecurity
//@EnableMethodSecurity
public class WebSecurityConfig {

	@Autowired
    UserDetailServiceImpl userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }



    @SuppressWarnings("unused")
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .cors(cors -> cors.disable())
            .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth ->
                auth.requestMatchers(HttpMethod.POST,"/api/auth/signup").permitAll()
                    .requestMatchers(HttpMethod.POST,"/api/auth/signin").permitAll()
                    .requestMatchers("/api/dashboard/stats").permitAll()
                    .requestMatchers("/student").permitAll()
                    .requestMatchers("/trainer/*/batch").hasAnyRole("ADMIN","TRAINER")
                    .requestMatchers("/batch/*/event").hasAnyRole("ADMIN","TRAINER")
                    .requestMatchers("/batch/*/classRoom").hasAnyRole("ADMIN","TRAINER")
                    .requestMatchers("/batch/*/slot").hasAnyRole("ADMIN","TRAINER")
                    .requestMatchers("/batch/*/student").hasAnyRole("ADMIN","TRAINER")
                    .requestMatchers("/coordinator/*/batch").hasAnyRole("ADMIN","COORDINATOR")
                    .requestMatchers("/batch/**").hasRole("ADMIN")
                    .requestMatchers("/event/**").hasAnyRole("ADMIN")
                    .requestMatchers("/slot/**").hasAnyRole("ADMIN","TRAINER","COORDINATOR")
                    .requestMatchers("/classRoom/**").hasAnyRole("ADMIN","TRAINER","COORDINATOR")
                    .requestMatchers(HttpMethod.POST,"/student/**").hasAnyRole("ADMIN","COORDINATOR")
                    .requestMatchers(HttpMethod.POST,"/batch").hasAnyRole("ADMIN","COORDINATOR")
                    .requestMatchers(HttpMethod.POST,"/event").hasAnyRole("ADMIN","COORDINATOR")
                    .requestMatchers(HttpMethod.POST,"/slot").hasAnyRole("ADMIN","COORDINATOR")
                    .requestMatchers(HttpMethod.POST,"/classRoom").hasAnyRole("ADMIN","COORDINATOR")
                    .requestMatchers(HttpMethod.PUT,"/coordinator/*/batch").hasAnyRole("ADMIN","COORDINATOR")
                    .requestMatchers(HttpMethod.PUT,"/coordinator/*","/trainer/*").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.POST,"/coordinator","/trainer").hasRole("ADMIN")
                    .requestMatchers(HttpMethod.DELETE,"/student/*","/event/*","/slot/*","/classRoom/*").hasAnyRole("ADMIN","COORDINATOR")
                    .requestMatchers(HttpMethod.DELETE,"/coordinator/*","/batch/*","/trainer/*").hasRole("ADMIN")
                    .anyRequest().authenticated()
            );

        http.authenticationProvider(authenticationProvider());

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        http.headers(headers -> headers.frameOptions(
                frameOptions -> frameOptions.sameOrigin()));

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web -> web.ignoring().requestMatchers("/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**"));
    }


    

}