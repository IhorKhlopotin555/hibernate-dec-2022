package models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_table")
@Getter
@Setter
@ToString(exclude = {"passport"})
public class User implements Serializable {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column(name = "username")
private String name;
@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
@PrimaryKeyJoinColumn

private Passport passport;

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public User(String name, Passport passport) {
        this.name = name;
        this.passport = passport;
    }
}
