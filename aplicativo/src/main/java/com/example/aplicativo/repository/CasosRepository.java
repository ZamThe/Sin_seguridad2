package com.example.aplicativo.repository;

import com.example.aplicativo.model.Casos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasosRepository extends JpaRepository<Casos, Long> {
    // Aquí puedes añadir métodos personalizados de consulta si es necesario
}
