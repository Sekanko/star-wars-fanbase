package pl.edu.pjwstk.fanbasedataupdater.updater.mappers;


import org.springframework.stereotype.Component;
import pl.edu.pjwstk.fanbasedata.model.Gender;
import pl.edu.pjwstk.fanbasedata.model.StarWarsCharacter;
import pl.edu.pjwstk.fanbaseswapiclient.SWAPImodelDTO.StarWarsCharacterDTO;

@Component
public class StarWarsCharacterMapper implements IMap<StarWarsCharacterDTO, StarWarsCharacter> {
    @Override
    public StarWarsCharacter toEntity(StarWarsCharacterDTO starWarsCharacterDTO) {
        var starWarsCharacter = new StarWarsCharacter();

        starWarsCharacter.setName(starWarsCharacterDTO.getName());
        starWarsCharacter.setHeight(Integer.parseInt(starWarsCharacterDTO.getHeight()));
        starWarsCharacter.setWeight(Integer.parseInt(starWarsCharacterDTO.getMass()));
        starWarsCharacter.setHairColor(starWarsCharacterDTO.getHairColor());
        starWarsCharacter.setSkinColor(starWarsCharacterDTO.getSkinColor());
        starWarsCharacter.setEyeColor(starWarsCharacterDTO.getEyeColor());
        starWarsCharacter.setBirthYear(starWarsCharacterDTO.getBirthYear());

        switch (starWarsCharacterDTO.getGender()){
            case "Male":
                starWarsCharacter.setGender(Gender.MALE);
                break;
            case "Female":
                starWarsCharacter.setGender(Gender.FEMALE);
                break;
            case "Unknown":
                starWarsCharacter.setGender(Gender.UNKNOWN);
                break;
            default:
                starWarsCharacter.setGender(Gender.NA);
        }

        return starWarsCharacter;
    }
}
