package pl.edu.pjwstk.fanbasedataupdater.updater;

import org.springframework.stereotype.Service;
import pl.edu.pjwstk.fanbasedata.model.Film;
import pl.edu.pjwstk.fanbasedata.model.Planet;
import pl.edu.pjwstk.fanbasedata.model.Species;
import pl.edu.pjwstk.fanbasedata.model.StarWarsCharacter;
import pl.edu.pjwstk.fanbasedata.repositories.IRepositoriesCatalog;
import pl.edu.pjwstk.fanbasedataupdater.updater.mappers.IMapper;
import pl.edu.pjwstk.fanbaseswapiclient.SWAPImodelDTO.StarWarsCharacterDTO;
import pl.edu.pjwstk.fanbaseswapiclient.swapiclient.ISWAPIClient;

@Service
public class DataUpdater implements IDataUpdater {
    private final IMapper map;
    private final IRepositoriesCatalog db;
    private final ISWAPIClient client;

    public DataUpdater(IRepositoriesCatalog db, ISWAPIClient client, IMapper map) {
        this.db = db;
        this.client = client;
        this.map = map;
    }


    @Override
    public void updateStarWarsCharacter() {
        client.getStarWarsCharacters()
                .forEach(this::saveStarWarsCharacter);
    }

    @Override
    public void updatePlanet() {

    }

    @Override
    public void updateSpecies() {

    }

    @Override
    public void updateFilms() {

    }

    public void saveStarWarsCharacter(StarWarsCharacterDTO starWarsCharacterDTO) {
        var character = map.starWarsCharacter().toEntity(starWarsCharacterDTO);
        character.setHomeworld(getPlanetFromUrl(starWarsCharacterDTO.getHomeworld()));
        character.setSpecies(getSpeciesFromUrl(starWarsCharacterDTO.getSpecies().getFirst()));
        db.getStarWarsCharacters().save(character);
    }

    private Planet getPlanetFromUrl(String planetUrl){
        String url = planetUrl.substring(0, planetUrl.length()-2);
        int lastIndex = url.lastIndexOf('/');
        Long id = Long.parseLong(url.substring(lastIndex + 1));
        return db.getPlanets().findById(id).orElse(null);

    }
    private Species getSpeciesFromUrl(String speciesUrl){
        String url = speciesUrl.substring(0, speciesUrl.length()-2);
        int lastIndex = url.lastIndexOf('/');
        Long id = Long.parseLong(url.substring(lastIndex + 1));
        return db.getSpecies().findById(id).orElse(null);
    }
    private Film getFilmFromUrl(String filmUrl){
        String url = filmUrl.substring(0, filmUrl.length()-2);
        int lastIndex = url.lastIndexOf('/');
        Long id = Long.parseLong(url.substring(lastIndex + 1));
        return db.getFilms().findById(id).orElse(null);
    }
}
