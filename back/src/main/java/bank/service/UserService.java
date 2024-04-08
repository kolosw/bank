package bank.service;

import bank.dto.UserDto;
import bank.entities.User;
import bank.mapper.UserMapper;
import bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void create(UserDto newUser)
    {
        userRepository.save(UserMapper.toEntity(newUser));
    }
    public UserDto getById(int i)
    {
        User user = userRepository.getReferenceById(i);
        return UserMapper.toDto(user);
    }
    public void deleteById(int i)
    {
        userRepository.delete(userRepository.getReferenceById(i));
    }
    public void update (UserDto newUser, Integer id)
    {
        User user = userRepository.getReferenceById(id);
        if (!newUser.getName().isEmpty())
            user.setName(newUser.getName());
        if (!newUser.getSurname().isEmpty())
            user.setSurname(newUser.getSurname());
        if (!newUser.getEmail().isEmpty())
            user.setEmail(newUser.getEmail());
        if (!newUser.getPassword().isEmpty())
            user.setPassword(newUser.getPassword());
        userRepository.save(user);
    }
    public List<User> getUserList()
    {
        return userRepository.findAll();
    }
}
