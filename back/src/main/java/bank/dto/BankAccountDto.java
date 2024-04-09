package bank.dto;

import java.util.Objects;

public class BankAccountDto {

    private Integer id;
    private Integer userId;
    private String type;

    public BankAccountDto() {
    }

    public BankAccountDto(Integer id, Integer user, String type, Integer balance) {
        this.id = id;
        this.userId = user;
        this.type = type;
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

}
