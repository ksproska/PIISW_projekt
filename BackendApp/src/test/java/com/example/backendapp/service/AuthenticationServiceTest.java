package com.example.backendapp.service;

import com.example.backendapp.model.user.Role;
import com.example.backendapp.repository.UserRepository;
import com.example.backendapp.security.JwtService;
import com.example.backendapp.security.requests.RegisterRequest;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@DataJpaTest
@AutoConfigureTestDatabase
@TestPropertySource("classpath:test.properties")
public class AuthenticationServiceTest
{
    @InjectMocks
    private AuthenticationService authenticationService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @Mock
    private JwtService jwtService;

    @Mock
    private AuthenticationManager authenticationManager;

    @Test
    void shouldCreateNewPassenger()
    {
        // given
        var username = "frodoBaggins@gmail.com";
        var password = "gandalf123!";
        var role = Role.USER;
        var request = new RegisterRequest(username, password);
        var userDetails = User.builder()
            .username(request.getUsername())
            .password(new BCryptPasswordEncoder().encode(password))
            .roles(role.toString())
            .build();

        // when
        when(passwordEncoder.encode(password)).thenReturn(new BCryptPasswordEncoder().encode(password));
        when(jwtService.generateToken(userDetails)).thenReturn(new JwtService().generateToken(userDetails));
        var response = authenticationService.registerUser(request, role);

        // then
        assertNotNull(response);
        assertInstanceOf(String.class, response.getToken());
        //assertEquals(username, jwtService.extractUsername(response.getToken())); TODO mock extractUsername
    }

    @Test
    void shouldCreateNewTicketCollector()
    {
        // given
        var username = "bilboBaggins@gmail.com";
        var password = "epickaPrzygoda!";
        var role = Role.TICKET_COLLECTOR;
        var request = new RegisterRequest(username, password);
        var userDetails = User.builder()
                .username(request.getUsername())
                .password(new BCryptPasswordEncoder().encode(password))
                .roles(role.toString())
                .build();

        // when
        when(passwordEncoder.encode(password)).thenReturn(new BCryptPasswordEncoder().encode(password));
        when(jwtService.generateToken(userDetails)).thenReturn(new JwtService().generateToken(userDetails));
        var response = authenticationService.registerUser(request, role);

        // then
        assertNotNull(response);
        assertInstanceOf(String.class, response.getToken());
        //assertEquals(username, jwtService.extractUsername(response.getToken())); TODO mock extractUsername
    }
}
