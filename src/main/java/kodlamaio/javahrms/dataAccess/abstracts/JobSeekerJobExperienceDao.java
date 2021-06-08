package kodlamaio.javahrms.dataAccess.abstracts;

import kodlamaio.javahrms.entities.concretes.JobSeekerJobExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface JobSeekerJobExperienceDao extends JpaRepository<JobSeekerJobExperience,Integer> {
    JobSeekerJobExperience findById(int id);
    List<JobSeekerJobExperience> findAllByJobSeekerIdOrderByJobEndDateDesc(int id);
    List<JobSeekerJobExperience> findAllByJobSeekerId(int id);

    @Transactional
    @Modifying
    @Query("UPDATE JobSeekerJobExperience jE SET jE.workPlaceName=?1, jE.positionAtWork=?2, jE.jobStartDate=?3,jE.jobEndDate=?4 where jE.id=?5")
    void update(String workPlaceName, String positionAtWork, Date jobStartDate, Date jobEndDate,int id);
}
