package kodlamaio.javahrms.business.concretes;

import kodlamaio.javahrms.business.abstracts.JobSeekerEducationService;
import kodlamaio.javahrms.core.utilities.results.*;
import kodlamaio.javahrms.dataAccess.abstracts.JobSeekerEducationDao;
import kodlamaio.javahrms.entities.concretes.CurriculumVitae;
import kodlamaio.javahrms.entities.concretes.JobSeekerEducation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobSeekerEducationManager implements JobSeekerEducationService {

    private JobSeekerEducationDao jobSeekerEducationDao;

    @Autowired
    public JobSeekerEducationManager(JobSeekerEducationDao jobSeekerEducationDao) {
        super();
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
    public Result add(JobSeekerEducation jobSeekerEducation) {
        this.jobSeekerEducationDao.save(jobSeekerEducation);
        return new SuccessResult(true," eğitim bilgisi eklendi");
    }

    @Override
    public Result delete(int id) {
        if(this.jobSeekerEducationDao.findById(id)==null){
            return new ErrorResult(false,"Böyle bir eğitim bilgisi yok");
        }
        this.jobSeekerEducationDao.deleteById(id);
        return new SuccessResult(true,"Eğitim bilgisi silindi");
    }

    @Override
    public Result update(JobSeekerEducation jobSeekerEducation, int id) {
        for (int i=0;i<this.jobSeekerEducationDao.findAll().size();i++){
            JobSeekerEducation jSE=this.jobSeekerEducationDao.getById(i);
            if(jSE.getId()==id){
                this.jobSeekerEducationDao.findAll().set(i,jobSeekerEducation);
                return new SuccessResult();
            }
        }
        return new ErrorResult(false,"Eğitim bilgisi güncellenemedi");
    }
}
