package bank.entities;

import jakarta.persistence.*;

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

    public BankAccountCurrency(BankAccount bankAccount, Currency currency) {
        this.bankAccount = bankAccount;
        this.currency = currency;
    }

    public BankAccountCurrency() {

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

}
