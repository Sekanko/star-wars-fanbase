package pl.edu.pjwstk.fanbasewebapi.modelDTO;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;

@Data
@Accessors(chain = true)
public class FilmDTO {
    private Long id;
    private String title;
    private int episode_id;
    private String openingCrawl;
    private String director;
    private Date release_date;
    List<Integer> charaterIds;
    List<Integer> planetsIds;
}
