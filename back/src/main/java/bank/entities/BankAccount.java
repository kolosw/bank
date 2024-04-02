package bank.entities;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "bank_account")
public class BankAccount {

    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
    @OneToMany(mappedBy = "bankAccount")
    private Set<BankAccountCurrency> currencyAssoc;
    @Column(name = "account_type")
    private String type;
    private Integer balance;

    public BankAccount() {
    }

    public BankAccount(Integer id,User user, String type, Integer balance) {
        this.id = id;
        this.user = user;
        this.type = type;
        this.balance = balance;
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

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccount that = (BankAccount) o;
        return Objects.equals(id, that.id) && Objects.equals(user, that.user) && Objects.equals(currencyAssoc, that.currencyAssoc) && Objects.equals(type, that.type) && Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, currencyAssoc, type, balance);
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "id=" + id +
                ", user=" + user +
                ", currencyAssoc=" + currencyAssoc +
                ", type='" + type + '\'' +
                ", balance=" + balance +
                '}';
    }
}
