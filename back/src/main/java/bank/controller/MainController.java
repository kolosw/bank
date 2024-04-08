package bank.controller;

import bank.dto.BankAccountCurrencyDto;
import bank.dto.BankAccountDto;
import bank.dto.UserDto;
import bank.dto.CurrencyDto;
import bank.entities.Currency;
import bank.entities.User;
import bank.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
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
  public void createUser(@RequestBody UserDto user) {
    userService.create(user);
  }

  @GetMapping("/users/{id}")
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

  @GetMapping("/currency")
  @ResponseStatus(value = HttpStatus.OK)
  public List<Currency> findAllCurrency() {
    return this.currencyService.getCurrencyList();
  }
  @PostMapping("/currency")
  public void createCurrency(@RequestBody CurrencyDto currency) { currencyService.create(currency);}

  @GetMapping("/currency/{id}")
  public CurrencyDto getCurrency(@PathVariable Integer id) {
    return currencyService.getById(id);
  }

  @PutMapping("/currency/{id}")
  public void updateCurrency(@PathVariable Integer id, @RequestBody CurrencyDto currency) {
    currencyService.update(id, currency);
  }

  @DeleteMapping("/currency/{id}")
  public void deleteCurrency(@PathVariable Integer id) {
    currencyService.deleteById(id);
  }
  @GetMapping("/account")
  @ResponseStatus(value = HttpStatus.OK)
  public List<BankAccountDto> findAllAccount() {return this.bankAccountService.getaccountList();  }
  @PostMapping("/account")
  public void createAccount(@RequestBody BankAccountDto bankAccountDto) {
    System.out.println(bankAccountDto);
    bankAccountService.create(bankAccountDto);
  }

  @GetMapping("/account/{id}")
  public BankAccountDto getAccount(@PathVariable Integer id) {
    return bankAccountService.getById(id);
  }

  @PutMapping("/account/{id}")
  public void updateAccount(@PathVariable Integer id, @RequestBody BankAccountDto bankAccount) {
    bankAccountService.update(id, bankAccount);
  }

  @DeleteMapping("/account/{id}")
  public void deleteAccount(@PathVariable Integer id) {
    bankAccountService.deleteById(id);
  }

  @GetMapping("/accountcurrency")
  @ResponseStatus(value = HttpStatus.OK)
  public List<BankAccountCurrencyDto> findAllAccountCurrency() {
    return this.bankAccountCurrencyService.getAccountCurrencyList();
  }
  @PostMapping("/accountcurrency")
  public void createAccountCurrency(@RequestBody BankAccountCurrencyDto bankAccountCurrencyDto) {
    bankAccountCurrencyService.create(bankAccountCurrencyDto);
  }

  @PutMapping("/accountcurrency/{idAccount}/{idCurrency}")
  public void createAccountCurrency(@PathVariable Integer idAccount, @PathVariable Integer idCurrency) {
    bankAccountCurrencyService.createWithIds(idAccount,idCurrency);
  }
  @GetMapping("/accountcurrency/{idAccount}/{idCurrency}")
  public BankAccountCurrencyDto getAccountCurrency(@PathVariable Integer idAccount, @PathVariable Integer idCurrency) {
    return bankAccountCurrencyService.getById(idAccount,idCurrency);
  }

//  @PutMapping("/accountcurrency/{idAccount}/{idCurrency}")
//  public void updateAccountCurrency(@PathVariable Integer idAccount, @PathVariable Integer idCurrency, @RequestBody BankAccountCurrencyDto bankAccountCurrencyDto) {
//    bankAccountCurrencyService.update(idAccount, idCurrency, bankAccountCurrencyDto);
//  }

  @DeleteMapping("/accountcurrency/{accountId}/{currencyId}")
  public void deleteAccountCurrency(@PathVariable Integer accountId, @PathVariable Integer currencyId) {
    bankAccountCurrencyService.deleteById(accountId,currencyId);
  }
}