package bank.dto;

import bank.entities.User;

public class BankAccountDto {

    private Integer id;
    private User user;
    private String type;
    private Integer balance;

    public BankAccountDto() {
    }

    public BankAccountDto(Integer id, User user, String type, Integer balance) {
        this.id = id;
        this.user = user;
        this.type = type;
        this.balance = balance;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
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


}
