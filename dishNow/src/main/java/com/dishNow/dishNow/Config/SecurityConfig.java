package com.dishNow.dishNow.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@ComponentScan
@Configuration
@EnableWebSecurity
public class SecurityConfig {
        private static final String[] BLACK_LIST_URL = {
                "/api/user/remove/*",
                "/api/user/update/*",
                "/api/user/add/**",
                "/api/user/get/*",
                
                "/api/ingredient/remove/*",
                "/api/ingredient/update/*",
                "/api/ingredient/add/**",
                
                "/api/category/remove/*",
                "/api/category/update/*",
                "/api/category/add/**",
                
                "/api/recipe/remove/*",
                "/api/recipe/update/*",
                "/api/recipe/add/**",
                
                "/api/verify/*",
        };

        @Autowired
        private JwtAuthenticationFilter jwtFilter;

        @Bean
        public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                http.csrf(csrf -> csrf.disable())
                        .headers(headers -> headers.frameOptions(frame -> frame.disable()))
                        .authorizeHttpRequests(auth -> auth
                                        .requestMatchers(BLACK_LIST_URL)
                                        .authenticated()
                                        .anyRequest().permitAll())
                        .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
                return http.build();
        }

}
