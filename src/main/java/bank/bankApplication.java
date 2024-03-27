package bank;

import bank.DAO.UserDAO;
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
    public CommandLineRunner demo(UserDAO repository) {
        return (args) -> {
            // save a few customers
            //repository.save(new User("Jekos", "Kolosowski", "sabacka@mail.ru", "Jo74pa"));
            log.info(repository.getById(1).toString());
            log.info("");
        };
    }
}
