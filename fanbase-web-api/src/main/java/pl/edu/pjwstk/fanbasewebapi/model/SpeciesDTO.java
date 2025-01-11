package pl.edu.pjwstk.fanbasewebapi.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class SpeciesDTO {
    private String name;
    private String classification;
    private String designation;
    private double averageHeight;
    private long averageLifespan;
    private String language;
    private int originPlanetId;
}
