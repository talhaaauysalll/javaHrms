package kodlamaio.javahrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="work_times")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class WorkTime {
    @Id
    @SequenceGenerator(name = "seq_work_times",allocationSize = 1)
    @GeneratedValue(generator = "seq_work_times",strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private int id;

    @Column(name="work_time_name")
    private String workTimesName;

    @OneToMany(mappedBy = "workTime")
    private List<JobAdvertisement> jobAdvertisements;
}
