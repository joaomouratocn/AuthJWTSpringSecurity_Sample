package br.com.arthivia.AuthJWTSpringSecurity.model.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record LoginDto(
        @NotNull
        @NotBlank
        String login,
        @NotNull
        @NotBlank
        String password
) {}
