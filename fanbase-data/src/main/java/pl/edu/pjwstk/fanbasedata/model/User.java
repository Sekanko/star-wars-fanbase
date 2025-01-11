package pl.edu.pjwstk.fanbasedata.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nickname;
    private String login;
    private String password;
    @ManyToOne
    @JoinColumn(name = "character_id", nullable = false)
    private Character favouriteCharacter;
    @ManyToOne
    @JoinColumn(name = "planet_id", nullable = false)
    private Planet favouritePlanet;
    @ManyToOne
    @JoinColumn (name = "film_id", nullable = false)
    private Film favouriteMovie;
}
