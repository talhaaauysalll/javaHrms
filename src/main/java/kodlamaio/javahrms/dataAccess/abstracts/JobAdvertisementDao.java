package kodlamaio.javahrms.dataAccess.abstracts;

import kodlamaio.javahrms.entities.concretes.JobAdvertisement;
import kodlamaio.javahrms.entities.dtos.EmployerJobTitleWithJobAdvertisementDto;
import kodlamaio.javahrms.entities.dtos.JobAdvertisementDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement,Integer> {

    @Query("SELECT new kodlamaio.javahrms.entities.dtos.EmployerJobTitleWithJobAdvertisementDto" +
            "(e.companyName,jobTitle.jobTitleName,j.numberOfOpenPositions,j.releaseDate,j.applicationDeadline)" +
            "FROM JobAdvertisement j INNER JOIN j.employer e INNER JOIN j.jobTitle jobTitle WHERE j.isActive=true")
    List<EmployerJobTitleWithJobAdvertisementDto> findByAllActiveJobPostings();

    @Query("SELECT new kodlamaio.javahrms.entities.dtos.EmployerJobTitleWithJobAdvertisementDto" +
            "(e.companyName,jobTitle.jobTitleName,j.numberOfOpenPositions,j.releaseDate,j.applicationDeadline)" +
            "FROM JobAdvertisement j INNER JOIN j.employer e INNER JOIN j.jobTitle jobTitle WHERE j.isActive=false")
    List<EmployerJobTitleWithJobAdvertisementDto> findByAllDeActiveJobPostings();

    @Query("select new kodlamaio.javahrms.entities.dtos.JobAdvertisementDto" +
            "(j.id,jobTitle.jobTitleName,e.companyName,c.cityName,workTime.workTimesName,workType.workTypesName,j.minSalary,j.maxSalary,j.numberOfOpenPositions,j.releaseDate,j.applicationDeadline)" +
            "FROM JobAdvertisement j INNER JOIN j.employer e INNER JOIN j.jobTitle jobTitle INNER JOIN j.city c inner join j.workTime workTime inner join j.workType workType where j.isActive=false ")
    List<JobAdvertisementDto> findByAll();

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

    @Transactional
    @Modifying
    @Query("UPDATE JobAdvertisement ja set ja.applicationDeadline=?1,ja.numberOfOpenPositions=?2,ja.maxSalary=?3,ja.minSalary=?4 where ja.id=?5")
    void update(Date applicationDeadline, int numberOfOpenPositions, double maxSalary, double minSalary, int id);




}
