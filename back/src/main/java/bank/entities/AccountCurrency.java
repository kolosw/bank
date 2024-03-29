package bank.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "account_currency")
public class AccountCurrency{
    @ManyToOne
    @MapsId("account")
    private Account account;
    @ManyToOne
    @MapsId("currency")
    private Currency currency;
    @EmbeddedId
    private AccountCurrencyId id = new AccountCurrencyId();
    private int balance;

    public AccountCurrency(Account account, Currency currency, int balance) {
        this.account = account;
        this.currency = currency;
        this.balance = balance;
    }

    public AccountCurrency() {

    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

//    public AccountCurrencyId getId() {
//        return id;
//    }
//
//    public void setId(AccountCurrencyId id) {
//        this.id = id;
//    }
}
