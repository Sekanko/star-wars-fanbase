package pl.edu.pjwstk.fanbaseclient.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;
import pl.edu.pjwstk.fanbaseclient.modelDTO.*;
import pl.edu.pjwstk.fanbaseclient.service.ViewService;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequiredArgsConstructor
@RequestMapping("fanbase/")
public class ViewController {
    private final ViewService viewService;
    private final RestClient restClient;

    @GetMapping("main")
    public String mainPage() {
        return "mainFBPage";
    }
    @PostMapping("main")
    public String postMain(@RequestParam("searchParam") String searchParameter){
        return "redirect:/fanbase/results/named/"+searchParameter;
    }

    @GetMapping("results/named/{searchParameter}")
    public String resultsPage(Model model, @PathVariable String searchParameter) {
        var characters = viewService.getStarWarsCharactersByName(searchParameter);
        var planets = viewService.getPlanetsByName(searchParameter);
        var species = viewService.getSpeciesByName(searchParameter);
        var films = viewService.getFilmsByTitle(searchParameter);

        model.addAttribute("characters", characters);
        model.addAttribute("planets", planets);
        model.addAttribute("speciesList", species);
        model.addAttribute("films", films);
        return "resultFBPage";
    }

    @GetMapping("character/id/{id}")
    public String characterPage(@PathVariable Long id, Model model) {
        StarWarsCharacterDTO character = viewService.getStarWarsCharacterById(id);
        PlanetDTO planet = null;
        Long homewordId = character.getHomeworldId();

        if (homewordId != null) {
            planet = viewService.getPlanetById(homewordId);
        }
        SpeciesDTO species = null;

        Long speciesId = character.getSpeciesId();
        if (speciesId != null) {
            species = viewService.getSpeciesById(speciesId);
        }
        model.addAttribute("character", character);
        model.addAttribute("homeword", planet);
        model.addAttribute("species", species);

        return "characterPage";
    }

    @GetMapping("planet/id/{id}")
    public String planetPage(@PathVariable Long id, Model model) {
        PlanetDTO planet = viewService.getPlanetById(id);

        model.addAttribute("planet", planet);
        return "planetPage";

    }

    @GetMapping("species/id/{id}")
    public String speciesPage(@PathVariable Long id, Model model) {
        SpeciesDTO species = viewService.getSpeciesById(id);

        PlanetDTO planet = null;

        Long originPlanetId = species.getOriginPlanetId();
        if (originPlanetId != null) {
            planet = viewService.getPlanetById(originPlanetId);
        }
        model.addAttribute("species", species);
        model.addAttribute("originPlanet", planet);
        return "speciesPage";
    }

    @GetMapping("film/id/{id}")
    public String filmPage(@PathVariable Long id, Model model) {
        FilmDTO film = viewService.getFilmById(id);
        Set<StarWarsCharacterDTO> charactersInFilm = new HashSet<>();

        film.getCharaterIds().forEach(characterId -> {
            StarWarsCharacterDTO character = viewService.getStarWarsCharacterById(characterId);
            charactersInFilm.add(character);
        });

        Set<PlanetDTO> planetsInFilm = new HashSet<>();
        film.getPlanetsIds().forEach(planetId -> {
            PlanetDTO planet = viewService.getPlanetById(planetId);
            planetsInFilm.add(planet);
        });
        model.addAttribute("film", film);
        model.addAttribute("charactersInFilm", charactersInFilm);
        model.addAttribute("planetsInFilm", planetsInFilm);
        return "filmPage";
    }

    @GetMapping("register")
    public String registerPage(Model model) {
        model.addAttribute("user", new UserDTO());
        return "registerToFB";
    }

    @PostMapping("register")
    public String postRegister(@ModelAttribute("user") UserDTO user, @RequestParam("passwordConfirm") String passwordConfirm) {
        if (passwordConfirm.equals(user.getPassword())) {
            restClient.post()
                    .uri("user/register")
                    .body(user)
                    .retrieve()
                    .toBodilessEntity();
            return "redirect:main";
        } else {
            System.out.println("password confirmation: " + passwordConfirm);
        }
        return "redirect:/register";
    }

}
