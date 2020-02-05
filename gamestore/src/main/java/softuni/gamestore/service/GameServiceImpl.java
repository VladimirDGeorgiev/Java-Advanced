package softuni.gamestore.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.gamestore.dto.GameDetailsDto;
import softuni.gamestore.dto.GameDto;
import softuni.gamestore.models.Game;
import softuni.gamestore.repository.GameRepository;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    private final ModelMapper modelMapper;


    @Autowired
    public GameServiceImpl(GameRepository gameRepository, ModelMapper modelMapper) {
        this.gameRepository = gameRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public String addGame(GameDto gameDto) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        StringBuilder sb = new StringBuilder();

        if (this.gameRepository.findByTitle(gameDto.getTitle()) != null) {
            return sb.append("Game with this title already exist.").toString();
        }

        Game game = this.modelMapper.map(gameDto, Game.class);
        Set<ConstraintViolation<Game>> violations = validator.validate(game);
        if (violations.size() != 0) {
            for (ConstraintViolation<Game> violation : violations) {
                sb.append(violation.getMessage()).append(System.lineSeparator());
            }
            return sb.toString();
        }

        this.gameRepository.saveAndFlush(game);


        return sb.append(String.format("Added %s", game.getTitle())).toString();
    }

    @Override
    public String editGame(String[] input) {
//        EditGame|<id>|<values>
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        StringBuilder sb = new StringBuilder();
        Game game = this.gameRepository.findGameById(Integer.parseInt(input[0]));
        if (game == null) {
            return sb.append("Invalid ID").toString();
        }

        for (int i = 1; i < input.length; i++) {
            String[] tokens = input[i].split("=");
            //columnName=value
            switch (tokens[0]) {
                case "title":
                    game.setTitle(tokens[1]);
                    break;
                case "price":
                    game.setPrice(BigDecimal.valueOf(Double.parseDouble(tokens[1])));
                    break;
                case "size":
                    game.setSize(Double.parseDouble(tokens[1]));
                    break;
                case "trailer":
                    game.setTrailer(tokens[1]);
                    break;
                case "thumbnail URL":
                    game.setImage(tokens[1]);
                    break;
                case "description":
                    game.setDescription(tokens[1]);
                default:
                    break;
            }
        }

        Set<ConstraintViolation<Game>> violations = validator.validate(game);
        if (violations.size() != 0) {
            for (ConstraintViolation<Game> violation : violations) {
                sb.append(violation.getMessage()).append(System.lineSeparator());
            }
            return sb.toString();
        }

        this.gameRepository.saveAndFlush(game);

        return sb.append(String.format("Edited %s", game.getTitle())).toString();
    }

    @Override
    public String deleteGame(Integer id) {
        StringBuilder sb = new StringBuilder();

        Game game = this.gameRepository.findGameById(id);
        if (game == null) {
            return sb.append("There is no book with this id.").toString();
        }

        this.gameRepository.deleteById(id);
        return sb.append(String.format("Deleted %s",game.getTitle())).toString();
    }

    @Override
    public String getAllGame() {
        StringBuilder sb = new StringBuilder();
        List<Game> allGames = this.gameRepository.findAll();
        allGames.forEach(game -> {
            sb.append(String.format("%s %.2f",game.getTitle(),game.getPrice())).append(System.lineSeparator());
        });
        return sb.toString().trim();
    }

    @Override
    public String getDetailsForGame(String title) {
        StringBuilder sb = new StringBuilder();
        Game game = this.gameRepository.findByTitle(title);
        if (game==null){
            return sb.append("Game with this title didn't exists").toString();
        }
        GameDetailsDto gameDto = this.modelMapper.map(game,GameDetailsDto.class);;


        return gameDto.toString();
    }
}
