package models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class DriverLicense {
    @Id
    @GeneratedValue(strategy  =GenerationType.IDENTITY)
    private int id;
    private String series;

    public DriverLicense(String series) {
        this.series = series;
    }
}
