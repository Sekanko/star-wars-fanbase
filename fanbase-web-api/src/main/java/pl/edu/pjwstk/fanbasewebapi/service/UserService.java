package pl.edu.pjwstk.fanbasewebapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.edu.pjwstk.fanbasedata.model.User;
import pl.edu.pjwstk.fanbasedata.repositories.RepositoriesCatalog;
import pl.edu.pjwstk.fanbasewebapi.modelDTO.UserDTO;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final RepositoriesCatalog db;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDTO delete(Long id) {
        var user = db.getUsers().findById(id).orElse(null);
        if (user != null) {
            db.getUsers().delete(user);
            return mapFromUser(user);
        } else{
            return null;
        }
    }

    @Override
    public UserDTO update(Long id, UserDTO userDto) {
        var user = db.getUsers().findById(id).orElse(null);
        if (user != null) {
            db.getUsers().save(getUserFromDto(userDto, user));
            return userDto;
        } else {
            return null;
        }
    }

    @Override
    public Long save(UserDTO userDto) {
        var user = getUserFromDto(userDto);

        if (db.getUsers().existsByLogin(user.getLogin())) {
            return null;
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        var u = db.getUsers().save(user);
        return u.getId();
    }

    public UserDTO login(String login, String password) {
        User user = db.getUsers().findUserByLogin(login);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return mapFromUser(user);
        }
        return null;
    }

    private User getUserFromDto(UserDTO userDto) {
        return getUserFromDto(userDto, new User());
    }
    
    private User getUserFromDto(UserDTO userDto,  User user) {
        user.setId(userDto.getId());
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        user.setNickname(userDto.getNickname());
        user.setFavouriteStarWarsCharacter(db.getStarWarsCharacters().findById(userDto.getFavouriteCharacterId()).orElse(null));
        user.setFavouritePlanet(db.getPlanets().findById(userDto.getFavouritePlanetId()).orElse(null));
        user.setFavouriteMovie(db.getFilms().findById(userDto.getFavouriteMovieId()).orElse(null));
        return user;
    }

    private static UserDTO mapFromUser(User user) {
        return new UserDTO()
                .setId(user.getId())
                .setLogin(user.getLogin())
                .setNickname(user.getNickname())
                .setFavouriteCharacterId(user.getFavouriteStarWarsCharacter() != null ? user.getFavouriteStarWarsCharacter().getId() : null)
                .setFavouritePlanetId(user.getFavouritePlanet() != null ? user.getFavouritePlanet().getId() : null)
                .setFavouriteMovieId(user.getFavouriteMovie() != null ? user.getFavouriteMovie().getId() : null);
    }
}
