package kodlamaio.javahrms.business.abstracts;

import kodlamaio.javahrms.core.utilities.results.DataResult;
import kodlamaio.javahrms.core.utilities.results.Result;
import kodlamaio.javahrms.entities.concretes.JobTitle;

import java.util.List;


public interface JobTitleService {
    Result add(JobTitle jobTitle);
    DataResult<List<JobTitle>> getAll();

}
