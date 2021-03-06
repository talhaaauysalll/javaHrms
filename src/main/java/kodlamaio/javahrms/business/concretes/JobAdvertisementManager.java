package kodlamaio.javahrms.business.concretes;


import kodlamaio.javahrms.business.abstracts.JobAdvertisementService;
import kodlamaio.javahrms.core.utilities.results.*;
import kodlamaio.javahrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.javahrms.entities.concretes.JobAdvertisement;
import kodlamaio.javahrms.entities.dtos.EmployerJobTitleWithJobAdvertisementDto;
import kodlamaio.javahrms.entities.dtos.JobAdvertisementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

    private JobAdvertisementDao jobAdvertisementDao;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
        this.jobAdvertisementDao = jobAdvertisementDao;
    }

    @Override
    public DataResult<List<EmployerJobTitleWithJobAdvertisementDto>> findByAllActiveJobPostings() {
        if(this.jobAdvertisementDao.findByAllActiveJobPostings().size()==0){
            return new ErrorDataResult<List<EmployerJobTitleWithJobAdvertisementDto>>(null,"İş İlanı Yok");
        }
        return new SuccessDataResult<List<EmployerJobTitleWithJobAdvertisementDto>>(this.jobAdvertisementDao.findByAllActiveJobPostings(),"Bütün aktif iş ilanları listelendi");
    }

    @Override
    public DataResult<List<EmployerJobTitleWithJobAdvertisementDto>> findByAllActiveJobPostingsSortByDate() {
        return new SuccessDataResult<List<EmployerJobTitleWithJobAdvertisementDto>>(this.jobAdvertisementDao.findByAllActiveJobPostingsSortByDate(),"Bütün aktif iş ilanları tarihe göre listelendi");
    }

    @Override
    public DataResult<List<EmployerJobTitleWithJobAdvertisementDto>> findByAllActiveJobPostingsForACompany(String companyName) {
        return new SuccessDataResult<List<EmployerJobTitleWithJobAdvertisementDto>>(this.jobAdvertisementDao.findByAllActiveJobPostingsForACompany(companyName),companyName+" firmasına ait tüm aktif iş ilanları listelendi");
    }

    @Override
    public DataResult<List<EmployerJobTitleWithJobAdvertisementDto>> findByAllDeActiveJobPostings() {
        return new SuccessDataResult<List<EmployerJobTitleWithJobAdvertisementDto>>(this.jobAdvertisementDao.findByAllDeActiveJobPostings());
    }

    @Override
    public DataResult<List<JobAdvertisementDto>> findByAll() {
        return new SuccessDataResult<List<JobAdvertisementDto>>(this.jobAdvertisementDao.findByAll());
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        LocalDate localDate=LocalDate.now();
        jobAdvertisement.setReleaseDate(localDate);
        jobAdvertisement.setActive(false);
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult();
    }

    @Override
    public Result update(JobAdvertisement jobAdvertisement,int id) {
        this.jobAdvertisementDao.update(jobAdvertisement.getApplicationDeadline(),
                jobAdvertisement.getNumberOfOpenPositions(),
                jobAdvertisement.getMaxSalary(),jobAdvertisement.getMinSalary(),id);
        return new SuccessResult(true,"İş ilanı başarılı bir şekilde güncellendi");
    }

    @Override
    public Result delete(int id) {
        if(this.jobAdvertisementDao.findById(id)==null){
            return new ErrorResult(false,"Böyle bir iş ilanı yok");
        }
        this.jobAdvertisementDao.deleteById(id);
        return new SuccessResult(true,"İş ilanı başarılı bir şekilde silindi");
    }

    @Override
    public Result setJobAdvertisementIsActive(boolean advertisementIsActive, int id) {
        this.jobAdvertisementDao.setJobAdvertisementIsActive(advertisementIsActive,id);
        return new SuccessResult();
    }


}
