package bank.entities;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "currencies")
public class Currency {
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    private String name;
    private String shortname;
    private char symbol;
    @OneToMany(mappedBy = "currency")
    private Set<AccountCurrency> accountAssoc;
    public Currency() {
    }

    public Currency(int id, String name, String shortname, char symbol) {
        this.id = id;
        this.name = name;
        this.shortname = shortname;
        this.symbol = symbol;
    }

    public Currency(String name, String shortname, char symbol) {
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

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

}
