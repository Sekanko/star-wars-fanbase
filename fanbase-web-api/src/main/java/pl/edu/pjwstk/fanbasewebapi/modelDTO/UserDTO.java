package pl.edu.pjwstk.fanbasewebapi.modelDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;

@Data
@Accessors(chain = true)
public class UserDTO {
    @JsonIgnore
    private Long id;
    @NotNull(groups = CreatedBy.class)
    private String nickname;
    @NotNull(groups = CreatedBy.class)
    private String login;
    @NotNull(groups = CreatedBy.class)
    private String password;
    @JsonProperty("favourite_character_id")
    private Long favouriteCharacterId;
    @JsonProperty("favourite_planet_id")
    private Long favouritePlanetId;
    @JsonProperty("favourite_movie_id")
    private Long favouriteMovieId;
}
