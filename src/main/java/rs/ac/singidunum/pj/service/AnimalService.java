package rs.ac.singidunum.pj.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import rs.ac.singidunum.pj.entity.Animal;
import rs.ac.singidunum.pj.repo.AnimalRepository;

@Service
@RequiredArgsConstructor
public class AnimalService {

    private final AnimalRepository repository;
    private final GenusService genusService;

    public List<Animal> getAll() {
        return repository.findAllByDeletedAtIsNull();
    }

    public Optional<Animal> getById(Integer id) {
        return repository.findOneByAnimalIdAndDeletedAtIsNull(id);
    }

    public Animal create(Animal entity) {
        Animal animal = new Animal();
        animal.setGenus(genusService.getById(entity.getGenus().getGenusId()).orElseThrow());
        animal.setCommonName(entity.getCommonName());
        animal.setLatinName(entity.getLatinName());
        animal.setHabitat(entity.getHabitat());
        animal.setDiet(entity.getDiet());
        animal.setConservationStatus(entity.getConservationStatus());
        animal.setImageUrl(entity.getImageUrl());
        animal.setDescription(entity.getDescription());
        animal.setCreatedAt(LocalDateTime.now());
        return repository.save(animal);
    }

    public Animal update(Integer id, Animal entity) {
        Animal animal = getById(id).orElseThrow();
        animal.setGenus(genusService.getById(entity.getGenus().getGenusId()).orElseThrow());
        animal.setCommonName(entity.getCommonName());
        animal.setLatinName(entity.getLatinName());
        animal.setHabitat(entity.getHabitat());
        animal.setDiet(entity.getDiet());
        animal.setConservationStatus(entity.getConservationStatus());
        animal.setImageUrl(entity.getImageUrl());
        animal.setDescription(entity.getDescription());
        animal.setUpdatedAt(LocalDateTime.now());
        return repository.save(animal);
    }

    public void deleteById(Integer id) {
        Animal animal = getById(id).orElseThrow();
        animal.setDeletedAt(LocalDateTime.now());
        repository.save(animal);
    }
}
