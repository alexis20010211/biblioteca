package com.biblioteca.service.impl;

import java.util.Date;
import java.util.Optional;

import javax.crypto.SecretKey;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.biblioteca.entity.Usuario;
import com.biblioteca.repository.UsuarioRepository;
import com.biblioteca.service.AuthService;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;

@Service
public class AuthServiceImpl implements AuthService {

    private final UsuarioRepository usuarioRepository;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Cambia por algo más seguro y largo en producción
    private final String SECRET_KEY = "miClaveSecreta12345678901234567890"; 

    // Creamos la clave JWT a partir de la cadena
    private final SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    public AuthServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Optional<Usuario> login(String email, String password) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);

        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();

            // Compara la contraseña ingresada con el hash guardado
            if (passwordEncoder.matches(password, usuario.getPassword())) {
                return Optional.of(usuario);
            }
        }
        return Optional.empty();
    }

    @Override
    public Usuario registrar(Usuario usuario) {
        // Encripta la contraseña antes de guardar
        String hashedPassword = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(hashedPassword);

        return usuarioRepository.save(usuario);
    }

    @Override
    public boolean validarToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
            return true; // token válido
        } catch (ExpiredJwtException | MalformedJwtException | SignatureException e) {
            return false; // token inválido
        }
    }

    // Método adicional: generar JWT seguro
    public String generarToken(Usuario usuario) {
        return Jwts.builder()
                .setSubject(usuario.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hora
                .signWith(key) // ya no deprecated
                .compact();
    }
}
