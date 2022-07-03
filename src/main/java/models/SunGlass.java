package models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class SunGlass implements Serializable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private  int id;
private String brand;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "sq_user",
            joinColumns = @JoinColumn(name = "sg_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
private List<User> users;

    public SunGlass(String brand) {
        this.brand = brand;
    }

    public SunGlass(String brand, List<User> users) {
        this.brand = brand;
        this.users = users;
    }
}
