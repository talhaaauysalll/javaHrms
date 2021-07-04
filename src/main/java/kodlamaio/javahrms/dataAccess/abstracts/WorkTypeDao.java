package kodlamaio.javahrms.dataAccess.abstracts;

import kodlamaio.javahrms.entities.concretes.WorkType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkTypeDao extends JpaRepository<WorkType,Integer> {
}
