package kodlamaio.javahrms.business.concretes;

import kodlamaio.javahrms.business.abstracts.*;
import kodlamaio.javahrms.core.entities.User;
import kodlamaio.javahrms.core.utilities.codeGenerator.CodeGeneratorService;
import kodlamaio.javahrms.core.utilities.results.ErrorResult;
import kodlamaio.javahrms.core.utilities.results.Result;
import kodlamaio.javahrms.core.utilities.results.SuccessResult;
import kodlamaio.javahrms.entities.concretes.Employer;
import kodlamaio.javahrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthManager implements AuthService {

    private JobSeekerService jobSeekerService;
    private FakeCheckService fakeCheckService;
    private CodeGeneratorService codeGeneratorService;
    private SystemPersonnelService systemPersonnelService;
    private UserService userService;
    private EmployerService employerService;

    @Autowired
    public AuthManager(JobSeekerService jobSeekerService, FakeCheckService fakeCheckService, CodeGeneratorService codeGeneratorService, SystemPersonnelService systemPersonnelService, UserService userService, EmployerService employerService) {
        this.jobSeekerService = jobSeekerService;
        this.fakeCheckService = fakeCheckService;
        this.codeGeneratorService = codeGeneratorService;
        this.userService = userService;
        this.employerService = employerService;
    }

    @Override
    public Result registerJobSeeker(JobSeeker jobSeeker) {
        if(!checkIfRealPerson(jobSeeker)){
            return new ErrorResult(false,"Mernis sistemine göre kullanıcı doğrulanamadı");
        }
        if(checkIfEmailAlreadyExists(jobSeeker.getEmail())){
            return new ErrorResult(false,"Bu mail adresi zaten var");
        }
        if(checkIfNationalityIdAlreadyExists(jobSeeker.getNationalityId())){
            return new ErrorResult(false,"Bu Tc Kimliğe ait kayıt var");
        }
        if(checkIfPasswordMatches(jobSeeker.getPassword(),jobSeeker.getPasswordRepeat())){
            return new ErrorResult(false,"Parolalar uyuşmuyor");
        }
        this.jobSeekerService.add(jobSeeker);
        return new SuccessResult(true,"Kaydınız başarılı bir şekilde onaylandı yanda yer alan kodu giriniz "+codeGeneratorService.deriveCode());
    }

    @Override
    public Result registerEmployer(Employer employer) {
        if(checkIfEmailAlreadyExists(employer.getEmail())){
            return new ErrorResult(false,"Bu mail adresi zaten var");
        }
        if(checkIfPasswordMatches(employer.getPassword(), employer.getPasswordRepeat())){
            return new ErrorResult(false,"Parolalar uyuşmuyor");
        }
        if(checkIfEmailMatchesWithWebsite(employer.getWebSite(),employer.getEmail())){
            return new ErrorResult(false,"Mail adresi ve web site adresi uyuşmuyor");
        }

        this.employerService.add(employer);
        return new SuccessResult(true,"Sistem personeli tarafından kayıt onayı bekliyorsunuz" +
                    "yanda yer alan kodu giriniz "+codeGeneratorService.deriveCode());



    }

    public boolean checkIfEmailMatchesWithWebsite(String webSite,String email){
        if(!email.contains(webSite)){
            return false;
        }
        return true;
    }













    //Şifre tekrarı her iki nesnede istendiği için bu metot ortak olarak kullanılacaktır
    public boolean checkIfPasswordMatches(String password,String passwordRepeat){
        if (!password.equals(passwordRepeat)){
            return true;
        }
        return false;
    }

    //JobSeeker nesnesi için yapılan tüm doğrulamalar...

    public boolean checkIfRealPerson(JobSeeker jobSeeker){
        if(this.fakeCheckService.check(jobSeeker.getFirstName(),jobSeeker.getLastName(),
                jobSeeker.getNationalityId(),jobSeeker.getBirthYear())){
            return true;
        }
        return false;
    }
    public boolean checkIfEmailAlreadyExists(String email){
        for(User user:this.userService.findByEmail(email)){
            if(user.getEmail().equals(email)){
                return true;
            }
        }
        return false;
    }
    public boolean checkIfNationalityIdAlreadyExists(String nationalityId){
        for (JobSeeker jobSeeker:this.jobSeekerService.findByNationalityId(nationalityId)) {
            if(jobSeeker.getNationalityId().equals(nationalityId)){
                return true;
            }
        }
        return false;
    }
}
