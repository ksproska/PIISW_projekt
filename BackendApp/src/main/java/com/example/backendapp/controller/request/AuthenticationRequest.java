package com.example.backendapp.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationRequest
{
    @NotBlank
    @Schema(example = "Franciszek")
    private String username;

    @NotBlank
    @Schema(example = "Admin123!")
    private String password;
}
