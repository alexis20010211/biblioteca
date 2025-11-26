package com.biblioteca.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.biblioteca.entity.Libro;
import com.biblioteca.repository.LibroRepository;
import com.biblioteca.service.LibroService;

@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;

    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    // Crea un nuevo libro
    @Override
    public void crearLibro(Libro libro) {
        if (libro == null) {
            throw new IllegalArgumentException("El libro no puede ser null");
        }
        libroRepository.save(libro);
    }

    // Obtiene un libro por su ID
    @Override
    public Libro obtenerPorId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser null");
        }
        return libroRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Libro no encontrado con ID: " + id));
    }

    // Lista todos los libros
    @Override
    public List<Libro> listarLibros() {
        return libroRepository.findAll();
    }

    // Actualiza un libro existente
    @Override
    public Libro actualizarLibro(Long id, Libro libro) {
        if (id == null || libro == null) {
            throw new IllegalArgumentException("ID o libro inválido");
        }

        Libro existente = libroRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Libro no encontrado con ID: " + id));

        // Actualizar campos
        existente.setTitulo(libro.getTitulo());
        existente.setAutor(libro.getAutor());
        existente.setCategoria(libro.getCategoria());
        existente.setDisponible(libro.isDisponible());

        return libroRepository.save(existente);
    }

    // Elimina un libro por su ID
    @Override
    public void eliminarLibro(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser null");
        }
        if (!libroRepository.existsById(id)) {
            throw new IllegalArgumentException("Libro no encontrado con ID: " + id);
        }
        libroRepository.deleteById(id);
    }
}
