package pl.edu.pjwstk.fanbaseclient.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjwstk.fanbaseclient.service.ViewService;

@Controller
@RequiredArgsConstructor
@RequestMapping("fanbase/")
public class ViewController {
    private final ViewService viewService;

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
        var character = viewService.
    }

}
