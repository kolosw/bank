package bank.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "accountCurrency")
public class AccountCurrency {

    @Id
    @Column(name="account_id")
    private int accountId;
    @Id
    @Column(name="currency_id")
    private int currencyId;
    private int balance;

    public AccountCurrency() {
    }

    public AccountCurrency(int accountId, int currencyId, int balance) {
        this.accountId = accountId;
        this.currencyId = currencyId;
        this.balance = balance;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(int currencyId) {
        this.currencyId = currencyId;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
