package kodlamaio.javahrms.business.abstracts;

import kodlamaio.javahrms.core.utilities.results.DataResult;
import kodlamaio.javahrms.core.utilities.results.Result;
import kodlamaio.javahrms.entities.concretes.JobAdvertisement;
import kodlamaio.javahrms.entities.dtos.EmployerJobTitleWithJobAdvertisementDto;

import java.util.List;

public interface JobAdvertisementService {
    DataResult<List<EmployerJobTitleWithJobAdvertisementDto>> findByAllActiveJobPostings();
    DataResult<List<EmployerJobTitleWithJobAdvertisementDto>> findByAllActiveJobPostingsSortByDate();
    DataResult<List<EmployerJobTitleWithJobAdvertisementDto>> findByAllActiveJobPostingsForACompany(String companyName);
    Result add(JobAdvertisement jobAdvertisement);
    Result update(JobAdvertisement jobAdvertisement,int id);
    Result delete(int id);
    Result setJobAdvertisementIsActive(boolean advertisementIsActive,int id);
}
