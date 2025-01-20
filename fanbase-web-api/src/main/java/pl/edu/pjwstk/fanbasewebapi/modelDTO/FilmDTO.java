package pl.edu.pjwstk.fanbasewebapi.modelDTO;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Accessors(chain = true)
public class FilmDTO {
    private Long id;
    private String title;
    private int episode_id;
    private String openingCrawl;
    private String director;
    private Date release_date;
    Set<Integer> charaterIds;
    Set<Integer> planetsIds;
    private Long swqpiId;
}
