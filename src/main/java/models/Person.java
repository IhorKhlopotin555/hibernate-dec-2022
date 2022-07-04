package models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String bornDate;
    private long telephone;
    private String gmail;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idCode")
    @ToString.Exclude
    private IdCode idCode;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name="person_car",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id")
    )
    @ToString.Exclude
    private List<Car> cars;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "person_book",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> books;

    public Person(String name, String bornDate, int telephone, String gmail, IdCode idCode, List<Car> cars, List<Book> books) {
        this.name = name;
        this.bornDate = bornDate;
        this.telephone = telephone;
        this.gmail = gmail;
        this.idCode = idCode;
        this.cars = cars;
        this.books = books;
    }
}
