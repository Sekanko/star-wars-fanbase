package pl.edu.pjwstk.fanbasedata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pjwstk.fanbasedata.model.Character;

public interface CharacterRepository extends JpaRepository<Character, Integer> {
}
