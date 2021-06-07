package kodlamaio.javahrms.entities.concretes;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="job_seekers_work_experiences")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerJobExperience {

    @Id
    @SequenceGenerator(name = "seq_job_seekers_job_experience",allocationSize = 1)
    @GeneratedValue(generator = "seq_job_seekers_job_experience",strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private int id;

    @Column(name = "work_place_name")
    private String workPlaceName;

    @Column(name="position_at_work")
    private String positionAtWork;

    @Column(name="job_start_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private Date jobStartDate;

    @Column(name = "job_end_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private Date jobEndDate;

    @ManyToOne()
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;


}
