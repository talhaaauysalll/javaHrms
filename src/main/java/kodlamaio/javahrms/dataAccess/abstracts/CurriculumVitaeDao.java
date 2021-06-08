package kodlamaio.javahrms.dataAccess.abstracts;

import kodlamaio.javahrms.entities.concretes.CurriculumVitae;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CurriculumVitaeDao extends JpaRepository<CurriculumVitae,Integer> {
    List<CurriculumVitae> findAllByJobSeekerId(int id);
    @Transactional
    @Modifying
    @Query("UPDATE CurriculumVitae cV set cV.coverLetter=?1,cV.githubLink=?2, cV.linkedinLink=?3,cV.learningTechnologiesOrProgrammingLanguages=?4 where cV.id=?5")
    void update(String coverLetter,String githubLink,String linkedinLink,String learningTechnologiesOrProgrammingLanguages,int id);
}
