package bank.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "currencyExchange")
public class CurrencyExchange {
    private @Id
    @GeneratedValue int id;
    private String name;
    private String surname;

    public CurrencyExchange(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public CurrencyExchange() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
