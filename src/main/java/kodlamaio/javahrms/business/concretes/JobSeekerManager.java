package kodlamaio.javahrms.business.concretes;

import kodlamaio.javahrms.business.abstracts.*;
import kodlamaio.javahrms.core.utilities.results.*;
import kodlamaio.javahrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.javahrms.entities.concretes.*;
import kodlamaio.javahrms.entities.dtos.JobSeekerCvDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class JobSeekerManager implements JobSeekerService {

    private JobSeekerDao jobSeekerDao;
    private CurriculumVitaeService curriculumVitaeService;
    private JobSeekerImageService jobSeekerImageService;
    private JobSeekerEducationService jobSeekerEducationService;
    private JobSeekerLanguageService jobSeekerLanguageService;
    private JobSeekerJobExperienceService jobSeekerJobExperienceService;


    @Autowired
    public JobSeekerManager(JobSeekerDao jobSeekerDao, CurriculumVitaeService curriculumVitaeService, JobSeekerImageService jobSeekerImageService, JobSeekerEducationService jobSeekerEducationService, JobSeekerLanguageService jobSeekerLanguageService, JobSeekerJobExperienceService jobSeekerJobExperienceService) {
        this.jobSeekerDao = jobSeekerDao;
        this.curriculumVitaeService = curriculumVitaeService;
        this.jobSeekerImageService = jobSeekerImageService;
        this.jobSeekerEducationService = jobSeekerEducationService;
        this.jobSeekerLanguageService = jobSeekerLanguageService;
        this.jobSeekerJobExperienceService = jobSeekerJobExperienceService;
    }

    @Override
    public List<JobSeeker> findByNationalityId(String nationalityId) {
        return this.jobSeekerDao.findByNationalityId(nationalityId);
    }

    @Override
    public Result add(JobSeeker jobSeeker) {
        this.jobSeekerDao.save(jobSeeker);
        return new SuccessResult();
    }

    @Override
    public Result addedJobSeekerEducation(JobSeekerEducation jobSeekerEducation) {
        this.jobSeekerEducationService.add(jobSeekerEducation);
        return new SuccessResult(true,"Okul bilgisi eklendi");
    }

    @Override
    public Result addedJobSeekerJobExperience(JobSeekerJobExperience jobSeekerJobExperience) {
        this.jobSeekerJobExperienceService.add(jobSeekerJobExperience);
        return new SuccessResult(true,"İş tecrübesi eklendi");
    }

    @Override
    public Result addedJobSeekerLanguage(JobSeekerLanguage jobSeekerLanguage) {
        this.jobSeekerLanguageService.add(jobSeekerLanguage);
        return new SuccessResult(true,"Bilinen dil eklendi");
    }

    @Override
    public Result addedCirriculumVitae(CurriculumVitae curriculumVitae) {
        this.curriculumVitaeService.add(curriculumVitae);
        return new SuccessResult(true,"Hesap linkleri ve ön yazı eklendi");
    }

    @Override
    public DataResult<JobSeekerCvDto> createCv(int id) {
        JobSeekerCvDto jobSeekerCvDto =new JobSeekerCvDto();
        jobSeekerCvDto.jobSeekerEducations=this.jobSeekerEducationService.findAllByJobSeekerIdOrderBySchoolEndDateDesc(id).getData();
        jobSeekerCvDto.jobSeekerJobExperiences=this.jobSeekerJobExperienceService.findAllByJobSeekerJobExperienceIdOrderByJobEndDateDesc(id).getData();
        jobSeekerCvDto.jobSeekerLanguages=this.jobSeekerLanguageService.findAllByJobSeekerId(id).getData();
        jobSeekerCvDto.curriculumVitaes=this.curriculumVitaeService.findAllByJobSeekerId(id).getData();
        jobSeekerCvDto.jobSeekerImage=this.jobSeekerImageService.findByJobSeekerId(id).getData();
        return new SuccessDataResult<JobSeekerCvDto>(jobSeekerCvDto,"Cv oluşturuldu");
    }


    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),"İş arayanlar listelendi");
    }


    @Override
    public DataResult<List<CurriculumVitae>> findAllByJobSeekerId(int id) {
        return new SuccessDataResult<List<CurriculumVitae>>((List<CurriculumVitae>) this.curriculumVitaeService.findAllByJobSeekerId(id));
    }

    @Override
    public DataResult<JobSeeker> findById(int id) {
        return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findById(id));
    }
}
