package com.biblioteca.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.biblioteca.entity.Usuario;
import com.biblioteca.repository.UsuarioRepository;
import com.biblioteca.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    // Registra un nuevo usuario en la base de datos
    @Override
    public Usuario registrar(Usuario usuario) {
        Objects.requireNonNull(usuario, "Usuario no puede ser null");
        return usuarioRepository.save(usuario);
    }

    // Actualiza los datos de un usuario existente
    @Override
    public Usuario actualizar(Long id, Usuario usuario) {
        Objects.requireNonNull(id, "ID no puede ser null");
        Objects.requireNonNull(usuario, "Usuario no puede ser null");

        Usuario existente = usuarioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado con ID: " + id));

        existente.setNombre(usuario.getNombre());
        existente.setEmail(usuario.getEmail());
        existente.setPassword(usuario.getPassword());
        // Quitar o agregar si manejas roles
        // existente.setRol(usuario.getRol()); 

        return usuarioRepository.save(existente);
    }

    // Elimina un usuario por su ID
    @Override
    public void eliminar(Long id) {
        Objects.requireNonNull(id, "ID no puede ser null");

        if (!usuarioRepository.existsById(id)) {
            throw new IllegalArgumentException("Usuario no encontrado con ID: " + id);
        }
        usuarioRepository.deleteById(id);
    }

    // Busca un usuario por su ID
    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        Objects.requireNonNull(id, "ID no puede ser null");
        return usuarioRepository.findById(id);
    }

    // Busca un usuario por su email
    @Override
    public Optional<Usuario> buscarPorEmail(String email) {
        Objects.requireNonNull(email, "Email no puede ser null");
        return usuarioRepository.findByEmail(email);
    }

    // Lista todos los usuarios registrados
    @Override
    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }
}
