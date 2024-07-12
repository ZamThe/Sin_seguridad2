package com.example.aplicativo.repository;

import com.example.aplicativo.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {
    // Aquí puedes añadir métodos personalizados de consulta si los necesitas
}
