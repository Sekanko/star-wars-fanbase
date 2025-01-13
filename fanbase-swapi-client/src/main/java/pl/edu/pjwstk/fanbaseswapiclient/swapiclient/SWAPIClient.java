package pl.edu.pjwstk.fanbaseswapiclient.swapiclient;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.edu.pjwstk.fanbaseswapiclient.SWAPImodelDTO.FilmDTO;
import pl.edu.pjwstk.fanbaseswapiclient.SWAPImodelDTO.PlanetDTO;
import pl.edu.pjwstk.fanbaseswapiclient.SWAPImodelDTO.SpeciesDTO;
import pl.edu.pjwstk.fanbaseswapiclient.SWAPImodelDTO.StarWarsCharacterDTO;

import java.util.List;

@Component
public class SWAPIClient implements ISWAPIClient {
    private final RestTemplate restTemplate;

    public SWAPIClient() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<StarWarsCharacterDTO> getStarWarsCharacters() {
        var url = "https://swapi.py4e.com/api/people/";
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<StarWarsCharacterDTO>>() {}
        ).getBody();
    }

    @Override
    public List<PlanetDTO> getPlanets() {
        var url = "https://swapi.py4e.com/api/planets/";
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PlanetDTO>>() {}
        ).getBody();
    }

    @Override
    public List<SpeciesDTO> getSpecies() {
        var url = "https://swapi.py4e.com/api/species/";
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<SpeciesDTO>>() {}
        ).getBody();
    }

    @Override
    public List<FilmDTO> getFilms() {
        var url = "https://swapi.py4e.com/api/films/";
        return restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<FilmDTO>>() {}
        ).getBody();
    }
}
