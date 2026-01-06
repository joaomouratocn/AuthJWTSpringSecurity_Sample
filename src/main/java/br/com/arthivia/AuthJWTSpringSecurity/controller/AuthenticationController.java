package br.com.arthivia.AuthJWTSpringSecurity.controller;

import br.com.arthivia.AuthJWTSpringSecurity.model.dtos.AuthResponseDto;
import br.com.arthivia.AuthJWTSpringSecurity.model.dtos.LoginDto;
import br.com.arthivia.AuthJWTSpringSecurity.model.dtos.RegisterDto;
import br.com.arthivia.AuthJWTSpringSecurity.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody @Valid LoginDto loginDto) {
        var result = userService.authenticate(loginDto);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid RegisterDto registerDto) {
        var result = userService.registerUser(registerDto);
        return ResponseEntity.ok(result);
    }
}