package softuni.gamestore.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappingConfigurations {
    static ModelMapper modelMapper;

    static {
        modelMapper = new ModelMapper();

//        modelMapper.createTypeMap(Student.class, StudentDto.class)
//                .addMapping(
//                        src -> src.getAddress().getCity(),
//                        StudentDto::setNameOfCity
//                );

        modelMapper.validate();
    }

    @Bean
    public ModelMapper mapper() {
        return modelMapper;
    }
}
