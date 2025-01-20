package pl.edu.pjwstk.fanbasewebapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pjwstk.fanbasewebapi.modelDTO.FilmDTO;
import pl.edu.pjwstk.fanbasewebapi.modelDTO.PlanetDTO;
import pl.edu.pjwstk.fanbasewebapi.modelDTO.SpeciesDTO;
import pl.edu.pjwstk.fanbasewebapi.modelDTO.StarWarsCharacterDTO;
import pl.edu.pjwstk.fanbasewebapi.service.ServicesCatalog;

import java.util.List;

@RestController
@RequestMapping("search/")
@RequiredArgsConstructor
public class SearchController {
    private final ServicesCatalog servicesCatalog;

    @GetMapping("star-wars-characters")
    public ResponseEntity<List<StarWarsCharacterDTO>> getAllStarWarsCharacters() {
        return new ResponseEntity<>(this.servicesCatalog.getStarWarsCharacterService().getAllCharacters(), HttpStatus.OK);
    }

    @GetMapping("star-wars-character/name/{name}")
    public ResponseEntity<List<StarWarsCharacterDTO>> getStarWarsCharacterByName(@PathVariable String name) {
        return new ResponseEntity<>(this.servicesCatalog.getStarWarsCharacterService().getCharactersByName(name), HttpStatus.OK);
    }
    @GetMapping("planets")
    public ResponseEntity<List<PlanetDTO>> getAllPlanets() {
        return new ResponseEntity<>(this.servicesCatalog.getPlanetService().getAllPlanets(), HttpStatus.OK);
    }
    @GetMapping("planet/name/{name}")
    public ResponseEntity<List<PlanetDTO>> getPlanetByName(@PathVariable String name) {
        return new ResponseEntity<>(this.servicesCatalog.getPlanetService().getPlanetsByName(name), HttpStatus.OK);
    }
    @GetMapping("species")
    public ResponseEntity<List<SpeciesDTO>> getAllSpecies() {
        return new ResponseEntity<>(this.servicesCatalog.getSpeciesService().getAllSpecies(), HttpStatus.OK);
    }
    @GetMapping("species/name/{name}")
    public ResponseEntity<List<SpeciesDTO>> getSpeciesByName(@PathVariable String name) {
        return new ResponseEntity<>(this.servicesCatalog.getSpeciesService().getSpeciesByName(name), HttpStatus.OK);
    }
    @GetMapping("films")
    public ResponseEntity<List<FilmDTO>> getAllFilms() {
        return new ResponseEntity<>(this.servicesCatalog.getFilmService().getAllFilms(), HttpStatus.OK);
    }
    @GetMapping("film/title/{title}")
    public ResponseEntity<List<FilmDTO>> getFilmByTitle(@PathVariable String title) {
        return new ResponseEntity<>(this.servicesCatalog.getFilmService().getFilmsByTitle(title), HttpStatus.OK);
    }
}
