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
import rs.ac.singidunum.pj.entity.Animal;
import rs.ac.singidunum.pj.service.AnimalService;

import java.util.List;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping(path = "/api/animal")
public class AnimalController {

    private final AnimalService service;

    @GetMapping
    public List<Animal> getAnimals() {
        return service.getAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable Integer id) {
        return ResponseEntity.of(service.getById(id));
    }

    @PostMapping
    public Animal createAnimal(@RequestBody Animal entity) {
        return service.create(entity);
    }

    @PutMapping(path = "/{id}")
    public Animal updateAnimal(@PathVariable Integer id, @RequestBody Animal entity) {
        return service.update(id, entity);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteAnimalById(@PathVariable Integer id) {
        service.deleteById(id);
    }
}
