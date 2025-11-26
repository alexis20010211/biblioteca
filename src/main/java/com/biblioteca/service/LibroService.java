package com.biblioteca.service;
import java.util.List;

import com.biblioteca.entity.Libro;

// Servicio para manejar todo lo relacionado a libros
public interface LibroService {

    // Crear o registrar un libro
    void crearLibro(Libro libro);

    // Buscar libro por ID
    Libro obtenerPorId(Long id);

    // Listar todos los libros
    List<Libro> listarLibros();

    // Actualizar información del libro
    Libro actualizarLibro(Long id, Libro libro);

    // Eliminar libro
    void eliminarLibro(Long id);
}
