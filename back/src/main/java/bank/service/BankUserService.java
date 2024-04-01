package bank.service;

import bank.dto.BankUserDto;
import bank.entities.User;
import bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankUserService {
    @Autowired
    UserRepository userRepository;

    public void createUser(BankUserDto newUser)
    {
        User user = new User(newUser.getName(), newUser.getSurname(), newUser.getEmail(), newUser.getPassword());
        userRepository.save(user);
    }
    public BankUserDto getUserById(int i)
    {
        User user = userRepository.getById(i);
        return new BankUserDto(user.getId(), user.getName(), user.getSurname(), user.getEmail(), user.getPassword());
    }
    public void deleteUserById(int i)
    {
        userRepository.delete(userRepository.getById(i));
    }
    public void updateUser (BankUserDto newUser)
    {
        User user = new User(newUser.getId(), newUser.getName(), newUser.getSurname(), newUser.getEmail(), newUser.getPassword());
        userRepository.save(user);
    }
}
