package com.example.backendapp.controller.api;

import com.example.backendapp.model.user.Role;
import com.example.backendapp.service.AuthenticationService;
import com.example.backendapp.controller.request.AuthenticationRequest;
import com.example.backendapp.controller.request.RegisterRequest;
import com.example.backendapp.controller.response.AuthenticationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
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

    @Operation(summary = "register new passenger")
    @PostMapping("/passenger/register")
    public ResponseEntity<AuthenticationResponse> registerPassenger(@RequestBody @Valid RegisterRequest request)
    {
        return ResponseEntity.ok(authService.registerUser(request, Role.USER));
    }

    @Operation(summary = "register new ticket collector. Only authenticated ticket collector can do it")
    @SecurityRequirement(name = "Barer Authentication")
    @PostMapping("/ticket-collector/register")
    public ResponseEntity<AuthenticationResponse> registerTicketCollector(@RequestBody @Valid RegisterRequest request)
    {
        return ResponseEntity.ok(authService.registerUser(request, Role.TICKET_COLLECTOR));
    }

    @Operation(summary = "authenticate user")
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody @Valid AuthenticationRequest request)
    {
        return ResponseEntity.ok(authService.authenticate(request));
    }
}
