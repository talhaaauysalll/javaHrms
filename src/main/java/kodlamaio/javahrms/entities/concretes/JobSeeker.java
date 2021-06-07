package kodlamaio.javahrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kodlamaio.javahrms.core.entities.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@PrimaryKeyJoinColumn(name = "user_id",referencedColumnName = "id")
@Data
@Entity
@Table(name="job_seekers")
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class JobSeeker extends User {
    @Column(name="first_name")
    @NotBlank(message = "Bu alan boş bırakılamaz")
    private String firstName;

    @Column(name="last_name")
    @NotBlank(message = "Bu alan boş bırakılamaz")
    private String lastName;

    @Column(name="nationality_id")
    @NotBlank(message = "Bu alan boş bırakılamaz")
    private String nationalityId;

    @Column(name="birthYear")
    private int birthYear;

    @NotBlank(message = "Bu alan boş bırakılamaz")
    private String passwordRepeat;

    @JsonIgnore
    @OneToMany(mappedBy = "jobSeeker")
    private List<CurriculumVitae> curriculumVitaeList;

    @JsonIgnore
    @OneToOne(mappedBy = "jobSeeker")
    private JobSeekerImage jobSeekerImage;

    @JsonIgnore
    @OneToMany(mappedBy = "jobSeeker")
    private List<JobSeekerEducation> jobSeekerEducations;

    @JsonIgnore
    @OneToMany(mappedBy = "jobSeeker")
    private List<JobSeekerJobExperience> jobSeekerJobExperiences;

    @JsonIgnore
    @OneToMany(mappedBy = "jobSeeker")
    private List<JobSeekerLanguage> jobSeekerLanguages;
}
