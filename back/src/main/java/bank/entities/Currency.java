package bank.entities;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "currency")
public class Currency {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    private String name;
    private String shortname;
    private Character symbol;
    @OneToMany(mappedBy = "currency")
    private Set<BankAccountCurrency> accountAssoc;
    public Currency() {
    }

    public Currency(int id, String name, String shortname, Character symbol) {
        this.id = id;
        this.name = name;
        this.shortname = shortname;
        this.symbol = symbol;
    }

    public Currency(String name, String shortname, Character symbol) {
        this.name = name;
        this.shortname = shortname;
        this.symbol = symbol;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public Character getSymbol() {
        return symbol;
    }

    public void setSymbol(Character symbol) {
        this.symbol = symbol;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Currency currency = (Currency) o;
        return symbol == currency.symbol && Objects.equals(id, currency.id) && Objects.equals(name, currency.name) && Objects.equals(shortname, currency.shortname) && Objects.equals(accountAssoc, currency.accountAssoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortname, symbol, accountAssoc);
    }

    @Override
    public String toString() {
        return "Currency{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortname='" + shortname + '\'' +
                ", symbol=" + symbol +
                ", accountAssoc=" + accountAssoc +
                '}';
    }
}
