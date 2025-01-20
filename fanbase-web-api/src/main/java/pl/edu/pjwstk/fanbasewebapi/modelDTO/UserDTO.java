package pl.edu.pjwstk.fanbasewebapi.modelDTO;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserDTO {
    private Long id;
    private String nickname;
    private String login;
    private String password;
    private Long favouriteCharacterId;
    private Long favouritePlanetId;
    private Long favouriteMovieId;
    private Long swqpiId;

}
