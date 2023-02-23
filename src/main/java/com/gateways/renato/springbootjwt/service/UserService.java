package com.gateways.renato.springbootjwt.service;

import com.gateways.renato.springbootjwt.models.Usuario;
import com.gateways.renato.springbootjwt.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> findAllUsers() {
       return repository.findAll();
    }

    public Optional<Usuario> findById(Integer id) {
        return repository.findById(id);
    }

    public void delete(Usuario usuario) {
        repository.delete(usuario);
    }

    public void save(Usuario usuario) {
        repository.save(usuario);
    }
}
