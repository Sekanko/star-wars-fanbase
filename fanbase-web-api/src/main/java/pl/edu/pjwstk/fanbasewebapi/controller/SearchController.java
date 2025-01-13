package pl.edu.pjwstk.fanbasewebapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pjwstk.fanbasewebapi.modelDTO.StarWarsCharacterDTO;
import pl.edu.pjwstk.fanbasewebapi.service.ServicesCatalog;

import java.util.List;

@RestController
@RequestMapping("search/")
@RequiredArgsConstructor
public class SearchController {
    private final ServicesCatalog servicesCatalog;

    @GetMapping("star-wars-characters/all")
    public ResponseEntity<List<StarWarsCharacterDTO>> getAllStarWarsCharacters() {
        return new ResponseEntity<>(this.servicesCatalog.getStarWarsCharacterService().getAllCharacters(), HttpStatus.OK);
    }
    @GetMapping("star-wars-character/{name}")
    public ResponseEntity<List<StarWarsCharacterDTO>> getStarWarsCharacterByName(@PathVariable String name) {
        return new ResponseEntity<>(this.servicesCatalog.getStarWarsCharacterService().getCharactersByName(name), HttpStatus.OK);
    }
}
