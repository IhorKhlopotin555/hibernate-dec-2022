package models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="owner_cars",
            joinColumns = @JoinColumn(name = "owner_id"),
            inverseJoinColumns = @JoinColumn(name = "car_id")
    )
    private List<Car> cars;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "d_license_id")
    private DriverLicense driverLicense;

    public Owner(String name, List<Car> cars, DriverLicense driverLicense) {
        this.name = name;
        this.cars = cars;
        this.driverLicense = driverLicense;
    }
}
