package br.com.arthivia.AuthJWTSpringSecurity.service;

import br.com.arthivia.AuthJWTSpringSecurity.infra.security.TokenService;
import br.com.arthivia.AuthJWTSpringSecurity.model.dtos.AuthResponseDto;
import br.com.arthivia.AuthJWTSpringSecurity.model.dtos.LoginDto;
import br.com.arthivia.AuthJWTSpringSecurity.model.dtos.RegisterDto;
import br.com.arthivia.AuthJWTSpringSecurity.model.entity.UserEntity;
import br.com.arthivia.AuthJWTSpringSecurity.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    private TokenService tokenService;

    public AuthResponseDto authenticate(LoginDto loginDto) {
        var userNamePasswordToken = new UsernamePasswordAuthenticationToken(loginDto.login(), loginDto.password());
        var authentication = authenticationManager.authenticate(userNamePasswordToken);

        var token = tokenService.generateToken((UserEntity) authentication.getPrincipal());

        return new AuthResponseDto(authentication.getName(), token);
    }

    public String registerUser(@RequestBody @Valid RegisterDto registerDto) {
        if (userRepository.findByLogin(registerDto.login()) != null) {
            return "User already exists";
        }

        var passHash = new BCryptPasswordEncoder().encode(registerDto.password());
        var newUser = new UserEntity(registerDto.login(), passHash, registerDto.role());
        userRepository.save(newUser);

        return "User registered successfully";
    }
}
