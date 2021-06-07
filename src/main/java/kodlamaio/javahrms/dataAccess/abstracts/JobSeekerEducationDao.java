package kodlamaio.javahrms.dataAccess.abstracts;


import kodlamaio.javahrms.entities.concretes.JobSeekerEducation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobSeekerEducationDao extends JpaRepository<JobSeekerEducation, Integer> {
    JobSeekerEducation findById(int id);
    List<JobSeekerEducation> findAllByJobSeekerIdOrderBySchoolEndDateDesc(int id);
    List<JobSeekerEducation> findAllByJobSeekerId(int id);
}
