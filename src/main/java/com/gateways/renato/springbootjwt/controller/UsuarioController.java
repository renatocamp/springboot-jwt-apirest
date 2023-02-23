package com.gateways.renato.springbootjwt.controller;

import com.gateways.renato.springbootjwt.models.Usuario;
import com.gateways.renato.springbootjwt.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/")
public class UsuarioController {

    private final UserService userService;

    public UsuarioController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all-users")
    public ResponseEntity<List<Usuario>> findAllUsers(){
        return ResponseEntity.status(200).body(userService.findAllUsers());
    }


    @GetMapping("/user/{id}")
    public ResponseEntity<?> findUserByid(@PathVariable Integer id){
        Optional<Usuario> userOptional = userService.findById(id);
        if(!userOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuário não foi encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(userOptional.get());
    }

    @PutMapping("/user/update/{id}")
    public ResponseEntity<?> userUpdate(@PathVariable Integer id, @RequestBody Usuario usuario){
        Optional<Usuario> userOptional = userService.findById(id);
        if (!userOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userOptional);
        }
        Usuario user = new Usuario();
        user.setNome(usuario.getNome());
        user.setPassword(usuario.getPassword());
        userService.save(usuario);
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        Optional<Usuario> optionalUsuario = userService.findById(id);
        if(!optionalUsuario.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O usuário não foi encontrado");
        }
        userService.delete(optionalUsuario.get());
        return ResponseEntity.status(HttpStatus.OK).body(optionalUsuario.get());
    }
}
