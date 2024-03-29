package bank.dto;

public class AccountCurrencyDto {
    private Integer accountId;
    private Integer currencyId;
    private Integer balance;

    public AccountCurrencyDto(Integer accountId, Integer currencyId, Integer balance) {
        this.accountId = accountId;
        this.currencyId = currencyId;
        this.balance = balance;
    }

    public AccountCurrencyDto() {
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
