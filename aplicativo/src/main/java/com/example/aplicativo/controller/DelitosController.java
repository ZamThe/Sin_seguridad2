package com.example.aplicativo.controller;

import com.example.aplicativo.model.Delitos;
import com.example.aplicativo.repository.DelitosRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/delitos")
public class DelitosController {

    private final DelitosRepository delitosRepository;

    public DelitosController(DelitosRepository delitosRepository) {
        this.delitosRepository = delitosRepository;
    }

    // Obtener todos los delitos
    @GetMapping
    public ResponseEntity<List<Delitos>> getAllDelitos() {
        List<Delitos> delitos = delitosRepository.findAll();
        return new ResponseEntity<>(delitos, HttpStatus.OK);
    }

    // Crear un nuevo delito
    @PostMapping
    public ResponseEntity<Delitos> createDelito(@RequestBody Delitos delito) {
        try {
            Delitos nuevoDelito = delitosRepository.save(delito);
            return new ResponseEntity<>(nuevoDelito, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Obtener un delito por ID
    @GetMapping("/{id}")
    public ResponseEntity<Delitos> getDelitoById(@PathVariable("id") Long id) {
        Optional<Delitos> delitoData = delitosRepository.findById(id);

        return delitoData.map(delito -> new ResponseEntity<>(delito, HttpStatus.OK))
                         .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Actualizar un delito por ID
    @PutMapping("/{id}")
    public ResponseEntity<Delitos> updateDelito(@PathVariable("id") Long id, @RequestBody Delitos delito) {
        Optional<Delitos> delitoData = delitosRepository.findById(id);

        if (delitoData.isPresent()) {
            Delitos _delito = delitoData.get();
            _delito.setNombre(delito.getNombre());
            _delito.setDescripcion(delito.getDescripcion());
            _delito.setUsuarios_id(delito.getUsuarios_id());

            return new ResponseEntity<>(delitosRepository.save(_delito), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Eliminar un delito por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDelito(@PathVariable("id") Long id) {
        try {
            delitosRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
