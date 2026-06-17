package rs.ac.singidunum.pj.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.pj.entity.AnimalFact;
import rs.ac.singidunum.pj.repo.AnimalFactRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnimalFactService {

    private final AnimalFactRepository repository;
    private final AnimalService animalService;

    public List<AnimalFact> getAll() {
        return repository.findAllByDeletedAtIsNull();
    }

    public Optional<AnimalFact> getById(Integer id) {
        return repository.findOneByFactIdAndDeletedAtIsNull(id);
    }

    public AnimalFact create(AnimalFact entity) {
        AnimalFact fact = new AnimalFact();
        fact.setAnimal(animalService.getById(entity.getAnimal().getAnimalId()).orElseThrow());
        fact.setTitle(entity.getTitle());
        fact.setContent(entity.getContent());
        fact.setCreatedAt(LocalDateTime.now());
        return repository.save(fact);
    }

    public AnimalFact update(Integer id, AnimalFact entity) {
        AnimalFact fact = getById(id).orElseThrow();
        fact.setAnimal(animalService.getById(entity.getAnimal().getAnimalId()).orElseThrow());
        fact.setTitle(entity.getTitle());
        fact.setContent(entity.getContent());
        fact.setUpdatedAt(LocalDateTime.now());
        return repository.save(fact);
    }

    public void deleteById(Integer id) {
        AnimalFact fact = getById(id).orElseThrow();
        fact.setDeletedAt(LocalDateTime.now());
        repository.save(fact);
    }
}
