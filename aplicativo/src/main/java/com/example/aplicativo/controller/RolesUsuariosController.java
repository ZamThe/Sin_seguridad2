package com.example.aplicativo.controller;

import com.example.aplicativo.model.RolesUsuarios;
import com.example.aplicativo.repository.RolesUsuariosRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles-usuarios")
public class RolesUsuariosController {

    private final RolesUsuariosRepository rolesUsuariosRepository;

    public RolesUsuariosController(RolesUsuariosRepository rolesUsuariosRepository) {
        this.rolesUsuariosRepository = rolesUsuariosRepository;
    }

    // Obtener todas las asignaciones roles-usuarios
    @GetMapping
    public ResponseEntity<List<RolesUsuarios>> getAllRolesUsuarios() {
        List<RolesUsuarios> rolesUsuarios = rolesUsuariosRepository.findAll();
        return new ResponseEntity<>(rolesUsuarios, HttpStatus.OK);
    }

    // Crear una nueva asignación roles-usuarios
    @PostMapping
    public ResponseEntity<RolesUsuarios> createRolesUsuarios(@RequestBody RolesUsuarios rolesUsuarios) {
        try {
            RolesUsuarios nuevaAsignacion = rolesUsuariosRepository.save(rolesUsuarios);
            return new ResponseEntity<>(nuevaAsignacion, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener una asignación roles-usuarios por ID
    @GetMapping("/{id}")
    public ResponseEntity<RolesUsuarios> getRolesUsuariosById(@PathVariable("id") Long id) {
        Optional<RolesUsuarios> rolesUsuariosData = rolesUsuariosRepository.findById(id);

        return rolesUsuariosData.map(rolesUsuarios -> new ResponseEntity<>(rolesUsuarios, HttpStatus.OK))
                                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Actualizar una asignación roles-usuarios por ID
    @PutMapping("/{id}")
    public ResponseEntity<RolesUsuarios> updateRolesUsuarios(@PathVariable("id") Long id, @RequestBody RolesUsuarios rolesUsuarios) {
        Optional<RolesUsuarios> rolesUsuariosData = rolesUsuariosRepository.findById(id);

        if (rolesUsuariosData.isPresent()) {
            RolesUsuarios _rolesUsuarios = rolesUsuariosData.get();
            _rolesUsuarios.setRol(rolesUsuarios.getRol());
            _rolesUsuarios.setUsuario(rolesUsuarios.getUsuario());

            return new ResponseEntity<>(rolesUsuariosRepository.save(_rolesUsuarios), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar una asignación roles-usuarios por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteRolesUsuarios(@PathVariable("id") Long id) {
        try {
            rolesUsuariosRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
