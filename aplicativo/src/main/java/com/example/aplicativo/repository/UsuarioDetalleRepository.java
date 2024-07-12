package com.example.aplicativo.repository;

import com.example.aplicativo.model.UsuarioDetalle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDetalleRepository extends JpaRepository<UsuarioDetalle, Long> {
    // Aquí puedes añadir métodos personalizados de consulta si los necesitas
}
