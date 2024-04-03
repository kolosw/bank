package bank.controller;

import bank.dto.BankAccountCurrencyDto;
import bank.dto.BankAccountDto;
import bank.dto.BankUserDto;
import bank.dto.CurrencyDto;
import bank.entities.*;
import bank.repository.*;
import bank.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MainController {

  @Autowired
  private UserService userService;
  @Autowired
  private TransactionService transactionService;
  @Autowired
  private CurrencyService currencyService;
  @Autowired
  private BankAccountService bankAccountService;
  @Autowired
  private BankAccountCurrencyService bankAccountCurrencyService;

  @GetMapping("/users")
  @ResponseStatus(value = HttpStatus.OK)
  public List<User> findAllUser() {
    return this.userService.getUserList();
  }
  @PostMapping("/users")
  public void createUser(@RequestBody BankUserDto user) {
    userService.create(user);
  }

  @GetMapping("/users/{id}")
  public BankUserDto getUser(@PathVariable int id) {
    return userService.getById(id);
  }

  @PutMapping("/users/{id}")
  public void updateUser(@PathVariable int id, @RequestBody BankUserDto user) {
    userService.update(user);
  }

  @DeleteMapping("/users/{id}")
  public void deleteUser(@PathVariable int id) {
    userService.deleteById(id);
  }

  @PostMapping("/currency")
  public void createCurrency(@RequestBody CurrencyDto currency) { currencyService.create(currency);}

  @GetMapping("/currency/{id}")
  public CurrencyDto getCurrency(@PathVariable Integer id) {
    return currencyService.getById(id);
  }

  @PutMapping("/currency/{id}")
  public void updateCurrency(@RequestBody CurrencyDto currency) {
    currencyService.update(currency);
  }

  @DeleteMapping("/currency/{id}")
  public void deleteCurrency(@PathVariable Integer id) {
    currencyService.deleteById(id);
  }
  @PostMapping("/account")
  public void createAccount(@RequestBody BankAccountDto bankAccountDto) {
    bankAccountService.create(bankAccountDto);
  }

  @GetMapping("/account/{id}")
  public BankAccountDto getAccount(@PathVariable Integer id) {
    return bankAccountService.getById(id);
  }

  @PutMapping("/account/{id}")
  public void updateAccount(@RequestBody BankAccountDto bankAccount) {
    bankAccountService.update(bankAccount);
  }

  @DeleteMapping("/account/{id}")
  public void deleteAccount(@PathVariable Integer id) {
    bankAccountService.deleteById(id);
  }

  @PostMapping("/accountCurrency")
  public void createAccountCurrency(@RequestBody BankAccountCurrencyDto bankAccountCurrencyDto) {
    bankAccountCurrencyService.create(bankAccountCurrencyDto);
  }

  @GetMapping("/accountCurrency/{id}")
  public BankAccountCurrencyDto getAccountCurrency(@PathVariable Integer accountId, @PathVariable Integer currencyId) {
    return bankAccountCurrencyService.getById(accountId,currencyId);
  }

  @PutMapping("/accountCurrency/{id}")
  public void updateAccountCurrency(@RequestBody BankAccountCurrencyDto bankAccountCurrencyDto) {
    bankAccountCurrencyService.update(bankAccountCurrencyDto);
  }

  @DeleteMapping("/accountCurrency/{id}")
  public void deleteAccountCurrency(@PathVariable Integer accountId, @PathVariable Integer currencyId) {
    bankAccountCurrencyService.deleteById(accountId,currencyId);
  }
}