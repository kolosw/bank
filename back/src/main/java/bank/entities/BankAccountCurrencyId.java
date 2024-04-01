package bank.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BankAccountCurrencyId implements Serializable {
    @Column(name = "bank_account_id")
    private Integer account;
    @Column(name = "currency_id")
    private Integer currency;

    public BankAccountCurrencyId() {
    }

    public BankAccountCurrencyId(Integer account, Integer currency) {
        this.account = account;
        this.currency = currency;
    }

    public int getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public int getCurrency() {
        return currency;
    }

    public void setCurrency(Integer currency) {
        this.currency = currency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccountCurrencyId that = (BankAccountCurrencyId) o;
        return Objects.equals(account, that.account) && Objects.equals(currency, that.currency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, currency);
    }
}
