package bank.controller;

import bank.dto.UserDto;
import bank.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:3000"})
public class UserController {
    private final UserService userService;
    UserController(UserService userService)
    {
        this.userService = userService;
    }

    @GetMapping("/users")
    @ResponseStatus(value = HttpStatus.OK)
    public List<UserDto> findAllUser() {
        return this.userService.getList();
    }

    @PostMapping("/users")
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createUser(@RequestBody UserDto user) {
        userService.create(user);
    }

    @GetMapping("/users/{id}")
    @ResponseStatus(value = HttpStatus.FOUND)
    public UserDto getUser(@PathVariable int id) {
        return userService.getById(id);
    }

    @PutMapping("/users/{id}")
    public void updateUser(@PathVariable int id, @RequestBody UserDto user) {
        userService.update(user, id);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteById(id);
    }
}
