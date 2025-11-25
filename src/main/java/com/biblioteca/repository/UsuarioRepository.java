package com.biblioteca.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.entity.Usuario;

// acá buscamos usuarios y manejamos lógica básica
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // para login / validaciones
    Optional<Usuario> findByEmail(String email);
}
