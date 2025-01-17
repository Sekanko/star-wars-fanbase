package pl.edu.pjwstk.fanbasedataupdater.updater;

import org.springframework.stereotype.Service;
import pl.edu.pjwstk.fanbasedata.repositories.IRepositoriesCatalog;
import pl.edu.pjwstk.fanbasedataupdater.updater.mappers.IMapper;
import pl.edu.pjwstk.fanbaseswapiclient.Contract.FilmDTO;
import pl.edu.pjwstk.fanbaseswapiclient.Contract.PlanetDTO;
import pl.edu.pjwstk.fanbaseswapiclient.Contract.SpeciesDTO;
import pl.edu.pjwstk.fanbaseswapiclient.Contract.StarWarsCharacterDTO;
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
        client.getPlanets()
                .forEach(this::savePlanet);

    }

    @Override
    public void updateSpecies() {
        client.getSpecies()
                .forEach(this::saveSpecies);
    }

    @Override
    public void updateFilms() {
        client.getFilms()
                .forEach(this::saveFilm);
    }

    public void saveStarWarsCharacter(StarWarsCharacterDTO starWarsCharacterDTO) {
        var character = map.starWarsCharacter().toEntity(starWarsCharacterDTO);
        character.setSwapiId(getIdFromUrl(starWarsCharacterDTO.getUrl()));

        var homewordUrl = starWarsCharacterDTO.getHomeworld();
        if (homewordUrl != null) {
            var homeworldId = getIdFromUrl(homewordUrl);
            var homeworldToSave = db.getPlanets().findById(homeworldId).orElse(null);
            character.setHomeworld(homeworldToSave);
        }

        var speciesUrl = starWarsCharacterDTO.getSpecies();
        if (!speciesUrl.isEmpty()) {
            var speciesId = getIdFromUrl(speciesUrl.getFirst());
            var species = db.getSpecies().findById(speciesId).orElse(null);
            character.setSpecies(species);
        }

        if (db.getStarWarsCharacters().existsBySwapiId(character.getSwapiId())){
            var existingCharacter = db.getStarWarsCharacters().findBySwapiId(character.getSwapiId());
            character.setId(existingCharacter.getId());
        }
        db.getStarWarsCharacters().save(character);
    }
    public void savePlanet(PlanetDTO planetDTO) {
        var planet = map.planet().toEntity(planetDTO);
        planet.setSwapiId(getIdFromUrl(planetDTO.getUrl()));
        if (db.getPlanets().existsBySwapiId(planet.getSwapiId())){
            var existingPlanet = db.getPlanets().findBySwapiId(planet.getSwapiId());
            planet.setId(existingPlanet.getId());
        }
        db.getPlanets().save(planet);
    }
    public void saveSpecies(SpeciesDTO speciesDTO) {
        var species = map.species().toEntity(speciesDTO);
        species.setSwapiId(getIdFromUrl(speciesDTO.getUrl()));

        var originPlanetUrl = speciesDTO.getHomeworld();
        if (originPlanetUrl != null){
            var originPlanetId = getIdFromUrl(originPlanetUrl);
            var originPlanet = db.getPlanets().findById(originPlanetId).orElse(null);
            species.setOriginPlanet(originPlanet);
        }
        species.setSwapiId(getIdFromUrl(speciesDTO.getUrl()));

        if (db.getSpecies().existsBySwapiId(species.getSwapiId())){
            var existingSpecies = db.getSpecies().findBySwapiId(species.getSwapiId());
            species.setId(existingSpecies.getId());
        }
        db.getSpecies().save(species);
    }
    public void saveFilm(FilmDTO filmDTO) {}

    private Long getIdFromUrl(String url){
//        System.out.println("Podano: " + url);
        String entityUrl = url.substring(0, url.length()-1);
        int lastIndex = entityUrl.lastIndexOf('/');
        String idAsString = entityUrl.substring(lastIndex+1);
        Long id = Long.parseLong(idAsString);
        return id;
    }
}
