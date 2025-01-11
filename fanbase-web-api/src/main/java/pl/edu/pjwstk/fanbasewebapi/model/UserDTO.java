package pl.edu.pjwstk.fanbasewebapi.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserDTO {
    private String nickname;
    private String login;
    private String password;
    private int favouriteCharacterId;
    private int favouritePlanetId;
    private int favouriteMovieId;

}
