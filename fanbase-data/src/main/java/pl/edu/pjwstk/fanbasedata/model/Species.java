package pl.edu.pjwstk.fanbasedata.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String classification;
    private String designation;
    private double averageHeight;
    private long averageLifespan;
    private String language;

    @ManyToOne
    @JoinColumn(name = "planet_id",nullable = false)
    private Planet originPlanet;

}
