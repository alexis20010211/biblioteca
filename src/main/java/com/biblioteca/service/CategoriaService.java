package com.biblioteca.service;

import java.util.List;
import java.util.Optional;

import com.biblioteca.entity.Categoria;

public interface CategoriaService {

    // Crea una nueva categoría y la guarda en la base de datos
    Categoria crearCategoria(Categoria categoria);

    // Obtiene una categoría por su ID, puede no existir
    Optional<Categoria> obtenerCategoria(Long id);

    // Devuelve la lista completa de categorías registradas
    List<Categoria> listarCategorias();

    // Actualiza una categoría existente identificada por su ID
    Categoria actualizarCategoria(Long id, Categoria categoria);

    // Elimina una categoría según su ID
    void eliminarCategoria(Long id);
}
