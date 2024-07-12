package com.example.aplicativo.model;

import javax.persistence.*;

@Entity
@Table(name = "delitos")
public class Delitos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String descripcion;
    private Long usuarios_id;

    // Constructores (vacío y con todos los campos)
    public Delitos() {
    }

    public Delitos(String nombre, String descripcion, Long usuarios_id) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.usuarios_id = usuarios_id;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getUsuarios_id() {
        return usuarios_id;
    }

    public void setUsuarios_id(Long usuarios_id) {
        this.usuarios_id = usuarios_id;
    }

    // Métodos opcionales: toString(), equals(), hashCode(), etc.
}
