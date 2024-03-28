package bank.entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "transactions")
public class Transaction {
    private @Id
    @GeneratedValue int id;

    @Column(name = "sender_id")
    private int senderId;
    @Column(name = "recipient_id")
    private int recipientId;
    private java.sql.Date date;
    private java.sql.Time time;

    public Transaction() {
    }

    public Transaction(int senderId, int recipientId, Date date, Time time) {
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
}
