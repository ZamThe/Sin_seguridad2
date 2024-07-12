package com.example.aplicativo.controller;

import com.example.aplicativo.model.Roles;
import com.example.aplicativo.repository.RolesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RolesController {

    private final RolesRepository rolesRepository;

    public RolesController(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    // Obtener todos los roles
    @GetMapping
    public ResponseEntity<List<Roles>> getAllRoles() {
        List<Roles> roles = rolesRepository.findAll();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }

    // Crear un nuevo rol
    @PostMapping
    public ResponseEntity<Roles> createRol(@RequestBody Roles rol) {
        try {
            Roles nuevoRol = rolesRepository.save(rol);
            return new ResponseEntity<>(nuevoRol, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener un rol por ID
    @GetMapping("/{id}")
    public ResponseEntity<Roles> getRolById(@PathVariable("id") Long id) {
        Optional<Roles> rolData = rolesRepository.findById(id);

        return rolData.map(rol -> new ResponseEntity<>(rol, HttpStatus.OK))
                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Actualizar un rol por ID
    @PutMapping("/{id}")
    public ResponseEntity<Roles> updateRol(@PathVariable("id") Long id, @RequestBody Roles rol) {
        Optional<Roles> rolData = rolesRepository.findById(id);

        if (rolData.isPresent()) {
            Roles _rol = rolData.get();
            _rol.setNombre(rol.getNombre());
            _rol.setDescripcion(rol.getDescripcion());

            return new ResponseEntity<>(rolesRepository.save(_rol), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un rol por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteRol(@PathVariable("id") Long id) {
        try {
            rolesRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
