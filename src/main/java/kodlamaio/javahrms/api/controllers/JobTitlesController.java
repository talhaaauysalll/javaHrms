package kodlamaio.javahrms.api.controllers;


import kodlamaio.javahrms.business.abstracts.JobTitleService;
import kodlamaio.javahrms.core.utilities.results.ErrorDataResult;
import kodlamaio.javahrms.entities.concretes.JobTitle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RequestMapping("/api/jobtitles")
@RestController
public class JobTitlesController {
    private JobTitleService jobTitleService;

    @Autowired
    public JobTitlesController(JobTitleService jobTitleService) {
        this.jobTitleService = jobTitleService;
    }

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody JobTitle jobTitle){
        return ResponseEntity.ok(this.jobTitleService.add(jobTitle));
    }
    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.jobTitleService.getAll());
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
