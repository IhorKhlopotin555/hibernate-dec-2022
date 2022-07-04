package models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int indentityCode;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name="person_libraryCard",
            joinColumns = @JoinColumn(name = "libraryCard_id"),
            inverseJoinColumns = @JoinColumn(name = "person_id")
    )
    private Person person;

    public LibraryCard(int indentityCode, Person person) {
        this.indentityCode = indentityCode;
        this.person = person;
    }
}
