package rs.ac.singidunum.pj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.pj.entity.AnimalFact;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnimalFactRepository extends JpaRepository<AnimalFact, Integer> {

    List<AnimalFact> findAllByDeletedAtIsNull();

    Optional<AnimalFact> findOneByFactIdAndDeletedAtIsNull(Integer id);
}
