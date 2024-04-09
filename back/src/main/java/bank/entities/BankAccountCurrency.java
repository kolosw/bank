package bank.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "bank_account_currency")
public class BankAccountCurrency {
    @ManyToOne
    @MapsId("account")
    private BankAccount bankAccount;
    @ManyToOne
    @MapsId("currency")
    private Currency currency;
    @EmbeddedId
    private BankAccountCurrencyId id = new BankAccountCurrencyId();
    private Integer balance;
    public BankAccountCurrency(BankAccount bankAccount, Currency currency, Integer balance) {
        this.bankAccount = bankAccount;
        this.currency = currency;
        this.balance = balance;
    }

    public BankAccountCurrency() {

    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public BankAccountCurrencyId getId() {
        return id;
    }

    public void setId(BankAccountCurrencyId id) {
        this.id = id;
    }

    public BankAccount getAccount() {
        return bankAccount;
    }

    public void setAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccountCurrency that = (BankAccountCurrency) o;
        return Objects.equals(bankAccount, that.bankAccount) && Objects.equals(currency, that.currency) && Objects.equals(id, that.id) && Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankAccount, currency, id, balance);
    }
}
