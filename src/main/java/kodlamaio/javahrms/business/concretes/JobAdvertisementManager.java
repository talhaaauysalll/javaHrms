package kodlamaio.javahrms.business.concretes;


import kodlamaio.javahrms.business.abstracts.JobAdvertisementService;
import kodlamaio.javahrms.core.utilities.results.DataResult;
import kodlamaio.javahrms.core.utilities.results.Result;
import kodlamaio.javahrms.core.utilities.results.SuccessDataResult;
import kodlamaio.javahrms.core.utilities.results.SuccessResult;
import kodlamaio.javahrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.javahrms.entities.concretes.JobAdvertisement;
import kodlamaio.javahrms.entities.dtos.EmployerJobTitleWithJobAdvertisementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public Result add(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementDao.save(jobAdvertisement);
        return new SuccessResult();
    }

    @Override
    public Result setJobAdvertisementIsActive(boolean advertisementIsActive, int id) {
        this.jobAdvertisementDao.setJobAdvertisementIsActive(advertisementIsActive,id);
        return new SuccessResult();
    }


}
