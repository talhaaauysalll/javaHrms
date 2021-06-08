package kodlamaio.javahrms.entities.concretes;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="job_seekers_educations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerEducation {
    @Id
    @SequenceGenerator(name = "seq_job_seekers_educations",allocationSize = 1)
    @GeneratedValue(generator = "seq_job_seekers_educations",strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private int id;

    @Column(name = "school_name")
    private String schoolName;

    @Column(name = "department_at_school")
    private String departmentAtSchool;

    @Column(name="school_start_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private Date schoolStartDate;

    @Column(name = "school_end_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    private Date schoolEndDate;

    @ManyToOne()
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;
}
