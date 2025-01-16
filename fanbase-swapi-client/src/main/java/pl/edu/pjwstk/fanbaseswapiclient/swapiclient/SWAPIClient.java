package pl.edu.pjwstk.fanbaseswapiclient.swapiclient;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import pl.edu.pjwstk.fanbaseswapiclient.SWAPImodelDTO.*;

import java.util.ArrayList;
import java.util.List;

@Component
public class SWAPIClient implements ISWAPIClient {
    private final RestTemplate restTemplate;

    public SWAPIClient() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    public List<StarWarsCharacterDTO> getStarWarsCharacters() {
        return getListOfEntitiesFromSwapi("people", StarWarsCharacterDTO.class);
    }

    @Override
    public List<PlanetDTO> getPlanets() {
        return getListOfEntitiesFromSwapi("planets", PlanetDTO.class);
    }

    @Override
    public List<SpeciesDTO> getSpecies() {
        return getListOfEntitiesFromSwapi("species", SpeciesDTO.class);
    }

    @Override
    public List<FilmDTO> getFilms() {
        return getListOfEntitiesFromSwapi("films", FilmDTO.class);
    }

    private <T extends SWDTO> List<T> getListOfEntitiesFromSwapi(String entityName, Class<T> type){
        var url = "https://swapi.py4e.com/api/" + entityName + "/";
        long i = 1;
        boolean success = true;
        List<T> entities = new ArrayList<>();

        while (success) {
            try {
                if (type == StarWarsCharacterDTO.class && i == 17){
//                    break;
                    i++;
                    continue;
                }

//                if (i != 1){
//                    break;
//                }

                System.out.println(url + i + '/');
                var response = restTemplate.exchange(
                        (url + i + "/"),
                        HttpMethod.GET,
                        null,
                        ParameterizedTypeReference.forType(type));
                if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                    T entity = (T)response.getBody();
                    entity.setSwapiId(i++);
                    entities.add(entity);
                } else {
                    success = false;
                }
            } catch (Exception e) {
                success = false;
                e.printStackTrace();
                System.out.println("Request failed!!!");
            }
        }
        return entities;
    }
}
