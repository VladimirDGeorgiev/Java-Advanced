package softuni.gamestore.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.gamestore.dto.UserDto;
import softuni.gamestore.dto.UserLoginDto;
import softuni.gamestore.models.Game;
import softuni.gamestore.models.Role;
import softuni.gamestore.models.User;
import softuni.gamestore.repository.GameRepository;
import softuni.gamestore.repository.UserRepository;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final GameRepository gameRepository;
    private final ModelMapper modelMapper;
    private UserDto userDto;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, GameRepository gameRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public String registerUser(UserDto userDto) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        StringBuilder sb = new StringBuilder();

        if (this.userRepository.findByEmail(userDto.getEmail()) != null) {
            return sb.append("User with this email already exists").toString();
        }

        User user = this.modelMapper.map(userDto, User.class);
        if (this.userRepository.count() == 0) {
            user.setRole(Role.ADMIN);
        } else {
            user.setRole(Role.USER);
        }
        Set<ConstraintViolation<User>> violations = validator.validate(user);
        if (violations.size() != 0) {
            for (ConstraintViolation<User> violation : violations) {
                sb.append(violation.getMessage()).append(System.lineSeparator());
            }
            return sb.toString();
        }

        this.userRepository.saveAndFlush(user);
        return sb.append(user.getFullName()).append(" was registered").toString();
    }

    @Override
    public String loginUser(String email, String password) {
        StringBuilder sb = new StringBuilder();
        if (this.userDto != null) {
            return sb.append("There is logged in user already.").toString();
        }
        User user = this.userRepository.findByEmail(email);
        if (user == null) {
            return sb.append("Incorrect username.").toString();
        } else if (!user.getPassword().equals(password)) {
            return sb.append("Incorrect password.").toString();
        }
        this.userDto = this.modelMapper.map(user, UserDto.class);

        return sb.append("Successfully logged in ").append(user.getFullName()).toString();
    }

    @Override
    public String logout() {
        if (this.userDto == null) {
            return "Cannot log out. No user was logged in.";
        }
        String result = String.format("User %s successfully logged out", this.userDto.getFullName());
        this.userDto = null;
        return result;
    }

    @Override
    public boolean isAdminLogin() {
        if (this.userDto==null||this.userDto.getRole().equals(Role.USER)){
            return false;
        }
        return true;
    }

    @Override
    public UserLoginDto getUserLogin() {
        if (this.userDto==null){
            return null;
        }
        return this.modelMapper.map(this.userDto,UserLoginDto.class);

    }

    @Override
    public String addGameToShoppingCard(String gameTitle, String userEmail) {
        Game game = this.gameRepository.findByTitle(gameTitle);
        if (game==null){
            return "Game with this title didnt exists";
        }
        User user = this.userRepository.findByEmail(userEmail);
        Set<Game> shoppingCard = user.getShoppingCard();
        if (shoppingCard!=null&&shoppingCard.stream().anyMatch(b->b.getTitle().equals(gameTitle))){
            return "This game is Already in the Shpping Card";
        }
        shoppingCard.add(game);
        user.setShoppingCard(shoppingCard);

        this.userRepository.saveAndFlush(user);

        return gameTitle+" added to cart.";
    }
}
