package kodlamaio.javahrms.business.concretes;

import kodlamaio.javahrms.adapters.ImageService;
import kodlamaio.javahrms.business.abstracts.JobSeekerImageService;
import kodlamaio.javahrms.core.utilities.results.DataResult;
import kodlamaio.javahrms.core.utilities.results.Result;
import kodlamaio.javahrms.core.utilities.results.SuccessDataResult;
import kodlamaio.javahrms.core.utilities.results.SuccessResult;
import kodlamaio.javahrms.dataAccess.abstracts.JobSeekerImageDao;
import kodlamaio.javahrms.entities.concretes.JobSeekerImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public class JobSeekerImageManager implements JobSeekerImageService {

    private JobSeekerImageDao jobSeekerImageDao;
    private ImageService imageService;

    @Autowired
    public JobSeekerImageManager(JobSeekerImageDao jobSeekerImageDao, ImageService imageService) {
        super();
        this.jobSeekerImageDao = jobSeekerImageDao;
        this.imageService = imageService;
    }

    @Override
    public DataResult<JobSeekerImage> findByJobSeekerId(int id) {
        return new SuccessDataResult<JobSeekerImage>(this.jobSeekerImageDao.findByJobSeekerId(id));
    }

    @Override
    public DataResult<JobSeekerImage> findById(int id) {
        return new SuccessDataResult<JobSeekerImage>(this.jobSeekerImageDao.findById(id));
    }

    @Override
    public Result add(JobSeekerImage jobSeekerImage, MultipartFile imageFile) {
        Map<String,String> uploadedImage=this.imageService.uploadImage(imageFile).getData();
        jobSeekerImage.setImageUrl(uploadedImage.get("url"));
        this.jobSeekerImageDao.save(jobSeekerImage);
        return new SuccessResult(true,"Fotoğraf başarılı bir şekilde eklendi");
    }
}
