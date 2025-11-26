package com.biblioteca.service;

import java.util.List;
import java.util.Optional;

import com.biblioteca.entity.Usuario;

// acá solo definimos lo que el servicio debe hacer
public interface UsuarioService {

    Usuario registrar(Usuario usuario);

    Optional<Usuario> buscarPorId(Long id);

    Optional<Usuario> buscarPorEmail(String email);

    List<Usuario> listar();

    Usuario actualizar(Long id, Usuario usuarioActualizado);

    void eliminar(Long id);
}
