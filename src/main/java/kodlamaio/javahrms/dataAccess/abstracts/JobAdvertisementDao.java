package kodlamaio.javahrms.dataAccess.abstracts;

import kodlamaio.javahrms.entities.concretes.JobAdvertisement;
import kodlamaio.javahrms.entities.dtos.EmployerJobTitleWithJobAdvertisementDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {

    @Query("SELECT new kodlamaio.javahrms.entities.dtos.EmployerJobTitleWithJobAdvertisementDto" +
            "(e.companyName,jobTitle.jobTitleName,j.numberOfOpenPositions,j.releaseDate,j.applicationDeadline)" +
            "FROM JobAdvertisement j INNER JOIN j.employer e INNER JOIN j.jobTitle jobTitle WHERE j.isActive=true")
    List<EmployerJobTitleWithJobAdvertisementDto> findByAllActiveJobPostings();

    @Query("SELECT new kodlamaio.javahrms.entities.dtos.EmployerJobTitleWithJobAdvertisementDto" +
            "(e.companyName,jobTitle.jobTitleName,j.numberOfOpenPositions,j.releaseDate,j.applicationDeadline)" +
            "FROM JobAdvertisement j INNER JOIN j.employer e INNER JOIN j.jobTitle jobTitle WHERE j.isActive=true ORDER BY j.releaseDate ASC")
    List<EmployerJobTitleWithJobAdvertisementDto> findByAllActiveJobPostingsSortByDate();

    @Query("SELECT new kodlamaio.javahrms.entities.dtos.EmployerJobTitleWithJobAdvertisementDto" +
            "(e.companyName,jobTitle.jobTitleName,j.numberOfOpenPositions,j.releaseDate,j.applicationDeadline)" +
            "FROM JobAdvertisement j INNER JOIN j.employer e INNER JOIN j.jobTitle jobTitle WHERE j.isActive=true")

    List<EmployerJobTitleWithJobAdvertisementDto> findByAllActiveJobPostingsForACompany(String companyName);

    @Transactional
    @Modifying
    @Query("UPDATE JobAdvertisement ja set ja.isActive = ?1 WHERE ja.id =?2")
    void setJobAdvertisementIsActive(boolean advertisementIsActive,int id);



}
