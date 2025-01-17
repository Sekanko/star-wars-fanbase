package pl.edu.pjwstk.fanbasedata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pjwstk.fanbasedata.model.Species;

public interface SpeciesRepository extends JpaRepository<Species, Long> {
    boolean existsBySwapiId(Long swapiId);
    Species findBySwapiId(Long swapiId);
}
