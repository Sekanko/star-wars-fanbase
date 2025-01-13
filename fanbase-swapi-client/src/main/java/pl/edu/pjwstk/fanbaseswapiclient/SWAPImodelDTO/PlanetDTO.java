package pl.edu.pjwstk.fanbaseswapiclient.SWAPImodelDTO;

import lombok.Data;
import java.util.List;

@Data
public class PlanetDTO {
    private String climate;
    private String created;
    private String diameter;
    private String edited;
    private List<String> films;
    private String gravity;
    private String name;
    private String orbitalPeriod;
    private String population;
    private List<String> residents;
    private String rotationPeriod;
    private String surfaceWater;
    private String terrain;
    private String url;
}

