package com.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.entity.Libro;

// acá manejamos todo lo relacionado a tabla libro
public interface LibroRepository extends JpaRepository<Libro, Long> {

}
