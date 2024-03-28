package bank;

import bank.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@SpringBootApplication
public class bankApplication {
    private static final Logger log = LoggerFactory.getLogger(bankApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(bankApplication.class, args);
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
