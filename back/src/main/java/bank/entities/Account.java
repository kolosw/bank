package bank.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "accounts")
public class Account {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(mappedBy = "account")
    private Set<AccountCurrency> currencyAssoc;
    private String type;

    public Account() {
    }

    public Account(User user, String type) {
        this.user = user;
        this.type = type;
    }


    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
