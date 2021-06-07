package kodlamaio.javahrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="job_seekers_images")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerImage {

    @Id
    @SequenceGenerator(name="seq_job_seekers_images",allocationSize = 1)
    @GeneratedValue(generator = "seq_job_seekers_images",strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private int id;

    @Column(name="image_url")
    private String imageUrl;

    @OneToOne()
    @JoinColumn(name = "jobSeeker_id")
    private JobSeeker jobSeeker;


}
