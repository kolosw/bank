package bank.dto;

import java.util.Objects;

public class BankAccountDto {

    private Integer id;
    private Integer userId;
    private String type;
    private Integer balance;

    public BankAccountDto() {
    }

    public BankAccountDto(Integer id, Integer user, String type, Integer balance) {
        this.id = id;
        this.userId = user;
        this.type = type;
        this.balance = balance;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankAccountDto that = (BankAccountDto) o;
        return Objects.equals(id, that.id) && Objects.equals(userId, that.userId) && Objects.equals(type, that.type) && Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, type, balance);
    }

    @Override
    public String toString() {
        return "BankAccountDto{" +
                "id=" + id +
                ", userId=" + userId +
                ", type='" + type + '\'' +
                ", balance=" + balance +
                '}';
    }
}
