package rs.ac.singidunum.pj.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rs.ac.singidunum.pj.entity.Genus;
import rs.ac.singidunum.pj.repo.GenusRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GenusService {

    private final GenusRepository repository;

    public List<Genus> getAll() {
        return repository.findAllByDeletedAtIsNull();
    }

    public Optional<Genus> getById(Integer id) {
        return repository.findOneByGenusIdAndDeletedAtIsNull(id);
    }

    public Genus create(Genus entity) {
        Genus genus = new Genus();
        genus.setName(entity.getName());
        genus.setLatinName(entity.getLatinName());
        genus.setFamilyName(entity.getFamilyName());
        genus.setDescription(entity.getDescription());
        genus.setCreatedAt(LocalDateTime.now());
        return repository.save(genus);
    }

    public Genus update(Integer id, Genus entity) {
        Genus genus = getById(id).orElseThrow();
        genus.setName(entity.getName());
        genus.setLatinName(entity.getLatinName());
        genus.setFamilyName(entity.getFamilyName());
        genus.setDescription(entity.getDescription());
        genus.setUpdatedAt(LocalDateTime.now());
        return repository.save(genus);
    }

    public void deleteById(Integer id) {
        Genus genus = getById(id).orElseThrow();
        genus.setDeletedAt(LocalDateTime.now());
        repository.save(genus);
    }
}
