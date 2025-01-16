package pl.edu.pjwstk.fanbasedataupdater.updater.mappers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.edu.pjwstk.fanbasedata.model.Planet;
import pl.edu.pjwstk.fanbasedata.model.StarWarsCharacter;
import pl.edu.pjwstk.fanbaseswapiclient.SWAPImodelDTO.PlanetDTO;
import pl.edu.pjwstk.fanbaseswapiclient.SWAPImodelDTO.StarWarsCharacterDTO;

@Component
@RequiredArgsConstructor
public class Mapper implements IMapper {
    private final StarWarsCharacterMapper starWarsCharacter;
    private final PlanetMapper planetMapper;
    @Override
    public IMap<StarWarsCharacterDTO, StarWarsCharacter> starWarsCharacter() {
        return starWarsCharacter;
    }

    @Override
    public IMap<PlanetDTO, Planet> planet() {
        return planetMapper;
    }
}
