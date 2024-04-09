package bank.entities;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "bank_account")
public class BankAccount {

    private @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    @OneToMany(mappedBy = "bankAccount")
    private Set<BankAccountCurrency> currencyAssoc;
    @Column(name = "account_type", nullable = false)
    private String type;

    public BankAccount() {
    }

    public BankAccount(Integer id,User user, String type) {
        this.id = id;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Objects.equals(id, that.id) && Objects.equals(user, that.user) && Objects.equals(currencyAssoc, that.currencyAssoc) && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, currencyAssoc, type);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", user=" + user +
                ", currencyAssoc=" + currencyAssoc +
                ", type='" + type + '\'' +
                '}';
    }
}
