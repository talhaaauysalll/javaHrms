package kodlamaio.javahrms.dataAccess.abstracts;

import kodlamaio.javahrms.entities.concretes.JobSeekerLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobSeekerLanguageDao extends JpaRepository<JobSeekerLanguage,Integer> {
    JobSeekerLanguage findById(int id);
    List<JobSeekerLanguage> findAllByJobSeekerId(int id);
}
