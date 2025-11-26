package com.biblioteca.service.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.biblioteca.entity.Prestamo;
import com.biblioteca.repository.PrestamoRepository;
import com.biblioteca.service.PrestamoService;

@Service
public class PrestamoServiceImpl implements PrestamoService {

    private final PrestamoRepository prestamoRepository;

    public PrestamoServiceImpl(PrestamoRepository prestamoRepository) {
        this.prestamoRepository = prestamoRepository;
    }

    // Crea un nuevo prestamo
    @Override
    public Prestamo crearPrestamo(Prestamo prestamo) {
        Objects.requireNonNull(prestamo, "El prestamo no puede ser null");
        prestamo.setEstado("Activo"); // Marca el prestamo como activo al crearlo
        return prestamoRepository.save(prestamo);
    }

    // Actualiza un prestamo existente por ID
    @Override
    public Prestamo actualizarPrestamo(Long id, Prestamo prestamo) {
        Objects.requireNonNull(id, "El ID no puede ser null");
        Objects.requireNonNull(prestamo, "El prestamo no puede ser null");

        Prestamo existente = prestamoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Prestamo no encontrado con ID: " + id));

        // Actualizar campos
        existente.setFechaDevolucion(prestamo.getFechaDevolucion());
        existente.setLibro(prestamo.getLibro());
        existente.setUsuario(prestamo.getUsuario());
        existente.setEstado(prestamo.getEstado()); // Actualiza estado si aplica

        return prestamoRepository.save(existente);
    }

    // Elimina un prestamo por ID
    @Override
    public void eliminarPrestamo(Long id) {
        Objects.requireNonNull(id, "El ID no puede ser null");

        if (!prestamoRepository.existsById(id)) {
            throw new IllegalArgumentException("Prestamo no encontrado con ID: " + id);
        }
        prestamoRepository.deleteById(id);
    }

    // Marca un prestamo como devuelto
    @Override
    public Prestamo devolverLibro(Long id) {
        Objects.requireNonNull(id, "El ID no puede ser null");

        Prestamo prestamo = prestamoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Prestamo no encontrado con ID: " + id));
        prestamo.setEstado("Devuelto"); // Cambia el estado a devuelto
        return prestamoRepository.save(prestamo);
    }

    // Obtiene un prestamo por ID
    @Override
    public Prestamo obtenerPorId(Long id) {
        Objects.requireNonNull(id, "El ID no puede ser null");

        return prestamoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Prestamo no encontrado con ID: " + id));
    }

    // Lista todos los prestamos
    @Override
    public List<Prestamo> listarPrestamos() {
        return prestamoRepository.findAll();
    }
}
