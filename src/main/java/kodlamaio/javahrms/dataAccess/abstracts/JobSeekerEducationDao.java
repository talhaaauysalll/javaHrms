package kodlamaio.javahrms.dataAccess.abstracts;


import kodlamaio.javahrms.entities.concretes.JobSeekerEducation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface JobSeekerEducationDao extends JpaRepository<JobSeekerEducation, Integer> {
    JobSeekerEducation findByJobSeekerId(int id);
    JobSeekerEducation findById(int id);
    List<JobSeekerEducation> findAllByJobSeekerIdOrderBySchoolEndDateDesc(int id);
    List<JobSeekerEducation> findAllByJobSeekerId(int id);

    @Transactional
    @Modifying
    @Query("UPDATE JobSeekerEducation jE set jE.schoolName=?1, jE.departmentAtSchool=?2, jE.schoolStartDate=?3,jE.schoolEndDate=?4 where jE.id=?5")
    void update(String schoolName, String departmentAtSchool, Date schoolStartDate,Date schoolEndDate,int id);

}
