package com.gateways.renato.springbootjwt.service;


import com.gateways.renato.springbootjwt.dtos.AuthenticationRequest;
import com.gateways.renato.springbootjwt.dtos.AuthenticationResponse;
import com.gateways.renato.springbootjwt.dtos.RegisterRequest;
import com.gateways.renato.springbootjwt.enums.Roles;
import com.gateways.renato.springbootjwt.models.Usuario;
import com.gateways.renato.springbootjwt.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;

    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest request) {
        var user = Usuario.builder()
                .nome(request.getNome())
                .sobrenome(request.getSobrenome())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(Roles.USER)
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
