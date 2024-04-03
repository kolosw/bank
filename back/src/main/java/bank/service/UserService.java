package bank.service;

import bank.dto.BankUserDto;
import bank.entities.User;
import bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void create(BankUserDto newUser)
    {
        User user = new User(newUser.getName(), newUser.getSurname(), newUser.getEmail(), newUser.getPassword());
        userRepository.save(user);
    }
    public BankUserDto getById(int i)
    {
        User user = userRepository.getReferenceById(i);
        return new BankUserDto(user.getId(), user.getName(), user.getSurname(), user.getEmail(), user.getPassword());
    }
    public void deleteById(int i)
    {
        userRepository.delete(userRepository.getReferenceById(i));
    }
    public void update (BankUserDto newUser)
    {
        User user = new User(newUser.getId(), newUser.getName(), newUser.getSurname(), newUser.getEmail(), newUser.getPassword());
        userRepository.save(user);
    }
    public List<User> getUserList()
    {
        return userRepository.findAll();
    }
}
