package kodlamaio.javahrms.business.abstracts;

import kodlamaio.javahrms.core.utilities.results.Result;
import kodlamaio.javahrms.entities.concretes.Employer;
import kodlamaio.javahrms.entities.concretes.JobSeeker;

public interface AuthService {
    Result registerJobSeeker(JobSeeker jobSeeker);
    Result registerEmployer(Employer employer);
}
