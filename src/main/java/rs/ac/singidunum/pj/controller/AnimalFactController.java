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
import rs.ac.singidunum.pj.entity.AnimalFact;
import rs.ac.singidunum.pj.service.AnimalFactService;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(path = "/api/fact")
public class AnimalFactController {

    private final AnimalFactService service;

    @GetMapping
    public List<AnimalFact> getFacts() {
        return service.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<AnimalFact> getFactById(@PathVariable Integer id) {
        return ResponseEntity.of(service.getById(id));
    }

    @PostMapping
    public AnimalFact createFact(@RequestBody AnimalFact entity) {
        return service.create(entity);
    }

    @PutMapping(path = "/{id}")
    public AnimalFact updateFact(@PathVariable Integer id, @RequestBody AnimalFact entity) {
        return service.update(id, entity);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteFactById(@PathVariable Integer id) {
        service.deleteById(id);
    }
}
