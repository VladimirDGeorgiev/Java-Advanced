package softuni.gamestore;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.gamestore.dto.GameDto;
import softuni.gamestore.dto.UserDto;
import softuni.gamestore.dto.UserLoginDto;
import softuni.gamestore.models.Role;
import softuni.gamestore.service.GameService;
import softuni.gamestore.service.UserService;
import softuni.gamestore.util.ConsoleReader;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

@Component
public class App implements CommandLineRunner {

    private final ModelMapper mapper;
    private final ConsoleReader reader;
    private final GameService gameService;
    private final UserService userService;
    private UserLoginDto userLoginDto;


    @Autowired
    public App(ModelMapper mapper, ConsoleReader reader, GameService gameService, UserService userService) {
        this.mapper = mapper;
        this.reader = reader;
        this.gameService = gameService;
        this.userService = userService;
    }

    @Override
    public void run(String... args) throws Exception {

        String input = this.reader.read();

        while (!input.equals("End")) {
            String[] tokens = input.split("\\|+");
            String command = tokens[0];
            String[] sliceInput = Arrays.copyOfRange(tokens, 1, tokens.length);
            String result = "";
                switch (command) {
                    case "RegisterUser":
                        if (!sliceInput[1].equals(sliceInput[2])){
                           result = "Password and confirm password must be the same";
                           break;
                        }
                        UserDto userDto = new UserDto(sliceInput[3],sliceInput[0],sliceInput[1]);
                        result =  this.userService.registerUser(userDto);
                        break;

                    case "LoginUser":
                           result = this.userService.loginUser(sliceInput[0],sliceInput[1]);
                         this.userLoginDto =   this.userService.getUserLogin();

                        break;

                    case "Logout":
                        result = this.userService.logout();
                        this.userLoginDto = null;
                        break;

                    case "AddGame":
                      if (this.userLoginDto==null||this.userLoginDto.getRole()!= Role.ADMIN){
                          result = "Admin is not login.";
                          break;
                      }
                        GameDto gameDto = new GameDto(sliceInput[0],new BigDecimal(sliceInput[1]),Double.parseDouble(sliceInput[2]),sliceInput[3],sliceInput[4],sliceInput[5], LocalDate.parse(sliceInput[6], DateTimeFormatter.ofPattern("dd-MM-yyyy")));
                        result = this.gameService.addGame(gameDto);
                        break;

                    case "EditGame":
                        if (this.userLoginDto==null||this.userLoginDto.getRole()!= Role.ADMIN){
                            result = "Admin is not login.";
                            break;
                        }
                        result = this.gameService.editGame(sliceInput);
                        break;

                    case "DeleteGame":
                        if (this.userLoginDto==null||this.userLoginDto.getRole()!= Role.ADMIN){
                            result = "Admin is not login.";
                            break;
                        }
                        result = this.gameService.deleteGame(Integer.parseInt(sliceInput[0]));
                        break;


                    case "AllGames":
                        result = this.gameService.getAllGame();
                        break;

                    case "DetailGame":
                        result = this.gameService.getDetailsForGame(sliceInput[0]);
                        break;

                    case "OwnedGames":
                        if (this.userLoginDto==null){
                            result = "User is not login.";
                            break;
                        }

                        break;
                    case "AddItem":
                        if (this.userLoginDto==null){
                            result = "User is not login.";
                            break;
                        }
                        result = this.userService.addGameToShoppingCard(sliceInput[0],this.userLoginDto.getEmail());

                        break;
                    case "RemoveItem":

                        break;
                    case "BuyItem":

                        break;


                    default:
                        break;
                }



            System.out.println(result);

            input = this.reader.read();
        }


//        Address address = new Address() {{
//            setCity("Sofia");
//        }};
//
//
//        Student student = new Student(0, "Pesho", "Peshov", address);
//        StudentDto studentDto = mapper.map(student, StudentDto.class);
//        System.out.println(studentDto);
    }
}
