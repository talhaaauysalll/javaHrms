package kodlamaio.javahrms.dataAccess.abstracts;

import kodlamaio.javahrms.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerDao extends JpaRepository<Employer,Integer> {
}
