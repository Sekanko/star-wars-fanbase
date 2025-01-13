package pl.edu.pjwstk.fanbasedata.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class StarWarsCharacter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String birthYear;
    private String eyeColor;
    private Gender gender;
    private String hairColor;
    private int height;
    private int weight;
    private String skinColor;

    @ManyToOne
    @JoinColumn(name = "planet_id", nullable = false)
    private Planet homeworld;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Species species;

}
