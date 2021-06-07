package kodlamaio.javahrms.business.concretes;

import kodlamaio.javahrms.business.abstracts.JobTitleService;
import kodlamaio.javahrms.core.utilities.results.*;
import kodlamaio.javahrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.javahrms.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTitleManager implements JobTitleService {

    private JobTitleDao jobTitleDao;

    @Autowired
    public JobTitleManager(JobTitleDao jobTitleDao) {
        this.jobTitleDao = jobTitleDao;
    }

    @Override
    public Result add(JobTitle jobTitle) {
        for (JobTitle job_title:this.jobTitleDao.findByJobTitleName(jobTitle.getJobTitleName())) {
            if(job_title.getJobTitleName().equals(jobTitle.getJobTitleName())){
               return new ErrorResult(false,"Eklemek istediğiniz genel iş pozisyonu zaten var");
            }
        }
        this.jobTitleDao.save(jobTitle);
        return new SuccessResult(true,"Genel iş poziyonu başarılı bir şekilde eklendi");
    }

    @Override
    public DataResult<List<JobTitle>> getAll() {
        return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(),"Genel iş pozisyonları listelendi");
    }

}
