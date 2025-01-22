package pl.edu.pjwstk.fanbasewebapi.modelDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;

@Data
@Accessors(chain = true)
public class UserDTO {
    @JsonProperty
    private Long id;
    @NotNull
    private String nickname;
    @NotNull
    private String login;
    @NotNull
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    @JsonProperty("favourite_character_id")
    private Long favouriteCharacterId;
    @JsonProperty("favourite_planet_id")
    private Long favouritePlanetId;
    @JsonProperty("favourite_movie_id")
    private Long favouriteMovieId;
}
