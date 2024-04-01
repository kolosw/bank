package bank.controller;

import bank.dto.BankUserDto;
import bank.entities.*;
import bank.repository.*;
import bank.service.BankUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/bank")
public class MainController {

  @Autowired
  private BankUserService bankUserService;
  @Autowired
  private TransactionRepository transactionRepository;
  @Autowired
  private CurrencyExchangeRepository currencyExchangeRepository;
  @Autowired
  private CurrencyRepository currencyRepository;
  @Autowired
  private BankAccountsRepository bankAccountsRepository;

  @PostMapping("/users")
  public void createUser(@RequestBody BankUserDto user) {
    bankUserService.createUser(user);
  }

  @GetMapping("/users/{id}")
  public BankUserDto getUser(@PathVariable int id) {
    return bankUserService.getUserById(id);
  }

  @PutMapping("/users/{id}")
  public void updateUser(@PathVariable int id, @RequestBody BankUserDto user) {
    bankUserService.updateUser(user);
  }

  @DeleteMapping("/users/{id}")
  public void deleteUser(@PathVariable int id) {
    bankUserService.deleteUserById(id);
  }

  @PostMapping("/currencies")
  public void createCurrency(@RequestBody Currency currency) {
    currencyRepository.save(currency);
  }

  @GetMapping("/currencies/{id}")
  public Currency getCurrency(@PathVariable Integer id) {
    return currencyRepository.getById(id);
  }

  @PutMapping("/currencies/{id}")
  public void updateCurrency(@PathVariable Integer id, @RequestBody Currency currency) {
    Currency existingCurrency = currencyRepository.getById(id);
    if (existingCurrency != null) {
      currency.setId(id);
      currencyRepository.save(currency);
    }
  }

  @DeleteMapping("/currencies/{id}")
  public void deleteCurrency(@PathVariable Integer id) {
    Currency currency = currencyRepository.getById(id);
    if (currency != null) {
      currencyRepository.delete(currency);
    }
  }
  @PostMapping("/accounts")
  public void createAccount(@RequestBody BankAccount user) {
    bankAccountsRepository.save(user);
  }

  @GetMapping("/accounts/{id}")
  public BankAccount getAccount(@PathVariable Integer id) {
    return bankAccountsRepository.getById(id);
  }

  @PutMapping("/accounts/{id}")
  public void updateAccount(@PathVariable Integer id, @RequestBody BankAccount bankAccount) {
    BankAccount existingBankAccount = bankAccountsRepository.getById(id);
    if (existingBankAccount != null) {
      bankAccount.setId(id);
      bankAccountsRepository.save(bankAccount);
    }
  }

  @DeleteMapping("/accounts/{id}")
  public void deleteAccount(@PathVariable Integer id) {
    BankAccount bankAccount = bankAccountsRepository.getById(id);
    if (bankAccount != null) {
      bankAccountsRepository.delete(bankAccount);
    }
  }

}