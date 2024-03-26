package bank.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "accountCurrency")
public class accountCurrency {
    private @Id
    @GeneratedValue int id;
    private int account_id;
    private int currency_id;
    private int balance;
}
