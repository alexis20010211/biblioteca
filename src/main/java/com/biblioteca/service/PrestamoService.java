package com.biblioteca.service;

import java.util.List;

import com.biblioteca.entity.Prestamo;

public interface PrestamoService {

    // Crea un nuevo préstamo y lo guarda en la base de datos
    Prestamo crearPrestamo(Prestamo prestamo);

    // Actualiza un préstamo existente identificado por su ID
    Prestamo actualizarPrestamo(Long id, Prestamo prestamo);

    // Elimina un préstamo de la base de datos según su ID
    void eliminarPrestamo(Long id);

    // Marca un préstamo como devuelto y actualiza su estado
    Prestamo devolverLibro(Long id);

    // Obtiene un préstamo por su ID, lanza excepción si no existe
    Prestamo obtenerPorId(Long id);

    // Devuelve la lista completa de préstamos registrados
    List<Prestamo> listarPrestamos();
}
