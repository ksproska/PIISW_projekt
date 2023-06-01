package com.example.backendapp.service;

import com.example.backendapp.model.user.Passenger;
import com.example.backendapp.model.user.Role;
import com.example.backendapp.model.user.TicketCollector;
import com.example.backendapp.repository.UserRepository;
import com.example.backendapp.controller.request.AuthenticationRequest;
import com.example.backendapp.controller.request.RegisterRequest;
import com.example.backendapp.controller.response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService
{
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Autowired
    private final JwtService jwtService;

    @Autowired
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse registerUser(RegisterRequest request, Role role)
    {
        var userDetails = User.builder()
            .username(request.getUsername())
            .password(passwordEncoder.encode(request.getPassword()))
            .roles(role.toString())
            .build();

        var user = role == Role.TICKET_COLLECTOR ? new TicketCollector() : new Passenger();
        user.setPassword(userDetails.getPassword());
        user.setUsername(userDetails.getUsername());
        user.setRole(role);

        userRepository.save(user);
        var jwtToken = jwtService.generateToken(userDetails);
        return AuthenticationResponse.builder().token(jwtToken).userId(user.getId()).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request)
    {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var userDetails = userRepository.findByUsername(request.getUsername()).orElseThrow();
        var jwtToken = jwtService.generateToken(userDetails);
        return AuthenticationResponse.builder().token(jwtToken).userId(userDetails.getId()).build();
    }
}
