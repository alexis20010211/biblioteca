package com.biblioteca.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.biblioteca.entity.Categoria;
import com.biblioteca.repository.CategoriaRepository;
import com.biblioteca.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // Crear una nueva categoria
    @Override
    public Categoria crearCategoria(Categoria categoria) {
        if (categoria == null) {
            throw new IllegalArgumentException("La categoria no puede ser null");
        }
        return categoriaRepository.save(categoria);
    }

    // Obtener una categoria por ID
    @Override
    public Optional<Categoria> obtenerCategoria(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser null");
        }
        return categoriaRepository.findById(id);
    }

    // Listar todas las categorias
    @Override
    public List<Categoria> listarCategorias() {
        return categoriaRepository.findAll();
    }

    // Actualizar una categoria existente
    @Override
    public Categoria actualizarCategoria(Long id, Categoria categoria) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser null");
        }
        if (categoria == null) {
            throw new IllegalArgumentException("La categoria no puede ser null");
        }

        Categoria existente = obtenerCategoria(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoria no encontrada con ID: " + id));

        existente.setNombre(categoria.getNombre()); // Actualizar nombre
        return categoriaRepository.save(existente);
    }

    // Eliminar una categoria por ID
    @Override
    public void eliminarCategoria(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser null");
        }
        if (!categoriaRepository.existsById(id)) {
            throw new IllegalArgumentException("Categoria no encontrada con ID: " + id);
        }
        categoriaRepository.deleteById(id);
    }
} 
