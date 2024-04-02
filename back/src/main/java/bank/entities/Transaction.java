package bank.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "bank_transaction")
public class Transaction {
    private @Id
    @GeneratedValue int id;

    @Column(name = "id_sender")
    private int senderId;
    @Column(name = "id_recipient")
    private int recipientId;
    private java.sql.Date date;
    private java.sql.Time time;

    public Transaction() {
    }

    public Transaction(int id, int senderId, int recipientId, Date date, Time time) {
        this.id = id;
        this.senderId = senderId;
        this.recipientId = recipientId;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public int getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(int recipientId) {
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
        return id == that.id && senderId == that.senderId && recipientId == that.recipientId && Objects.equals(date, that.date) && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, senderId, recipientId, date, time);
    }

}
