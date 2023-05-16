package com.example.backendapp.controller;

import com.example.backendapp.model.user.Role;
import com.example.backendapp.service.AuthenticationService;
import com.example.backendapp.security.requests.AuthenticationRequest;
import com.example.backendapp.security.requests.RegisterRequest;
import com.example.backendapp.security.responses.AuthenticationResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController
{
    @Autowired
    private final AuthenticationService authService;

    @PostMapping("/passenger/register")
    public ResponseEntity<AuthenticationResponse> registerPassenger(@RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(authService.registerUser(request, Role.USER));
    }

    @PostMapping("/ticket-collector/register")
    public ResponseEntity<AuthenticationResponse> registerTicketCollector(@RequestBody RegisterRequest request)
    {
        return ResponseEntity.ok(authService.registerUser(request, Role.TICKET_COLLECTOR));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request)
    {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
