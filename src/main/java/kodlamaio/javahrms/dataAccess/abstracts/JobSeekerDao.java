package kodlamaio.javahrms.dataAccess.abstracts;

import kodlamaio.javahrms.core.utilities.results.DataResult;
import kodlamaio.javahrms.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobSeekerDao extends JpaRepository<JobSeeker,Integer> {
    List<JobSeeker> findByNationalityId(String nationalityId);
    JobSeeker findById(int id);
}
