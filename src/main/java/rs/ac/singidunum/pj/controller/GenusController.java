package rs.ac.singidunum.pj.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.singidunum.pj.entity.Genus;
import rs.ac.singidunum.pj.service.GenusService;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(path = "/api/genus")
public class GenusController {

    private final GenusService service;

    @GetMapping
    public List<Genus> getGenera() {
        return service.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Genus> getGenusById(@PathVariable Integer id) {
        return ResponseEntity.of(service.getById(id));
    }

    @PostMapping
    public Genus createGenus(@RequestBody Genus entity) {
        return service.create(entity);
    }

    @PutMapping(path = "/{id}")
    public Genus updateGenus(@PathVariable Integer id, @RequestBody Genus entity) {
        return service.update(id, entity);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteGenusById(@PathVariable Integer id) {
        service.deleteById(id);
    }
}
