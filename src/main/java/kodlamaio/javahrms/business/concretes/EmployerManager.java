package kodlamaio.javahrms.business.concretes;

import kodlamaio.javahrms.business.abstracts.EmployerService;
import kodlamaio.javahrms.business.abstracts.JobAdvertisementService;
import kodlamaio.javahrms.core.utilities.results.DataResult;
import kodlamaio.javahrms.core.utilities.results.Result;
import kodlamaio.javahrms.core.utilities.results.SuccessDataResult;
import kodlamaio.javahrms.core.utilities.results.SuccessResult;
import kodlamaio.javahrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.javahrms.entities.concretes.Employer;
import kodlamaio.javahrms.entities.concretes.JobAdvertisement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployerManager implements EmployerService {

    private EmployerDao employerDao;
    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public EmployerManager(EmployerDao employerDao, JobAdvertisementService jobAdvertisementService) {
        this.employerDao = employerDao;
        this.jobAdvertisementService = jobAdvertisementService;
    }


    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"İş verenler listelendi");
    }

    @Override
    public Result add(Employer employer) {
        this.employerDao.save(employer);
        return new SuccessResult();
    }

    @Override
    public Result addJobAdvertisement(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementService.add(jobAdvertisement);
        return new SuccessResult(true,"İş ilanı eklendi");
    }

    @Override
    public Result setJobAdvertisementIsActive(boolean advertisementIsActive, int id) {
        this.jobAdvertisementService.setJobAdvertisementIsActive(advertisementIsActive,id);
        return new SuccessResult(true,id+"'li iş ilanı kapatıldı");
    }


}
