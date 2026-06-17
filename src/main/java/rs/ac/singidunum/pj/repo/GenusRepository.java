package rs.ac.singidunum.pj.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.pj.entity.Genus;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenusRepository extends JpaRepository<Genus, Integer> {

    List<Genus> findAllByDeletedAtIsNull();

    Optional<Genus> findOneByGenusIdAndDeletedAtIsNull(Integer id);
}
