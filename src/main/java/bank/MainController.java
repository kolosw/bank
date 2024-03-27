package bank;

import bank.DAO.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import bank.entities.User;
@RestController
@RequestMapping(path="/bank")
public class MainController {

  @Autowired
  private UserDao userDao;

  @PostMapping("/users")
  public void createUser(@RequestBody User user) {
    userDao.save(user);
  }

  @GetMapping("/users/{id}")
  public User getUser(@PathVariable Integer id) {
    return userDao.getById(id);
  }

  @PutMapping("/users/{id}")
  public void updateUser(@PathVariable Integer id, @RequestBody User user) {
    User existingUser = userDao.getById(id);
    if (existingUser != null) {
      user.setId(id);
      userDao.update(user);
    }
  }

  @DeleteMapping("/users/{id}")
  public void deleteUser(@PathVariable Integer id) {
    User user = userDao.getById(id);
    if (user != null) {
      userDao.delete(user);
    }
  }

}