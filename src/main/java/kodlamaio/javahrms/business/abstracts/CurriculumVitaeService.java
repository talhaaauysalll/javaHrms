package kodlamaio.javahrms.business.abstracts;

import kodlamaio.javahrms.core.utilities.results.DataResult;
import kodlamaio.javahrms.core.utilities.results.Result;
import kodlamaio.javahrms.entities.concretes.CurriculumVitae;
import kodlamaio.javahrms.entities.concretes.JobSeekerEducation;
import kodlamaio.javahrms.entities.concretes.JobSeekerJobExperience;
import kodlamaio.javahrms.entities.concretes.JobSeekerLanguage;

import java.util.List;

public interface CurriculumVitaeService {
    Result add(CurriculumVitae curriculumVitae);
    Result delete(int id);
    Result update(CurriculumVitae curriculumVitae,int id);
    DataResult<List<CurriculumVitae>> findAllByJobSeekerId(int id);
}
