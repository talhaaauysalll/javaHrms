package kodlamaio.javahrms.business.concretes;

import kodlamaio.javahrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.javahrms.business.abstracts.JobSeekerEducationService;
import kodlamaio.javahrms.business.abstracts.JobSeekerJobExperienceService;
import kodlamaio.javahrms.business.abstracts.JobSeekerLanguageService;
import kodlamaio.javahrms.core.utilities.results.*;
import kodlamaio.javahrms.dataAccess.abstracts.CurriculumVitaeDao;
import kodlamaio.javahrms.entities.concretes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CurriculumVitaeManager implements CurriculumVitaeService {

    private CurriculumVitaeDao curriculumVitaeDao;
    private JobSeekerEducationService jobSeekerEducationService;
    private JobSeekerJobExperienceService jobSeekerJobExperienceService;
    private JobSeekerLanguageService jobSeekerLanguageService;

    @Autowired
    public CurriculumVitaeManager(CurriculumVitaeDao curriculumVitaeDao, JobSeekerEducationService jobSeekerEducationService, JobSeekerJobExperienceService jobSeekerJobExperienceService, JobSeekerLanguageService jobSeekerLanguageService) {
        super();
        this.curriculumVitaeDao = curriculumVitaeDao;
        this.jobSeekerEducationService = jobSeekerEducationService;
        this.jobSeekerJobExperienceService = jobSeekerJobExperienceService;
        this.jobSeekerLanguageService = jobSeekerLanguageService;
    }

    @Override
    public Result add(CurriculumVitae curriculumVitae) {
        this.curriculumVitaeDao.save(curriculumVitae);
        return new SuccessResult();
    }

    @Override
    public Result delete(int id) {
        if(this.curriculumVitaeDao.findById(id)==null){
            return new ErrorResult(false,"Böyle bir öz geçmiş bilgisi yok");
        }
        this.curriculumVitaeDao.deleteById(id);
        return new SuccessResult(true,"Öz geçmiş bilgisi başarılı bir şekilde silindi");
    }

    @Override
    public Result update(CurriculumVitae curriculumVitae, int id) {
        this.curriculumVitaeDao.update(curriculumVitae.getCoverLetter(),curriculumVitae.getGithubLink(),curriculumVitae.getLinkedinLink(),curriculumVitae.getLearningTechnologiesOrProgrammingLanguages(),id);
        return new SuccessResult(true,"Öz Geçmiş Bilgisi Başarılı bir şekilde güncellendi");
    }

    @Override
    public DataResult<List<CurriculumVitae>> findAllByJobSeekerId(int id) {
        return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.findAllByJobSeekerId(id), id+"'li kullanıcıya ait öz geçmiş getirildi");
    }
}
