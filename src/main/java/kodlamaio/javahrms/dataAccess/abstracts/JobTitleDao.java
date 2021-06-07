package kodlamaio.javahrms.dataAccess.abstracts;

import kodlamaio.javahrms.entities.concretes.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobTitleDao extends JpaRepository<JobTitle,Integer> {
    List<JobTitle> findByJobTitleName(String jobTitleName);
}
