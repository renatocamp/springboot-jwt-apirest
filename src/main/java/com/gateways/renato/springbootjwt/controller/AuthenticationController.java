package com.gateways.renato.springbootjwt.controller;


import com.gateways.renato.springbootjwt.dtos.AuthenticationRequest;
import com.gateways.renato.springbootjwt.dtos.AuthenticationResponse;
import com.gateways.renato.springbootjwt.dtos.RegisterRequest;
import com.gateways.renato.springbootjwt.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/regitrar")
    public ResponseEntity<AuthenticationResponse> register (@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> register (@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }
}
