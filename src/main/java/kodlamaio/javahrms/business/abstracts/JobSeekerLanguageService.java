package kodlamaio.javahrms.business.abstracts;

import kodlamaio.javahrms.core.utilities.results.DataResult;
import kodlamaio.javahrms.core.utilities.results.Result;
import kodlamaio.javahrms.entities.concretes.JobSeekerLanguage;

import java.util.List;

public interface JobSeekerLanguageService {
    Result add(JobSeekerLanguage jobSeekerLanguage);
    Result delete(int id);
    Result update(JobSeekerLanguage jobSeekerLanguage,int id);
    DataResult<JobSeekerLanguage> findById(int id);
    DataResult<List<JobSeekerLanguage>> findAllByJobSeekerId(int id);
}
