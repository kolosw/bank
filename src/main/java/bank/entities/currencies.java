package bank.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "currencies")
public class currencies {
    private @Id
    @GeneratedValue int id;
    private String name;
    private String shortname;
    private char symbol;
}
