package com.biblioteca.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // nombre del libro
    private String titulo;
    // autor principal
    private String autor;

    // pequeño texto sobre el libro
    private String descripcion;
    // cantidad que quedan en biblioteca
    private int stock;
    public Libro() {
        // constructor vacío
    }
    public Libro(String titulo, String autor, String descripcion, int stock) {
        this.titulo = titulo;
        this.autor = autor;
        this.descripcion = descripcion;
        this.stock = stock;
    }
    // getters y setters
    public Long getId() {
        return id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
}
