package kodlamaio.javahrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="curriculum_vitaes")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class CurriculumVitae {
    @Id
    @SequenceGenerator(name="seq_curriculumvitae",allocationSize = 1)
    @GeneratedValue(generator = "seq_curriculumvitae",strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private int id;

    @Column(name="github_link")
    private String githubLink;

    @Column(name="linkedin_link")
    private String linkedinLink;

    @Column(name="learning_technologies_or_programming_languages")
    private String learningTechnologiesOrProgrammingLanguages;

    @Column(name="cover_letter")
    private String coverLetter;

    @ManyToOne()
    @JoinColumn(name = "job_seeker_id")
    private JobSeeker jobSeeker;




}
