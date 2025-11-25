package com.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.entity.Prestamo;

// aquí va la tabla préstamo
public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

}
