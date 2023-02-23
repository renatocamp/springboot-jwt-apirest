package com.gateways.renato.springbootjwt.dtos;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterRequest {

    private String nome;
    private String sobrenome;
    private String password;
    private String email;
}
