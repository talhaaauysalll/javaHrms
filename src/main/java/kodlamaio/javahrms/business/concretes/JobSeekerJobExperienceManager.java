package kodlamaio.javahrms.business.concretes;

import kodlamaio.javahrms.business.abstracts.JobSeekerJobExperienceService;
import kodlamaio.javahrms.core.utilities.results.*;
import kodlamaio.javahrms.dataAccess.abstracts.JobSeekerJobExperienceDao;
import kodlamaio.javahrms.entities.concretes.JobSeekerEducation;
import kodlamaio.javahrms.entities.concretes.JobSeekerJobExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerJobExperienceManager implements JobSeekerJobExperienceService {


    private JobSeekerJobExperienceDao jobSeekerJobExperienceDao;

    @Autowired
    public JobSeekerJobExperienceManager(JobSeekerJobExperienceDao jobSeekerJobExperienceDao) {
        super();
        this.jobSeekerJobExperienceDao = jobSeekerJobExperienceDao;
    }


    @Override
    public DataResult<JobSeekerJobExperience> findById(int id) {
        return new SuccessDataResult<JobSeekerJobExperience>(this.jobSeekerJobExperienceDao.findById(id));
    }

    @Override
    public DataResult<List<JobSeekerJobExperience>> findAllByJobSeekerJobExperienceIdOrderByJobEndDateDesc(int id) {
        for (JobSeekerJobExperience jobSeekerJobExperience:this.jobSeekerJobExperienceDao.findAllByJobSeekerIdOrderByJobEndDateDesc(id)) {
            if(jobSeekerJobExperience.getJobEndDate()==null){
                return new SuccessDataResult<List<JobSeekerJobExperience>>
                        (this.jobSeekerJobExperienceDao.findAllByJobSeekerIdOrderByJobEndDateDesc(id),jobSeekerJobExperience.getJobStartDate()+ " Devam Ediyor");
            }
        }
        return new SuccessDataResult<List<JobSeekerJobExperience>>(this.jobSeekerJobExperienceDao.findAllByJobSeekerIdOrderByJobEndDateDesc(id));
    }

    @Override
    public DataResult<List<JobSeekerJobExperience>> findAllByJobSeekerJobExperinceId(int id) {
        return new SuccessDataResult<List<JobSeekerJobExperience>>(this.jobSeekerJobExperienceDao.findAllByJobSeekerId(id),id+"'li i?? arayan??n i?? tecr??besi listelendi");
    }

    @Override
    public Result add(JobSeekerJobExperience jobSeekerJobExperience) {
        this.jobSeekerJobExperienceDao.save(jobSeekerJobExperience);
        return new SuccessResult(true,"???? tecr??besi eklendi");
    }

    @Override
    public Result delete(int id) {
        if(this.jobSeekerJobExperienceDao.findById(id)==null){
            return new ErrorResult(false,"B??yle bir i?? deneyim bilgisi yok");
        }
        this.jobSeekerJobExperienceDao.deleteById(id);
        return new SuccessResult(true,"???? deneyimi silindi");
    }

    @Override
    public Result update(JobSeekerJobExperience jobSeekerJobExperience, int id) {
        this.jobSeekerJobExperienceDao.update(jobSeekerJobExperience.getWorkPlaceName(),jobSeekerJobExperience.getPositionAtWork(),jobSeekerJobExperience.getJobStartDate(),jobSeekerJobExperience.getJobEndDate(),id);
        return new SuccessResult(true,"???? deneyimi g??ncellendi");
    }
}
