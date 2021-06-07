package kodlamaio.javahrms.business.abstracts;

import kodlamaio.javahrms.core.utilities.results.DataResult;
import kodlamaio.javahrms.core.utilities.results.Result;
import kodlamaio.javahrms.entities.concretes.Employer;
import kodlamaio.javahrms.entities.concretes.JobAdvertisement;

import java.util.List;

public interface EmployerService {
    DataResult<List<Employer>> getAll();
    Result add(Employer employer);
    Result addJobAdvertisement(JobAdvertisement jobAdvertisement);
    Result setJobAdvertisementIsActive(boolean advertisementIsActive,int id);
}
