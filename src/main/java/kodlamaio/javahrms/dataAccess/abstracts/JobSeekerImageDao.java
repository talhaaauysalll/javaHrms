package kodlamaio.javahrms.dataAccess.abstracts;

import kodlamaio.javahrms.entities.concretes.JobSeekerImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerImageDao extends JpaRepository<JobSeekerImage,Integer> {
    JobSeekerImage findByJobSeekerId(int id);
    JobSeekerImage findById(int id);
}
