package kodlamaio.javahrms.business.concretes;

import kodlamaio.javahrms.business.abstracts.CurriculumVitaeService;
import kodlamaio.javahrms.business.abstracts.JobSeekerEducationService;
import kodlamaio.javahrms.business.abstracts.JobSeekerJobExperienceService;
import kodlamaio.javahrms.business.abstracts.JobSeekerLanguageService;
import kodlamaio.javahrms.core.utilities.results.DataResult;
import kodlamaio.javahrms.core.utilities.results.Result;
import kodlamaio.javahrms.core.utilities.results.SuccessDataResult;
import kodlamaio.javahrms.core.utilities.results.SuccessResult;
import kodlamaio.javahrms.dataAccess.abstracts.CurriculumVitaeDao;
import kodlamaio.javahrms.entities.concretes.CurriculumVitae;
import kodlamaio.javahrms.entities.concretes.JobSeekerEducation;
import kodlamaio.javahrms.entities.concretes.JobSeekerJobExperience;
import kodlamaio.javahrms.entities.concretes.JobSeekerLanguage;
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
    public DataResult<List<CurriculumVitae>> findAllByJobSeekerId(int id) {
        return new SuccessDataResult<List<CurriculumVitae>>(this.curriculumVitaeDao.findAllByJobSeekerId(id), id+"'li kullanıcıya ait öz geçmiş getirildi");
    }
}
