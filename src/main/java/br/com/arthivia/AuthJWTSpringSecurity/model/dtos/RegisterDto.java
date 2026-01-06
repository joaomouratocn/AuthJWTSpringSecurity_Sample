package br.com.arthivia.AuthJWTSpringSecurity.model.dtos;

import br.com.arthivia.AuthJWTSpringSecurity.Util.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterDto(
        @NotNull
        @NotBlank
        String login,
        @NotNull
        @NotBlank
        String password,
        @NotNull
        UserRole role
) {}
