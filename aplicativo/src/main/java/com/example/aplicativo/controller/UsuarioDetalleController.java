package com.example.aplicativo.controller;

import com.example.aplicativo.model.UsuarioDetalle;
import com.example.aplicativo.repository.UsuarioDetalleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios-detalle")
public class UsuarioDetalleController {

    private final UsuarioDetalleRepository usuarioDetalleRepository;

    public UsuarioDetalleController(UsuarioDetalleRepository usuarioDetalleRepository) {
        this.usuarioDetalleRepository = usuarioDetalleRepository;
    }

    // Endpoint para obtener todos los usuarios detalle
    @GetMapping
    public ResponseEntity<List<UsuarioDetalle>> getAllUsuariosDetalle() {
        List<UsuarioDetalle> usuariosDetalle = usuarioDetalleRepository.findAll();
        return new ResponseEntity<>(usuariosDetalle, HttpStatus.OK);
    }

    // Endpoint para crear un nuevo usuario detalle
    @PostMapping
    public ResponseEntity<UsuarioDetalle> createUsuarioDetalle(@RequestBody UsuarioDetalle usuarioDetalle) {
        try {
            UsuarioDetalle nuevoUsuarioDetalle = usuarioDetalleRepository.save(usuarioDetalle);
            return new ResponseEntity<>(nuevoUsuarioDetalle, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint para obtener un usuario detalle por ID
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDetalle> getUsuarioDetalleById(@PathVariable("id") Long id) {
        Optional<UsuarioDetalle> usuarioDetalleData = usuarioDetalleRepository.findById(id);

        return usuarioDetalleData.map(usuarioDetalle -> new ResponseEntity<>(usuarioDetalle, HttpStatus.OK))
                                 .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint para actualizar un usuario detalle por ID
    @PutMapping("/{id}")
    public ResponseEntity<UsuarioDetalle> updateUsuarioDetalle(@PathVariable("id") Long id, @RequestBody UsuarioDetalle usuarioDetalle) {
        Optional<UsuarioDetalle> usuarioDetalleData = usuarioDetalleRepository.findById(id);

        if (usuarioDetalleData.isPresent()) {
            UsuarioDetalle _usuarioDetalle = usuarioDetalleData.get();
            _usuarioDetalle.setUsername(usuarioDetalle.getUsername());
            _usuarioDetalle.setNombre(usuarioDetalle.getNombre());
            _usuarioDetalle.setApellido(usuarioDetalle.getApellido());
            _usuarioDetalle.setPassword(usuarioDetalle.getPassword());
            _usuarioDetalle.setFechaNacimiento(usuarioDetalle.getFechaNacimiento());
            _usuarioDetalle.setEnabled(usuarioDetalle.isEnabled());
            _usuarioDetalle.setRedSocial(usuarioDetalle.getRedSocial());
            _usuarioDetalle.setImagen(usuarioDetalle.getImagen());
            _usuarioDetalle.setEmail(usuarioDetalle.getEmail());

            return new ResponseEntity<>(usuarioDetalleRepository.save(_usuarioDetalle), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para eliminar un usuario detalle por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUsuarioDetalle(@PathVariable("id") Long id) {
        try {
            usuarioDetalleRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
