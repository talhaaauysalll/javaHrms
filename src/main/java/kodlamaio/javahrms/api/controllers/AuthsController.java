package kodlamaio.javahrms.api.controllers;

import kodlamaio.javahrms.business.abstracts.AuthService;
import kodlamaio.javahrms.core.utilities.results.ErrorDataResult;
import kodlamaio.javahrms.entities.concretes.Employer;
import kodlamaio.javahrms.entities.concretes.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auths")
public class AuthsController {
    private AuthService authService;

    @Autowired
    public AuthsController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/jobseekerregister")
    public ResponseEntity<?> jobSeekerRegister(@Valid @RequestBody JobSeeker jobSeeker){
        return ResponseEntity.ok(this.authService.registerJobSeeker(jobSeeker));
    }
    @PostMapping("/employerregister")
    public ResponseEntity<?> employerRegister(@Valid @RequestBody Employer employer){
        return ResponseEntity.ok(this.authService.registerEmployer(employer));
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
