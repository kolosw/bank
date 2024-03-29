package bank;

import bank.entities.Account;
import bank.entities.AccountCurrency;
import bank.entities.Currency;
import bank.repository.AccountCurrencyRepository;
import bank.repository.AccountsRepository;
import bank.repository.CurrenciesRepository;
import bank.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class BankApplication {
    private static final Logger log = LoggerFactory.getLogger(BankApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(BankApplication.class, args);
    }
    @Bean
    public CommandLineRunner demo(UserRepository userRepository, AccountsRepository accountsRepository,
                                  CurrenciesRepository currenciesRepository, AccountCurrencyRepository accountCurrencyRepository) {
        return (args) -> {
            //accountsRepository.save(new Account(1,"Pension"));
            //currenciesRepository.save(new Currency("Belarussian Ruble","BYN",'B'));
            AccountCurrency accountCurrency = new AccountCurrency();
            //accountCurrency.setAccount(accountsRepository.getById(1));
            accountCurrency.setAccount(new Account(userRepository.getById(1),"Zarplata"));
            accountCurrency.setCurrency(new Currency("Tugrenik","TUG",'T'));
            //accountCurrency.setCurrency(currenciesRepository.getById(1));
            accountCurrency.setBalance(100);
            accountCurrencyRepository.save(accountCurrency);

            //accountCurrencyRepository.save(new AccountCurrency(accountsRepository.getById(1),currenciesRepository.getById(1),100));

            log.info("Running...");
            log.info(userRepository.getById(1).toString());
            log.info("");
        };
    }
}
