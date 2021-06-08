package kodlamaio.javahrms.business.abstracts;

import kodlamaio.javahrms.core.utilities.results.DataResult;
import kodlamaio.javahrms.core.utilities.results.Result;
import kodlamaio.javahrms.entities.concretes.JobSeekerEducation;

import java.util.List;

public interface JobSeekerEducationService {
    DataResult<JobSeekerEducation> findById(int id);
    DataResult<List<JobSeekerEducation>> findAllByJobSeekerIdOrderBySchoolEndDateDesc(int id);
    DataResult<List<JobSeekerEducation>> findAllByJobSeekerId(int id);
    Result add(JobSeekerEducation jobSeekerEducation);
    Result delete(int id);
    Result update(JobSeekerEducation jobSeekerEducation,int id);
}
