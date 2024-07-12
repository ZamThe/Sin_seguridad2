package com.example.aplicativo.controller;

import com.example.aplicativo.model.Casos;
import com.example.aplicativo.repository.CasosRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/casos")
public class CasosController {

    private final CasosRepository casosRepository;

    public CasosController(CasosRepository casosRepository) {
        this.casosRepository = casosRepository;
    }

    // Endpoint para obtener todos los casos
    @GetMapping
    public ResponseEntity<List<Casos>> getAllCasos() {
        List<Casos> casos = casosRepository.findAll();
        return new ResponseEntity<>(casos, HttpStatus.OK);
    }

    // Endpoint para crear un nuevo caso
    @PostMapping
    public ResponseEntity<Casos> createCaso(@RequestBody Casos caso) {
        try {
            Casos nuevoCaso = casosRepository.save(caso);
            return new ResponseEntity<>(nuevoCaso, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Endpoint para obtener un caso por ID
    @GetMapping("/{id}")
    public ResponseEntity<Casos> getCasoById(@PathVariable("id") Long id) {
        Optional<Casos> casoData = casosRepository.findById(id);

        return casoData.map(caso -> new ResponseEntity<>(caso, HttpStatus.OK))
                       .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Endpoint para actualizar un caso por ID
    @PutMapping("/{id}")
    public ResponseEntity<Casos> updateCaso(@PathVariable("id") Long id, @RequestBody Casos caso) {
        Optional<Casos> casoData = casosRepository.findById(id);

        if (casoData.isPresent()) {
            Casos _caso = casoData.get();
            _caso.setFecha_hora(caso.getFecha_hora());
            _caso.setLatitud(caso.getLatitud());
            _caso.setLongitud(caso.getLongitud());
            _caso.setAltitud(caso.getAltitud());
            _caso.setVisible(caso.getVisible());
            _caso.setDescripcion(caso.getDescripcion());
            _caso.setUrl_map(caso.getUrl_map());
            _caso.setRmi_url(caso.getRmi_url());
            _caso.setUsuarios_id(caso.getUsuarios_id());
            _caso.setDelitos_id(caso.getDelitos_id());

            return new ResponseEntity<>(casosRepository.save(_caso), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para eliminar un caso por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCaso(@PathVariable("id") Long id) {
        try {
            casosRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
