package com.example.aplicativo.repository;

import com.example.aplicativo.model.Delitos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DelitosRepository extends JpaRepository<Delitos, Long> {
}
