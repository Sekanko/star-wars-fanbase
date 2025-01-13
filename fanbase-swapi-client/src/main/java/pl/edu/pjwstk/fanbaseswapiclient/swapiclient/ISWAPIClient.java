package pl.edu.pjwstk.fanbaseswapiclient.swapiclient;

import pl.edu.pjwstk.fanbaseswapiclient.SWAPImodelDTO.FilmDTO;
import pl.edu.pjwstk.fanbaseswapiclient.SWAPImodelDTO.PlanetDTO;
import pl.edu.pjwstk.fanbaseswapiclient.SWAPImodelDTO.SpeciesDTO;
import pl.edu.pjwstk.fanbaseswapiclient.SWAPImodelDTO.StarWarsCharacterDTO;

import java.util.List;

public interface ISWAPIClient {
    List<StarWarsCharacterDTO> getStarWarsCharacters();
    List<PlanetDTO> getPlanets();
    List<SpeciesDTO> getSpecies();
    List<FilmDTO> getFilms();
}
