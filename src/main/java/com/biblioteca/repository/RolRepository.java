package com.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.entity.Rol;

public interface RolRepository extends JpaRepository<Rol, Long> {

    // para buscar roles por nombre
    Rol findByNombre(String nombre);
}
