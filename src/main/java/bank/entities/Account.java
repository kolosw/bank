package bank.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {

    private @Id
    @GeneratedValue int id;
    @Column(name = "user_id")
    private int userId;
    private String type;

    public Account() {
    }

    public Account(int userId, String type) {
        this.userId = userId;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
