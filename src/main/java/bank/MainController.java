package bank;

import bank.DAO.*;
import bank.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/bank")
public class MainController {

  @Autowired
  private UserDAO userDao;
  @Autowired
  private TransactionDAO transactionDao;
  @Autowired
  private CurrencyExchangeDAO currencyExchangeDAO;
  @Autowired
  private CurrenciesDAO currenciesDAO;
  @Autowired
  private BeneficiaryDAO beneficiaryDAO;
  @Autowired
  private AccountsDAO accountsDAO;
  @Autowired
  private AccountCurrencyDAO accountCurrencyDAO;

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

  @PostMapping("/transactions")
  public void createTransaction(@RequestBody Transaction transaction) {
    transactionDao.save(transaction);
  }

  @GetMapping("/transactions/{id}")
  public Transaction getTransaction(@PathVariable Integer id) {
    return transactionDao.getById(id);
  }

  @PutMapping("/transactions/{id}")
  public void updateTransaction(@PathVariable Integer id, @RequestBody Transaction transactions) {
    Transaction existingTransaction = transactionDao.getById(id);
    if (existingTransaction != null) {
      transactions.setId(id);
      transactionDao.update(transactions);
    }
  }

  @DeleteMapping("/transaction/{id}")
  public void deleteTransaction(@PathVariable Integer id) {
    Transaction transactions = transactionDao.getById(id);
    if (transactions != null) {
      transactionDao.delete(transactions);
    }
  }
  @PostMapping("/currencyExchange")
  public void createCurrencyExchange(@RequestBody CurrencyExchange currencyExchange) {
    currencyExchangeDAO.save(currencyExchange);
  }

  @GetMapping("/currencyExchange/{id}")
  public CurrencyExchange getCurrencyExchange(@PathVariable Integer id) {
    return currencyExchangeDAO.getById(id);
  }

  @PutMapping("/currencyExchange/{id}")
  public void updateCurrencyExchange(@PathVariable Integer id, @RequestBody CurrencyExchange curEx) {
    CurrencyExchange existingCurrencyExchange = currencyExchangeDAO.getById(id);
    if (existingCurrencyExchange != null) {
      curEx.setId(id);
      currencyExchangeDAO.update(curEx);
    }
  }

  @DeleteMapping("/currencyExchange/{id}")
  public void deleteCurrencyExchange(@PathVariable Integer id) {
    CurrencyExchange curEx = currencyExchangeDAO.getById(id);
    if (curEx != null) {
      currencyExchangeDAO.delete(curEx);
    }
  }
  @PostMapping("/currencies")
  public void createCurrency(@RequestBody Currencies currencies) {
    currenciesDAO.save(currencies);
  }

  @GetMapping("/currencies/{id}")
  public Currencies getCurrency(@PathVariable Integer id) {
    return currenciesDAO.getById(id);
  }

  @PutMapping("/currencies/{id}")
  public void updateCurrency(@PathVariable Integer id, @RequestBody Currencies currencies) {
    Currencies existingCurrencies = currenciesDAO.getById(id);
    if (existingCurrencies != null) {
      currencies.setId(id);
      currenciesDAO.update(currencies);
    }
  }

  @DeleteMapping("/currencies/{id}")
  public void deleteCurrency(@PathVariable Integer id) {
    Currencies currencies = currenciesDAO.getById(id);
    if (currencies != null) {
      currenciesDAO.delete(currencies);
    }
  }
  @PostMapping("/beneficiary")
  public void createBeneficiary(@RequestBody Beneficiary beneficiary) {
    beneficiaryDAO.save(beneficiary);
  }

  @GetMapping("/beneficiary/{id}")
  public Beneficiary getBeneficiary(@PathVariable Integer id) {
    return beneficiaryDAO.getById(id);
  }

  @PutMapping("/beneficiary/{id}")
  public void updateBeneficiary(@PathVariable Integer id, @RequestBody Beneficiary beneficiary) {
    Beneficiary existingBeneficiary = beneficiaryDAO.getById(id);
    if (existingBeneficiary != null) {
      beneficiary.setId(id);
      beneficiaryDAO.update(beneficiary);
    }
  }

  @DeleteMapping("/beneficiary/{id}")
  public void deleteBeneficiary(@PathVariable Integer id) {
    Beneficiary beneficiary = beneficiaryDAO.getById(id);
    if (beneficiary != null) {
      beneficiaryDAO.delete(beneficiary);
    }
  }
  @PostMapping("/accounts")
  public void createAccount(@RequestBody Accounts user) {
    accountsDAO.save(user);
  }

  @GetMapping("/accounts/{id}")
  public Accounts getAccount(@PathVariable Integer id) {
    return accountsDAO.getById(id);
  }

  @PutMapping("/accounts/{id}")
  public void updateAccount(@PathVariable Integer id, @RequestBody Accounts accounts) {
    Accounts existingAccount = accountsDAO.getById(id);
    if (existingAccount != null) {
      accounts.setId(id);
      accountsDAO.update(accounts);
    }
  }

  @DeleteMapping("/accounts/{id}")
  public void deleteAccount(@PathVariable Integer id) {
    Accounts accounts = accountsDAO.getById(id);
    if (accounts != null) {
      accountsDAO.delete(accounts);
    }
  }
  @PostMapping("/accountCurrency")
  public void createAccountCurrency(@RequestBody AccountCurrency accountCurrency) {
    accountCurrencyDAO.save(accountCurrency);
  }

  @GetMapping("/accountCurrency/{id}")
  public AccountCurrency getAccountCurrency(@PathVariable Integer id) {
    return accountCurrencyDAO.getById(id);
  }

  @PutMapping("/accountCurrency/{id}")
  public void updateAccountCurrency(@PathVariable Integer id, @RequestBody AccountCurrency accountCurrency) {
    AccountCurrency existingAccountCurrency = accountCurrencyDAO.getById(id);
    if (existingAccountCurrency != null) {
      accountCurrency.setId(id);
      accountCurrencyDAO.update(accountCurrency);
    }
  }

  @DeleteMapping("/accountCurrency/{id}")
  public void deleteAccountCurrency(@PathVariable Integer id) {
    AccountCurrency accountCurrency = accountCurrencyDAO.getById(id);
    if (accountCurrency != null) {
      accountCurrencyDAO.delete(accountCurrency);
    }
  }
}