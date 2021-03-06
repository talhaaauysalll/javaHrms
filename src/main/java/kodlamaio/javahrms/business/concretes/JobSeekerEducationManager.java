package kodlamaio.javahrms.business.concretes;

import kodlamaio.javahrms.business.abstracts.JobSeekerEducationService;
import kodlamaio.javahrms.core.utilities.results.*;
import kodlamaio.javahrms.dataAccess.abstracts.JobSeekerEducationDao;
import kodlamaio.javahrms.entities.concretes.JobSeekerEducation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JobSeekerEducationManager implements JobSeekerEducationService {

    private JobSeekerEducationDao jobSeekerEducationDao;

    @Autowired
    public JobSeekerEducationManager(JobSeekerEducationDao jobSeekerEducationDao) {
        this.jobSeekerEducationDao = jobSeekerEducationDao;
    }

    @Override
    public DataResult<JobSeekerEducation> findById(int id) {
        return new SuccessDataResult<JobSeekerEducation>(this.jobSeekerEducationDao.findById(id));
    }

    @Override
    public DataResult<List<JobSeekerEducation>> findAllByJobSeekerIdOrderBySchoolEndDateDesc(int id) {
        for (JobSeekerEducation jobSeekerEducation:this.jobSeekerEducationDao.findAllByJobSeekerIdOrderBySchoolEndDateDesc(id)) {
            if (jobSeekerEducation.getSchoolEndDate()==null){
                return new SuccessDataResult<List<JobSeekerEducation>>(this.jobSeekerEducationDao.findAllByJobSeekerIdOrderBySchoolEndDateDesc(id));
            }
        }
        return new SuccessDataResult<List<JobSeekerEducation>>(this.jobSeekerEducationDao.findAllByJobSeekerIdOrderBySchoolEndDateDesc(id)
                ,"Tüm okul bilgisi listelendi");
    }

    @Override
    public DataResult<List<JobSeekerEducation>> findAllByJobSeekerId(int id) {
        return new SuccessDataResult<List<JobSeekerEducation>>(this.jobSeekerEducationDao.findAllByJobSeekerId(id),
                id+"'li bütün eğitim bilgisi getirildi");
    }

    @Override
    @Transactional(readOnly = false)
    public Result add(JobSeekerEducation jobSeekerEducation) {
        this.jobSeekerEducationDao.save(jobSeekerEducation);
        return new SuccessResult(true," eğitim bilgisi eklendi");
    }

    @Override
    public Result delete(int id) {
        if(this.jobSeekerEducationDao.findByJobSeekerId(id)==null){
            return new ErrorResult(false,"Böyle bir eğitim bilgisi yok");
        }
        this.jobSeekerEducationDao.deleteById(id);
        return new SuccessResult(true,"Eğitim bilgisi silindi");
    }

    @Override
    public Result update(JobSeekerEducation jobSeekerEducation, int id) {
        this.jobSeekerEducationDao.update(jobSeekerEducation.getSchoolName(),jobSeekerEducation.getDepartmentAtSchool(),jobSeekerEducation.getSchoolStartDate(),jobSeekerEducation.getSchoolEndDate(),id);
        return new SuccessResult(true,"Eğitim bilgisi güncellendi");
    }
}
