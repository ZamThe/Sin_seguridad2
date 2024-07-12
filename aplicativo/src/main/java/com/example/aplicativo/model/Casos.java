package com.example.aplicativo.model;

import javax.persistence.*;

@Entity
@Table(name = "casos")
public class Casos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String fecha_hora;
    private Double latitud;
    private Double longitud;
    private Double altitud;
    private Boolean visible;
    private String descripcion;
    private String url_map;
    private String rmi_url;
    private Long usuarios_id;
    private Long delitos_id;

    // Constructor vacío (necesario para JPA)
    public Casos() {
    }

    // Getters y Setters para todos los campos
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha_hora() {
        return fecha_hora;
    }

    public void setFecha_hora(String fecha_hora) {
        this.fecha_hora = fecha_hora;
    }

    public Double getLatitud() {
        return latitud;
    }

    public void setLatitud(Double latitud) {
        this.latitud = latitud;
    }

    public Double getLongitud() {
        return longitud;
    }

    public void setLongitud(Double longitud) {
        this.longitud = longitud;
    }

    public Double getAltitud() {
        return altitud;
    }

    public void setAltitud(Double altitud) {
        this.altitud = altitud;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrl_map() {
        return url_map;
    }

    public void setUrl_map(String url_map) {
        this.url_map = url_map;
    }

    public String getRmi_url() {
        return rmi_url;
    }

    public void setRmi_url(String rmi_url) {
        this.rmi_url = rmi_url;
    }

    public Long getUsuarios_id() {
        return usuarios_id;
    }

    public void setUsuarios_id(Long usuarios_id) {
        this.usuarios_id = usuarios_id;
    }

    public Long getDelitos_id() {
        return delitos_id;
    }

    public void setDelitos_id(Long delitos_id) {
        this.delitos_id = delitos_id;
    }

    // Métodos opcionales como toString(), equals(), hashCode(), etc.
    
}
