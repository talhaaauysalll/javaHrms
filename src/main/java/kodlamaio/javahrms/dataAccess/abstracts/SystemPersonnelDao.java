package kodlamaio.javahrms.dataAccess.abstracts;

import kodlamaio.javahrms.entities.concretes.SystemPersonnel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SystemPersonnelDao extends JpaRepository<SystemPersonnel,Integer> {
}
