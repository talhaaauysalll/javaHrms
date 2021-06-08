package kodlamaio.javahrms.dataAccess.abstracts;

import kodlamaio.javahrms.core.utilities.results.DataResult;
import kodlamaio.javahrms.entities.concretes.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface JobSeekerDao extends JpaRepository<JobSeeker,Integer> {
    List<JobSeeker> findByNationalityId(String nationalityId);
    JobSeeker findById(int id);
    @Transactional
    @Modifying
    @Query("UPDATE JobSeeker jS set jS.firstName=?1,jS.lastName=?2,jS.birthYear=?3,jS.nationalityId=?4 where jS.id=?5")
    void update(String firstName,String lastName,int birthYear,String nationalityId,int id);
}
