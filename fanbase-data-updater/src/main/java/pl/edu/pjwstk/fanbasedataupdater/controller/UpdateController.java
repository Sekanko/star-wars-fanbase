package pl.edu.pjwstk.fanbasedataupdater.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pjwstk.fanbasedataupdater.updater.IDataUpdater;

@Controller
@RequestMapping("update/")
@RequiredArgsConstructor
public class UpdateController {
    private final IDataUpdater dataUpdater;

    @GetMapping("characters")
    public ResponseEntity<Void> updateCharacters() {
        dataUpdater.updateStarWarsCharacter();
        return ResponseEntity.ok().build();
    }
}
