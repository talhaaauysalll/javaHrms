package kodlamaio.javahrms.dataAccess.abstracts;

import kodlamaio.javahrms.entities.concretes.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface EmployerDao extends JpaRepository<Employer,Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE Employer e set e.companyName=?1,e.phoneNumber=?2,e.webSite=?3 where e.id=?4")
    void update(String companyName,String phoneNumber,String webSite,int id);
}
