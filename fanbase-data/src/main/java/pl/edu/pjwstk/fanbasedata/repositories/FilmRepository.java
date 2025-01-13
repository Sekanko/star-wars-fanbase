package pl.edu.pjwstk.fanbasedata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pjwstk.fanbasedata.model.Film;

public interface FilmRepository extends JpaRepository<Film, Long> {
}
