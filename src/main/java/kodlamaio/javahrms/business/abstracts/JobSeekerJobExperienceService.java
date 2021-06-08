package kodlamaio.javahrms.business.abstracts;

import kodlamaio.javahrms.core.utilities.results.DataResult;
import kodlamaio.javahrms.core.utilities.results.Result;
import kodlamaio.javahrms.entities.concretes.JobSeekerJobExperience;

import java.util.List;

public interface JobSeekerJobExperienceService {
    DataResult<JobSeekerJobExperience> findById(int id);
    DataResult<List<JobSeekerJobExperience>> findAllByJobSeekerJobExperienceIdOrderByJobEndDateDesc(int id);
    DataResult<List<JobSeekerJobExperience>> findAllByJobSeekerJobExperinceId(int id);
    Result add(JobSeekerJobExperience jobSeekerJobExperience);
    Result delete(int id);
    Result update(JobSeekerJobExperience jobSeekerJobExperience,int id);

}
