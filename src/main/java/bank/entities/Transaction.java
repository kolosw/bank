package bank.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "transactions")
public class Transaction {
    private @Id
    @GeneratedValue int id;

    private int sender_id;
    private int recipient_id;
    private java.sql.Date date;
    private java.sql.Time time;

    public Transaction() {
    }

    public Transaction(int sender_id, int recipient_id, Date date, Time time) {
        this.sender_id = sender_id;
        this.recipient_id = recipient_id;
        this.date = date;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSender_id() {
        return sender_id;
    }

    public void setSender_id(int sender_id) {
        this.sender_id = sender_id;
    }

    public int getRecipient_id() {
        return recipient_id;
    }

    public void setRecipient_id(int recipient_id) {
        this.recipient_id = recipient_id;
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
