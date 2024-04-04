package bank;

import bank.dto.LoanApplicationDto;
import bank.repository.BankAccountCurrencyRepository;
import bank.repository.BankAccountRepository;
import bank.repository.CurrencyRepository;
import bank.repository.UserRepository;
import bank.service.BankAccountService;
import bank.service.LoanApplicationService;
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
    public CommandLineRunner demo(BankAccountService bankAccountService) {
        return (args) -> {
            //log.info(bankAccountService.getaccountList().toString());
            log.info("Running...");
            log.info("");
        };
    }
}
