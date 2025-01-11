package pl.edu.pjwstk.fanbasedata.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int episode_id;
    private String openingCrawl;
    private String director;
    private Date release_date;

    @ManyToMany
    @JoinTable(
            name = "characters_in_films",
            joinColumns = @JoinColumn(name = "film_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "character_id" , nullable = false)
    )
    List<Character> charactersInMovie;

    @ManyToMany
    @JoinTable(
            name = "planets_in_films",
            joinColumns = @JoinColumn(name = "film_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "planet_id" , nullable = false)
    )
    List<Planet> planetsInMovie;

}
