package models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class IdCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int idcode;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Person person;

    public IdCode(int idcode) {
        this.idcode = idcode;
    }
}
