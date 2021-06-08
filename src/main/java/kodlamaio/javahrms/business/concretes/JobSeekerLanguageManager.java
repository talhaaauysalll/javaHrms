package kodlamaio.javahrms.business.concretes;

import kodlamaio.javahrms.business.abstracts.JobSeekerLanguageService;
import kodlamaio.javahrms.core.utilities.results.*;
import kodlamaio.javahrms.dataAccess.abstracts.JobSeekerLanguageDao;
import kodlamaio.javahrms.entities.concretes.JobSeekerJobExperience;
import kodlamaio.javahrms.entities.concretes.JobSeekerLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerLanguageManager implements JobSeekerLanguageService {

    private JobSeekerLanguageDao jobSeekerLanguageDao;

    @Autowired
    public JobSeekerLanguageManager(JobSeekerLanguageDao jobSeekerLanguageDao) {
        super();
        this.jobSeekerLanguageDao = jobSeekerLanguageDao;
    }


    @Override
    public Result add(JobSeekerLanguage jobSeekerLanguage) {
        if((Integer.parseInt(jobSeekerLanguage.getLanguageLevel())<1)
                &&(Integer.parseInt(jobSeekerLanguage.getLanguageLevel()))>5)
        {
            return new ErrorResult(false,"Girilen değer 1-5 arasında olmalıdır");
        }
        this.jobSeekerLanguageDao.save(jobSeekerLanguage);
        return new SuccessResult(true," yabancı dil bilgisi eklendi");
    }

    @Override
    public Result delete(int id) {
        if(this.jobSeekerLanguageDao.findById(id)==null){
            return new ErrorResult(false,"Böyle bir dil bilgisi yok");
        }
        this.jobSeekerLanguageDao.deleteById(id);
        return new SuccessResult(true,"Dil bilgisi silindi");
    }

    @Override
    public Result update(JobSeekerLanguage jobSeekerLanguage, int id) {
        this.jobSeekerLanguageDao.update(jobSeekerLanguage.getLanguageName(),jobSeekerLanguage.getLanguageLevel(),id);
        return new SuccessResult(true,"Dil bilgisi güncellendi");
    }

    @Override
    public DataResult<JobSeekerLanguage> findById(int id) {
        return new SuccessDataResult<JobSeekerLanguage>(this.jobSeekerLanguageDao.findById(id));
    }

    @Override
    public DataResult<List<JobSeekerLanguage>> findAllByJobSeekerId(int id) {
        return new SuccessDataResult<List<JobSeekerLanguage>>(this.jobSeekerLanguageDao.findAllByJobSeekerId(id),
                id+"'li kullanıcıya ait dil bilgisi getirildi");
    }
}
