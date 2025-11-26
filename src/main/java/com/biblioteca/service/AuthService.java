package com.biblioteca.service;

import java.util.Optional;

import com.biblioteca.entity.Usuario;

public interface AuthService {

    // login devuelve el usuario si coincide email y contraseña
    Optional<Usuario> login(String email, String password);

    // registrar un nuevo usuario
    Usuario registrar(Usuario usuario);

    // validación simple para luego añadir JWT
    boolean validarToken(String token);
}
