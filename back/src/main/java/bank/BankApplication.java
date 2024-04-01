package bank;

import bank.entities.User;
import bank.repository.BankAccountCurrencyRepository;
import bank.repository.BankAccountsRepository;
import bank.repository.CurrencyRepository;
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
    public CommandLineRunner demo(UserRepository userRepository, BankAccountsRepository bankAccountsRepository,
                                  CurrencyRepository currencyRepository, BankAccountCurrencyRepository bankAccountCurrencyRepository) {
        return (args) -> {
            userRepository.save(new User("Jekos","Kolosowski","sabacka@gmmail.com","123456"));
            log.info("Running...");
            log.info(userRepository.getById(1).toString());
            log.info("");
        };
    }
}
