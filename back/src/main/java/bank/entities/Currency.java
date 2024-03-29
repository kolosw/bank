package bank.entities;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "currencies")
public class Currency {
    private @Id
    @GeneratedValue int id;
    private String name;
    private String shortname;
    private char symbol;
    @ManyToMany(mappedBy = "currencies")
    private Set<Account> accounts = new HashSet<>();
    public Currency() {
    }

    public Currency(String name, String shortname, char symbol) {
        this.name = name;
        this.shortname = shortname;
        this.symbol = symbol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
