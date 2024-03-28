package bank.controller;

import bank.repository.*;
import bank.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/bank")
public class MainController {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private TransactionRepository transactionRepository;
  @Autowired
  private CurrencyExchangeRepository currencyExchangeRepository;
  @Autowired
  private CurrenciesRepository currenciesRepository;
  @Autowired
  private BeneficiaryRepository beneficiaryRepository;
  @Autowired
  private AccountsRepository accountsRepository;
  @Autowired
  private AccountCurrencyRepository accountCurrencyRepository;

  @PostMapping("/users")
  public void createUser(@RequestBody User user) {
    userRepository.save(user);
  }

  @GetMapping("/users/{id}")
  public User getUser(@PathVariable Integer id) {
    return userRepository.getById(id);
  }

  @PutMapping("/users/{id}")
  public void updateUser(@PathVariable Integer id, @RequestBody User user) {
    User existingUser = userRepository.getById(id);
    if (existingUser != null) {
      user.setId(id);
      userRepository.update(user);
    }
  }

  @DeleteMapping("/users/{id}")
  public void deleteUser(@PathVariable Integer id) {
    User user = userRepository.getById(id);
    if (user != null) {
      userRepository.delete(user);
    }
  }

  @PostMapping("/transactions")
  public void createTransaction(@RequestBody Transaction transaction) {
    transactionRepository.save(transaction);
  }

  @GetMapping("/transactions/{id}")
  public Transaction getTransaction(@PathVariable Integer id) {
    return transactionRepository.getById(id);
  }

  @PutMapping("/transactions/{id}")
  public void updateTransaction(@PathVariable Integer id, @RequestBody Transaction transactions) {
    Transaction existingTransaction = transactionRepository.getById(id);
    if (existingTransaction != null) {
      transactions.setId(id);
      transactionRepository.update(transactions);
    }
  }

  @DeleteMapping("/transaction/{id}")
  public void deleteTransaction(@PathVariable Integer id) {
    Transaction transactions = transactionRepository.getById(id);
    if (transactions != null) {
      transactionRepository.delete(transactions);
    }
  }
  @PostMapping("/currencyExchange")
  public void createCurrencyExchange(@RequestBody CurrencyExchange currencyExchange) {
    currencyExchangeRepository.save(currencyExchange);
  }

  @GetMapping("/currencyExchange/{id}")
  public CurrencyExchange getCurrencyExchange(@PathVariable Integer id) {
    return currencyExchangeRepository.getById(id);
  }

  @PutMapping("/currencyExchange/{id}")
  public void updateCurrencyExchange(@PathVariable Integer id, @RequestBody CurrencyExchange curEx) {
    CurrencyExchange existingCurrencyExchange = currencyExchangeRepository.getById(id);
    if (existingCurrencyExchange != null) {
      curEx.setId(id);
      currencyExchangeRepository.update(curEx);
    }
  }

  @DeleteMapping("/currencyExchange/{id}")
  public void deleteCurrencyExchange(@PathVariable Integer id) {
    CurrencyExchange curEx = currencyExchangeRepository.getById(id);
    if (curEx != null) {
      currencyExchangeRepository.delete(curEx);
    }
  }
  @PostMapping("/currencies")
  public void createCurrency(@RequestBody Currencies currencies) {
    currenciesRepository.save(currencies);
  }

  @GetMapping("/currencies/{id}")
  public Currencies getCurrency(@PathVariable Integer id) {
    return currenciesRepository.getById(id);
  }

  @PutMapping("/currencies/{id}")
  public void updateCurrency(@PathVariable Integer id, @RequestBody Currencies currencies) {
    Currencies existingCurrencies = currenciesRepository.getById(id);
    if (existingCurrencies != null) {
      currencies.setId(id);
      currenciesRepository.update(currencies);
    }
  }

  @DeleteMapping("/currencies/{id}")
  public void deleteCurrency(@PathVariable Integer id) {
    Currencies currencies = currenciesRepository.getById(id);
    if (currencies != null) {
      currenciesRepository.delete(currencies);
    }
  }
  @PostMapping("/beneficiary")
  public void createBeneficiary(@RequestBody Beneficiary beneficiary) {
    beneficiaryRepository.save(beneficiary);
  }

  @GetMapping("/beneficiary/{id}")
  public Beneficiary getBeneficiary(@PathVariable Integer id) {
    return beneficiaryRepository.getById(id);
  }

  @PutMapping("/beneficiary/{id}")
  public void updateBeneficiary(@PathVariable Integer id, @RequestBody Beneficiary beneficiary) {
    Beneficiary existingBeneficiary = beneficiaryRepository.getById(id);
    if (existingBeneficiary != null) {
      beneficiary.setId(id);
      beneficiaryRepository.update(beneficiary);
    }
  }

  @DeleteMapping("/beneficiary/{id}")
  public void deleteBeneficiary(@PathVariable Integer id) {
    Beneficiary beneficiary = beneficiaryRepository.getById(id);
    if (beneficiary != null) {
      beneficiaryRepository.delete(beneficiary);
    }
  }
  @PostMapping("/accounts")
  public void createAccount(@RequestBody Accounts user) {
    accountsRepository.save(user);
  }

  @GetMapping("/accounts/{id}")
  public Accounts getAccount(@PathVariable Integer id) {
    return accountsRepository.getById(id);
  }

  @PutMapping("/accounts/{id}")
  public void updateAccount(@PathVariable Integer id, @RequestBody Accounts accounts) {
    Accounts existingAccount = accountsRepository.getById(id);
    if (existingAccount != null) {
      accounts.setId(id);
      accountsRepository.update(accounts);
    }
  }

  @DeleteMapping("/accounts/{id}")
  public void deleteAccount(@PathVariable Integer id) {
    Accounts accounts = accountsRepository.getById(id);
    if (accounts != null) {
      accountsRepository.delete(accounts);
    }
  }
  @PostMapping("/accountCurrency")
  public void createAccountCurrency(@RequestBody AccountCurrency accountCurrency) {
    accountCurrencyRepository.save(accountCurrency);
  }

  @GetMapping("/accountCurrency/{id}")
  public AccountCurrency getAccountCurrency(@PathVariable Integer id) {
    return accountCurrencyRepository.getById(id);
  }

  @PutMapping("/accountCurrency/{id}")
  public void updateAccountCurrency(@PathVariable Integer id, @RequestBody AccountCurrency accountCurrency) {
    AccountCurrency existingAccountCurrency = accountCurrencyRepository.getById(id);
    if (existingAccountCurrency != null) {
      accountCurrency.setId(id);
      accountCurrencyRepository.update(accountCurrency);
    }
  }

  @DeleteMapping("/accountCurrency/{id}")
  public void deleteAccountCurrency(@PathVariable Integer id) {
    AccountCurrency accountCurrency = accountCurrencyRepository.getById(id);
    if (accountCurrency != null) {
      accountCurrencyRepository.delete(accountCurrency);
    }
  }
}