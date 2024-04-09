package bank.dto;

public class BankAccountCurrencyDto {
    private BankAccountDto account;
    private CurrencyDto currency;
    private Integer balance;

    public BankAccountCurrencyDto() {
    }

    public BankAccountCurrencyDto(BankAccountDto account, CurrencyDto currency, Integer balance) {
        this.account = account;
        this.currency = currency;
        this.balance = balance;
    }

    public BankAccountDto getAccount() {
        return account;
    }

    public void setAccount(BankAccountDto account) {
        this.account = account;
    }

    public CurrencyDto getCurrency() {
        return currency;
    }

    public void setCurrency(CurrencyDto currency) {
        this.currency = currency;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
