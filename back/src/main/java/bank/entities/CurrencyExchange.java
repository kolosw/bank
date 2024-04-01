package bank.entities;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "currency_exchange")
public class CurrencyExchange {
    private @Id
    @GeneratedValue int id;
    @Column(name = "from_id")
    private Integer from;
    @Column(name = "to_id")
    private Integer to;

    private Float amount;

    public CurrencyExchange(int id, Integer from, Integer to, Float amount) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public CurrencyExchange() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
}
