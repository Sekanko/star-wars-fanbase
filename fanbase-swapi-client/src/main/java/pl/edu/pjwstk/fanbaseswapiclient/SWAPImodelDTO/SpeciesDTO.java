package pl.edu.pjwstk.fanbaseswapiclient.SWAPImodelDTO;

import lombok.Data;
import java.util.List;

@Data
public class SpeciesDTO extends SWDTO {
    private String averageHeight;
    private String averageLifespan;
    private String classification;
    private String created;
    private String designation;
    private String edited;
    private String eyeColors;
    private String hairColors;
    private String homeworld;
    private String language;
    private String name;
    private List<String> people;
    private List<String> films;
    private String skinColors;
    private String url;
}

