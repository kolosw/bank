package bank.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class user {

private @Id @GeneratedValue int id;
private String name;
private String surname;

private String email;
private String password;
}
