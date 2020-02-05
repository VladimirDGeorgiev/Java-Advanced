package softuni.gamestore.service;

import softuni.gamestore.dto.UserDto;
import softuni.gamestore.dto.UserLoginDto;

public interface UserService {
//    UserDto registerUser(String[] input);
//
//    UserDto loginUser(String[] input);

    String registerUser(UserDto userDto);

    String loginUser(String email,String password);

    String logout ();

    boolean isAdminLogin();

    UserLoginDto getUserLogin();

    String addGameToShoppingCard(String gameTitle, String userEmail);
}
