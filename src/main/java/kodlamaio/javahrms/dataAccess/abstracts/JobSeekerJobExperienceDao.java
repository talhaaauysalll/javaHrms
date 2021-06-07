package kodlamaio.javahrms.dataAccess.abstracts;

import kodlamaio.javahrms.entities.concretes.JobSeekerJobExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobSeekerJobExperienceDao extends JpaRepository<JobSeekerJobExperience,Integer> {
    JobSeekerJobExperience findById(int id);
    List<JobSeekerJobExperience> findAllByJobSeekerIdOrderByJobEndDateDesc(int id);
    List<JobSeekerJobExperience> findAllByJobSeekerId(int id);
}
