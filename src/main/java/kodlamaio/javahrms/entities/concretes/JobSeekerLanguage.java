package kodlamaio.javahrms.entities.concretes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="job_seekers_languages")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerLanguage {
    @Id
    @SequenceGenerator(name="seq_job_seeker_language",allocationSize = 1)
    @GeneratedValue(generator = "seq_job_seeker_language",strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name="language_name")
    private String languageName;

    @Column(name = "language_level")
    private String languageLevel;

    @ManyToOne()
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;
}
