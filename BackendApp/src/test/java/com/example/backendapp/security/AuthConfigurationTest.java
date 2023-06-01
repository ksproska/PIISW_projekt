package com.example.backendapp.security;

import com.example.backendapp.config.AuthConfiguration;
import com.example.backendapp.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AuthConfigurationTest {

    private AuthConfiguration authConfiguration;

    @Mock
    private UserService userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        authConfiguration = new AuthConfiguration(userService);
    }

    @Test
    public void testUserDetailsService() {
        UserDetailsService userDetailsService = authConfiguration.userDetailsService();

        assertNotNull(userDetailsService);
    }

    @Test
    public void testAuthenticationProvider() {
        AuthenticationProvider authenticationProvider = authConfiguration.authenticationProvider();

        assertNotNull(authenticationProvider);
    }

    @Test
    public void testPasswordEncoder() {
        PasswordEncoder passwordEncoder = authConfiguration.passwordEncoder();

        assertNotNull(passwordEncoder);
    }
}
