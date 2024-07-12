package com.example.aplicativo.model;

import javax.persistence.*;

@Entity
@Table(name = "roles_usuarios")
public class RolesUsuarios {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "roles_id")
    private Roles rol;

    @ManyToOne
    @JoinColumn(name = "usuarios_id")
    private Usuarios usuario;

    // Constructores, getters y setters (generados automáticamente o manualmente)

    public RolesUsuarios() {
    }

    public RolesUsuarios(Roles rol, Usuarios usuario) {
        this.rol = rol;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Roles getRol() {
        return rol;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}
