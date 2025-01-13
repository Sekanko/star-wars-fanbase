package pl.edu.pjwstk.fanbaseswapiclient.swapiclient;

import pl.edu.pjwstk.fanbaseswapiclient.modelDTO.FilmDTO;
import pl.edu.pjwstk.fanbaseswapiclient.modelDTO.PlanetDTO;
import pl.edu.pjwstk.fanbaseswapiclient.modelDTO.SpeciesDTO;
import pl.edu.pjwstk.fanbaseswapiclient.modelDTO.StarWarsCharacterDTO;

import java.util.List;

public interface ISWAPIClient {
    List<StarWarsCharacterDTO> getStarWarsCharacters();
    List<PlanetDTO> getPlanets();
    List<SpeciesDTO> getSpecies();
    List<FilmDTO> getFilms();
}
