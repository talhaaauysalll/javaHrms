package kodlamaio.javahrms.api.controllers;

import kodlamaio.javahrms.business.abstracts.JobSeekerService;
import kodlamaio.javahrms.core.utilities.results.ErrorDataResult;
import kodlamaio.javahrms.entities.concretes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/jobseekers")
public class JobSeekersController {
    private JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekersController(JobSeekerService jobSeekerService) {
        this.jobSeekerService = jobSeekerService;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.jobSeekerService.getAll());
    }

    @PostMapping("/addedjobseekereducation")
    public ResponseEntity<?> addedJobSeekerEducation(@RequestBody JobSeekerEducation jobSeekerEducation){
        return ResponseEntity.ok(this.jobSeekerService.addedJobSeekerEducation(jobSeekerEducation));
    }

    @PostMapping("/addedjobSeekerjobexperience")
    public ResponseEntity<?> addedJobSeekerJobExperience(@RequestBody JobSeekerJobExperience jobSeekerJobExperience){
        return ResponseEntity.ok(this.jobSeekerService.addedJobSeekerJobExperience(jobSeekerJobExperience));
    }

    @PostMapping("/addedjobseekerlanguage")
    public ResponseEntity<?> addedJobSeekerLanguage(@RequestBody JobSeekerLanguage jobSeekerLanguage){
        return ResponseEntity.ok(this.jobSeekerService.addedJobSeekerLanguage(jobSeekerLanguage));
    }

    @PostMapping("/addedcirriculumvitae")
    public ResponseEntity<?> addedCirriculumVitae(@RequestBody CurriculumVitae curriculumVitae){
        return ResponseEntity.ok(this.jobSeekerService.addedCirriculumVitae(curriculumVitae));
    }

    @GetMapping("/createcv")
    public ResponseEntity<?> createCv(@RequestParam("id") int id){
        return ResponseEntity.ok(this.jobSeekerService.createCv(id));
    }




    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorDataResult<Object> handleValidationException(MethodArgumentNotValidException exceptions){
        Map<String,String> validationErrors=new HashMap<String,String>();
        for (FieldError fieldError : exceptions.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        ErrorDataResult<Object> errors=new ErrorDataResult<Object>(validationErrors,"Doğrulama hataları");
        return errors;
    }
}
