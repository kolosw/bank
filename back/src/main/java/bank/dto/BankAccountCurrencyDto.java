package bank.dto;

import bank.entities.BankAccount;
import bank.entities.Currency;

public class BankAccountCurrencyDto {
    private BankAccount account;
    private Currency currency;

    public BankAccountCurrencyDto(BankAccount account, Currency currency) {
        this.account = account;
        this.currency = currency;
    }

    public BankAccount getAccount() {
        return account;
    }

    public void setAccount(BankAccount account) {
        this.account = account;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

}
