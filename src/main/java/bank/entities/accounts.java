package bank.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
public class accounts {
    private @Id
    @GeneratedValue int id;
    private int user_id;
    private String type;
}
