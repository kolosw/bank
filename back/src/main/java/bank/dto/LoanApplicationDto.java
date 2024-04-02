package bank.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class LoanApplicationDto {
    Integer id;
    Integer bankAccountId;
    Integer amount;
    Integer interest;
    Integer period;

    public LoanApplicationDto() {
    }

    public LoanApplicationDto(Integer id, Integer bankAccountId, Integer amount, Integer interest, Integer period) {
        this.id = id;
        this.bankAccountId = bankAccountId;
        this.amount = amount;
        this.interest = interest;
        this.period = period;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(Integer bankAccountId) {
        this.bankAccountId = bankAccountId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getInterest() {
        return interest;
    }

    public void setInterest(Integer interest) {
        this.interest = interest;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }
}
