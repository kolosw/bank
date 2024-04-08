package bank.dto;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

public class TransactionDto {
    private Integer id;

    private Integer senderId;
    private Integer recipientId;
    private java.sql.Date date;
    private java.sql.Time time;

    public TransactionDto() {
    }

    public TransactionDto(int id, Integer senderId, Integer recipientId, Date date, Time time) {
        this.id = id;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSenderId() {
        return senderId;
    }

    public void setSenderId(Integer senderId) {
        this.senderId = senderId;
    }

    public Integer getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Integer recipientId) {
        this.recipientId = recipientId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionDto that = (TransactionDto) o;
        return Objects.equals(id, that.id) && Objects.equals(senderId, that.senderId) && Objects.equals(recipientId, that.recipientId) && Objects.equals(date, that.date) && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, senderId, recipientId, date, time);
    }
}
