package kodlamaio.javahrms.dataAccess.abstracts;

import kodlamaio.javahrms.entities.concretes.WorkTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkTimeDao extends JpaRepository<WorkTime,Integer> {
}
