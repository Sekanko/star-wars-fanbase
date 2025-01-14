package pl.edu.pjwstk.fanbasedataupdater.updater;

import pl.edu.pjwstk.fanbaseswapiclient.SWAPImodelDTO.PlanetDTO;

public interface IDataUpdater {
    void updateStarWarsCharacter();
    void updatePlanet();
    void updateSpecies();
    void updateFilms();
}
