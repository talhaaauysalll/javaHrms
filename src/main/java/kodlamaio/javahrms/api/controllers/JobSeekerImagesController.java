package kodlamaio.javahrms.api.controllers;


import kodlamaio.javahrms.business.abstracts.JobSeekerImageService;
import kodlamaio.javahrms.business.abstracts.JobSeekerService;
import kodlamaio.javahrms.core.utilities.results.ErrorDataResult;
import kodlamaio.javahrms.entities.concretes.JobSeeker;
import kodlamaio.javahrms.entities.concretes.JobSeekerImage;
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
@RequestMapping("/api/job_seekers_images_controller")
public class JobSeekerImagesController {
    private JobSeekerImageService jobSeekerImageService;
    private JobSeekerService jobSeekerService;

    @Autowired
    public JobSeekerImagesController(JobSeekerImageService jobSeekerImageService, JobSeekerService jobSeekerService) {
        this.jobSeekerImageService = jobSeekerImageService;
        this.jobSeekerService = jobSeekerService;
    }

    @PostMapping("/addedImage")
    public ResponseEntity<?> addedImage(@RequestParam(value = "id") int id, @RequestParam(value = "imageFile") MultipartFile imageFile){
        JobSeeker jobSeeker=this.jobSeekerService.findById(id).getData();
        JobSeekerImage jobSeekerImage=new JobSeekerImage();
        jobSeekerImage.setJobSeeker(jobSeeker);
        return ResponseEntity.ok(this.jobSeekerImageService.add(jobSeekerImage,imageFile));
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
