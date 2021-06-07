package kodlamaio.javahrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="job_advertisements")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisement {
    @Id
    @SequenceGenerator(name = "seq_job_advertisement",allocationSize = 1)
    @GeneratedValue(generator = "seq_job_advertisement",strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;

    @ManyToOne()
    @JoinColumn(name = "job_title_id",nullable = false)
    private JobTitle jobTitle;

    @ManyToOne()
    @JoinColumn(name="employer_id",nullable = false)
    private Employer employer;

    @ManyToOne()
    @JoinColumn(name="city_id",nullable = false)
    private City city;

    @Column(name = "min_salary")
    private double minSalary;

    @Column(name="max_salary")
    private double maxSalary;

    @Column(name="number_of_open_positions",nullable = false)
    private int numberOfOpenPositions;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    @Column(name="application_deadline")
    private Date applicationDeadline;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "dd-MM-yyyy")
    @Column(name="release_date")
    private Date releaseDate;

    @Column(name="is_active",nullable = false)
    private boolean isActive;
}
