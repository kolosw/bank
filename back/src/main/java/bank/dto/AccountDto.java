package bank.dto;

import bank.entities.AccountCurrency;
import bank.entities.User;
import jakarta.persistence.*;

import java.util.Set;

public class AccountDto {

    private Integer id;
    private User user;
    private String type;

    public AccountDto() {
    }

    public AccountDto(User user, String type) {
        this.user = user;
        this.type = type;
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
