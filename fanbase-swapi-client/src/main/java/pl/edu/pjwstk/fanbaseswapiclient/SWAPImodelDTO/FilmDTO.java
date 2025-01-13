package pl.edu.pjwstk.fanbaseswapiclient.SWAPImodelDTO;

import lombok.Data;
import java.util.List;

@Data
public class FilmDTO {
    private List<String> characters;
    private String created;
    private String director;
    private String edited;
    private int episodeId;
    private String openingCrawl;
    private List<String> planets;
    private String producer;
    private String releaseDate;
    private List<String> species;
    private List<String> starships;
    private String title;
    private String url;
    private List<String> vehicles;
}

