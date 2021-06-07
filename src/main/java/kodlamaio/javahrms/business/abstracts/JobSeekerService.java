package kodlamaio.javahrms.business.abstracts;

import kodlamaio.javahrms.core.utilities.results.DataResult;
import kodlamaio.javahrms.core.utilities.results.Result;
import kodlamaio.javahrms.entities.concretes.*;
import kodlamaio.javahrms.entities.dtos.JobSeekerCvDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface JobSeekerService {

    List<JobSeeker> findByNationalityId(String nationalityId);
    Result add(JobSeeker jobSeeker);
    Result addedJobSeekerEducation(JobSeekerEducation jobSeekerEducation);
    Result addedJobSeekerJobExperience(JobSeekerJobExperience jobSeekerJobExperience);
    Result addedJobSeekerLanguage(JobSeekerLanguage jobSeekerLanguage);
    Result addedCirriculumVitae(CurriculumVitae curriculumVitae);
    DataResult<JobSeekerCvDto>createCv(int id);
    DataResult<List<JobSeeker>> getAll();
    DataResult<List<CurriculumVitae>> findAllByJobSeekerId(int id);
    DataResult<JobSeeker> findById(int id);

}
