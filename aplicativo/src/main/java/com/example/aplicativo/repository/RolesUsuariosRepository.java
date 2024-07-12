package com.example.aplicativo.repository;

import com.example.aplicativo.model.RolesUsuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolesUsuariosRepository extends JpaRepository<RolesUsuarios, Long> {
}
