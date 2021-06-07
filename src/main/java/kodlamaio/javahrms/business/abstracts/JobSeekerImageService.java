package kodlamaio.javahrms.business.abstracts;

import kodlamaio.javahrms.core.utilities.results.DataResult;
import kodlamaio.javahrms.core.utilities.results.Result;
import kodlamaio.javahrms.entities.concretes.JobSeekerImage;
import org.springframework.web.multipart.MultipartFile;

public interface JobSeekerImageService {
    DataResult<JobSeekerImage> findByJobSeekerId(int id);
    DataResult<JobSeekerImage> findById(int id);
    Result add(JobSeekerImage jobSeekerImage, MultipartFile imageFile);

}
