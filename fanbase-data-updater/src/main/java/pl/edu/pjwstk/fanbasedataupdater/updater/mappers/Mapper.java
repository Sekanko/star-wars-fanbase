package pl.edu.pjwstk.fanbasedataupdater.updater.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.edu.pjwstk.fanbasedata.model.StarWarsCharacter;
import pl.edu.pjwstk.fanbaseswapiclient.SWAPImodelDTO.StarWarsCharacterDTO;

@Component
@RequiredArgsConstructor
public class Mapper implements IMapper {
    private final StarWarsCharacterMapper starWarsCharacter;
    @Override
    public IMap<StarWarsCharacterDTO, StarWarsCharacter> starWarsCharacter() {
        return starWarsCharacter;
    }
}
