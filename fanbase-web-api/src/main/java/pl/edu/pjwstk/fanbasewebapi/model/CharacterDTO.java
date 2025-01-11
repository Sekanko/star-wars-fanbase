package pl.edu.pjwstk.fanbasewebapi.model;

import lombok.Data;
import lombok.experimental.Accessors;
import pl.edu.pjwstk.fanbasedata.model.Gender;

@Data
@Accessors(chain = true)
public class CharacterDTO {
    private String name;
    private String surname;
    private String birthYear;
    private String eyeColor;
    private Gender gender;
    private String hairColor;
    private int height;
    private int weight;
    private String skinColor;
    private int speciesId;
}
