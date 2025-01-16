package pl.edu.pjwstk.fanbasedataupdater.updater.mappers;

import pl.edu.pjwstk.fanbasedata.model.Planet;
import pl.edu.pjwstk.fanbasedata.model.StarWarsCharacter;
import pl.edu.pjwstk.fanbaseswapiclient.SWAPImodelDTO.PlanetDTO;
import pl.edu.pjwstk.fanbaseswapiclient.SWAPImodelDTO.StarWarsCharacterDTO;

public interface IMapper {
    IMap<StarWarsCharacterDTO, StarWarsCharacter> starWarsCharacter();
    IMap<PlanetDTO, Planet> planet();
}
