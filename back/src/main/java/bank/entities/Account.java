package bank.entities;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "accounts")
public class Account {

    private @Id
    @GeneratedValue int id;
    @Column(name = "user_id")
    private int userId;
    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(
            name = "accountCurrency",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name="currency_id")}
    )
    Set<Currency> currencies = new HashSet<>();
    private String type;

    public Account() {
    }

    public Account(int userId, String type) {
        this.userId = userId;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
