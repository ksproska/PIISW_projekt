package com.example.backendapp.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest
{
    @Email
    @NotBlank
    @Schema(example = "stanislaw@o2.pl")
    private String username;

    @NotBlank
    @Schema(example = "Izabela123!")
    private String password;
}
