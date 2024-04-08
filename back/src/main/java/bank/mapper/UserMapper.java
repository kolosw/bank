package bank.mapper;

import bank.dto.UserDto;
import bank.entities.User;
import org.springframework.stereotype.Component;

public class UserMapper {

    public static UserDto toDto(User user) {
        UserDto userDTO = new UserDto();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setSurname(user.getSurname());
        userDTO.setPassword(user.getPassword());
        return userDTO;
    }

    public static User toEntity(UserDto userDTO) {
        User user = new User();
        if(userDTO.getId()!=null)
            user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setSurname(userDTO.getSurname());
        user.setPassword(userDTO.getPassword());
        return user;
    }
}
