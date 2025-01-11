package pl.edu.pjwstk.fanbasewebapi.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class PlanetDTO {
    private String name;
    private int diameter;
    private int rotationPeriod;
    private int orbitalPeriod;
    private double gravity;
    private double population;
    private String climate;
    private String terrain;
    private int surfaceWaterPercentage;
}
