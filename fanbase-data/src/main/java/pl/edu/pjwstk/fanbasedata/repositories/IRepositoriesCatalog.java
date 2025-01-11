package pl.edu.pjwstk.fanbasedata.repositories;

public interface IRepositoriesCatalog {
    CharacterRepository getCharacters();
    FilmRepository getFilms();
    PlanetRepository getPlanets();
    SpeciesRepository getSpecies();
    UserRepository getUsers();
}
