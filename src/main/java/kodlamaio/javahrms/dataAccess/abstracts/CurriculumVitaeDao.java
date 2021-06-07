package kodlamaio.javahrms.dataAccess.abstracts;

import kodlamaio.javahrms.entities.concretes.CurriculumVitae;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CurriculumVitaeDao extends JpaRepository<CurriculumVitae,Integer> {
    List<CurriculumVitae> findAllByJobSeekerId(int id);
}
