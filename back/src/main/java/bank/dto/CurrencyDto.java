package bank.dto;

public class CurrencyDto {
    private Integer id;
    private String name;
    private String shortname;
    private char symbol;
    public CurrencyDto() {
    }

    public CurrencyDto(int id, String name, String shortname, char symbol) {
        this.id = id;
        this.name = name;
        this.shortname = shortname;
        this.symbol = symbol;
    }

    public CurrencyDto(String name, String shortname, char symbol) {
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
