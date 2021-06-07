package kodlamaio.javahrms.entities.dtos;

import kodlamaio.javahrms.entities.concretes.*;

import java.util.List;

public class JobSeekerCvDto {
    public JobSeeker jobSeeker;
    public List<JobSeekerEducation> jobSeekerEducations;
    public List<JobSeekerJobExperience> jobSeekerJobExperiences;
    public List<JobSeekerLanguage> jobSeekerLanguages;
    public List<CurriculumVitae> curriculumVitaes;
    public JobSeekerImage jobSeekerImage;

}
