package kodlamaio.javahrms.dataAccess.abstracts;

import kodlamaio.javahrms.entities.concretes.JobSeekerLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface JobSeekerLanguageDao extends JpaRepository<JobSeekerLanguage,Integer> {
    JobSeekerLanguage findById(int id);
    List<JobSeekerLanguage> findAllByJobSeekerId(int id);
    @Transactional
    @Modifying
    @Query("UPDATE JobSeekerLanguage jL set jL.languageName=?1,jL.languageLevel=?2 where jL.id=?3")
    void update(String languageName,String languageLevel,int id);
}
