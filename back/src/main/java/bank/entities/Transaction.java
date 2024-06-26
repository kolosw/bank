package bank.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "bank_transaction")
public class Transaction {
    private @Id
    @GeneratedValue Integer id;
    @Column(name = "id_sender", nullable = false)
    private Integer senderId;
    @Column(name = "id_recipient", nullable = false)
    private Integer recipientId;
    @Column(nullable = false)
    private java.sql.Date date;
    @Column(nullable = false)
    private java.sql.Time time;

    public Transaction() {
    }

    public Transaction(Integer id, Integer senderId, Integer recipientId, Date date, Time time) {
        this.id = id;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.date = date;
        this.time = time;
    }

    public Integer getId() {
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
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id) && Objects.equals(senderId, that.senderId) &&
                Objects.equals(recipientId, that.recipientId) && Objects.equals(date, that.date) && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, senderId, recipientId, date, time);
    }

}
