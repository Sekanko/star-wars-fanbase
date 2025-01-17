package pl.edu.pjwstk.fanbasedata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.pjwstk.fanbasedata.model.Film;

@Transactional
public interface FilmRepository extends JpaRepository<Film, Long> {
    boolean existsBySwapiId(Long swapiId);
    Film findBySwapiId(Long swapiId);
}
