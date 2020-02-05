package softuni.gamestore.service;

import softuni.gamestore.dto.GameDto;

public interface GameService {
    String addGame(GameDto gameDto);

    String editGame(String[] input);

    String deleteGame(Integer id);

    String getAllGame();

    String getDetailsForGame(String title);


//    GameDto addGame(String[] input);
//
//    GameDto editGame(String[] input);
//
//    GameDto deleteGame(Integer input);
}
