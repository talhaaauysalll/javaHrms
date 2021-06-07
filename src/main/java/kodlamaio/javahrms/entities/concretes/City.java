package kodlamaio.javahrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="cities")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class City {
    @Id
    @SequenceGenerator(name = "seq_city",allocationSize = 1)
    @GeneratedValue(generator = "seq_city",strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private int id;

    @Column(name="city_name")
    private String cityName;

    @OneToMany(mappedBy = "city")
    private List<JobAdvertisement> jobAdvertisements;
}
