package pl.edu.pjwstk.fanbaseclient.service;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import pl.edu.pjwstk.fanbaseclient.modelDTO.FilmDTO;
import pl.edu.pjwstk.fanbaseclient.modelDTO.PlanetDTO;
import pl.edu.pjwstk.fanbaseclient.modelDTO.SpeciesDTO;
import pl.edu.pjwstk.fanbaseclient.modelDTO.StarWarsCharacterDTO;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ViewService {
    private final RestClient restClient;

    public List<StarWarsCharacterDTO> getStarWarsCharacters() {
        List<StarWarsCharacterDTO> SWCharacterDTOList = restClient
                .get()
                .uri("/search/star-wars-character/")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});

        if (SWCharacterDTOList == null || SWCharacterDTOList.isEmpty() ) {
            return null;
        }
        return SWCharacterDTOList;
    }

    public  List<StarWarsCharacterDTO> getStarWarsCharactersByName(String name) {
        List<StarWarsCharacterDTO> SWCharacterDTOList = restClient
                .get()
                .uri("/search/star-wars-character/name/" + name)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
        if (SWCharacterDTOList == null || SWCharacterDTOList.isEmpty() ) {
            return null;
        }
        return SWCharacterDTOList;
    }

    public List<PlanetDTO> getPlanets() {
        List<PlanetDTO> planets = restClient
                .get()
                .uri("search/planets")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
        if (planets == null || planets.isEmpty() ) {
            return null;
        }
        return planets;
    }

    public List<PlanetDTO> getPlanetsByName(String name) {
        List<PlanetDTO> planets = restClient
                .get()
                .uri("/search/planet/name/" + name)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});

        if (planets == null || planets.isEmpty() ) {
            return null;
        }
        return planets;
    }

    public List<SpeciesDTO> getSpecies() {
        List<SpeciesDTO> species = restClient
                .get()
                .uri("/search/species")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
        if (species == null || species.isEmpty() ) {
            return null;
        }
        return species;
    }

    public List<SpeciesDTO> getSpeciesByName(String name) {
        List<SpeciesDTO> species = restClient
                .get()
                .uri("search/species/name/" + name)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
        if (species == null || species.isEmpty() ) {
            return null;
        }
        return species;
    }

    public List<FilmDTO> getFilms() {
        List<FilmDTO> films = restClient
                .get()
                .uri("/search/films")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
        if (films == null || films.isEmpty() ) {
            return null;
        }
        return films;
    }

    public List<FilmDTO> getFilmsByTitle(String title) {
        List<FilmDTO> films = restClient
                .get()
                .uri("/search/film/title/" + title)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
        if (films == null || films.isEmpty() ) {
            return null;
        }
        return films;
    }
}
