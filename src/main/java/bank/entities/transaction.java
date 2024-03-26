package bank.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "transactions")
public class transaction {
    private @Id
    @GeneratedValue int id;

    private int sender_id;
    private int recipient_id;
    private java.sql.Date date;
    private java.sql.Time time;

}
