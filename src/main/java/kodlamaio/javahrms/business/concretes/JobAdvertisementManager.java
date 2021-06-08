package kodlamaio.javahrms.business.concretes;


import kodlamaio.javahrms.business.abstracts.JobAdvertisementService;
import kodlamaio.javahrms.core.utilities.results.*;
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
    public Result update(JobAdvertisement jobAdvertisement,int id) {
        for (int i=0;i<this.jobAdvertisementDao.findAll().size();i++){
            JobAdvertisement jA=this.jobAdvertisementDao.getById(i);
            if(jA.getId()==id){
                this.jobAdvertisementDao.findAll().set(i,jobAdvertisement);
                return new SuccessResult();
            }
        }
        return new ErrorResult(false,"İş ilanı güncellenemedi");
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
