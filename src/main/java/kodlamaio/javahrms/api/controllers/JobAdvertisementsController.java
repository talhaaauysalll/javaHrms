package kodlamaio.javahrms.api.controllers;


import kodlamaio.javahrms.business.abstracts.JobAdvertisementService;
import kodlamaio.javahrms.core.utilities.results.DataResult;
import kodlamaio.javahrms.core.utilities.results.ErrorDataResult;
import kodlamaio.javahrms.entities.dtos.EmployerJobTitleWithJobAdvertisementDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/jobadvertisements")
@CrossOrigin
public class JobAdvertisementsController {

    private JobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
        this.jobAdvertisementService = jobAdvertisementService;
    }
    @GetMapping("/findByAllActiveJobPostings")
    public ResponseEntity<?> findByAllActiveJobPostings(){
        return ResponseEntity.ok(this.jobAdvertisementService.findByAllActiveJobPostings());
    }

    @GetMapping("/findByAllActiveJobPostingsSortByDate")
    public ResponseEntity<?> findByAllActiveJobPostingsSortByDate(){
        return ResponseEntity.ok(this.jobAdvertisementService.findByAllActiveJobPostingsSortByDate());
    }

    @GetMapping("/findByAllActiveJobPostingsForACompany")
    public ResponseEntity<?> findByAllActiveJobPostingsForACompany(@RequestParam("companyName") String companyName){
        return ResponseEntity.ok(this.jobAdvertisementService.findByAllActiveJobPostingsForACompany(companyName));
    }
    @GetMapping("/findByAllDeActiveJobPostings")
    public ResponseEntity<?> findByAllDeActiveJobPostings(){
        return ResponseEntity.ok(this.jobAdvertisementService.findByAllDeActiveJobPostings());
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
