package kodlamaio.javahrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="work_types")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})
public class WorkType {
    @Id
    @SequenceGenerator(name = "seq_work_types",allocationSize = 1)
    @GeneratedValue(generator = "seq_work_types",strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private int id;

    @Column(name="work_type_name")
    private String workTypesName;

    @OneToMany(mappedBy = "workType")
    private List<JobAdvertisement> jobAdvertisements;
}
