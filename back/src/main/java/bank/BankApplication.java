package bank;

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
    public CommandLineRunner demo(UserRepository repository) {
        return (args) -> {
            log.info("Running...");
            log.info(repository.getById(1).toString());
            log.info("");
        };
    }
}
