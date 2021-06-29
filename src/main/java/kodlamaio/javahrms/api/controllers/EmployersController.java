package kodlamaio.javahrms.api.controllers;

import kodlamaio.javahrms.business.abstracts.EmployerService;
import kodlamaio.javahrms.core.utilities.results.ErrorDataResult;
import kodlamaio.javahrms.entities.concretes.Employer;
import kodlamaio.javahrms.entities.concretes.JobAdvertisement;
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
@RequestMapping("/api/employers")
@CrossOrigin
public class EmployersController {
    private EmployerService employerService;

    @Autowired
    public EmployersController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @GetMapping("/getall")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(this.employerService.getAll());
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Employer employer,@RequestParam(value = "id") int id){
        return ResponseEntity.ok(this.employerService.update(employer,id));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam(value = "id") int id){
        return ResponseEntity.ok(this.employerService.delete(id));
    }


    @PostMapping("/addJobAdvertisement")
    public ResponseEntity<?> addJobAdvertisement(@Valid @RequestBody JobAdvertisement jobAdvertisement){
        return ResponseEntity.ok(this.employerService.addJobAdvertisement(jobAdvertisement));
    }

    @DeleteMapping("/deleteJobAdvertisement")
    public ResponseEntity<?> deleteJobAdvertisement(@RequestParam(value = "id") int id){
        return ResponseEntity.ok(this.employerService.deleteJobAdvertisement(id));
    }

    @PutMapping("/updateJobAdvertisement")
    public ResponseEntity<?> updateJobAdvertisement(@RequestBody JobAdvertisement jobAdvertisement,@RequestParam(value = "id") int id){
        return ResponseEntity.ok(this.employerService.updateJobAdvertisement(jobAdvertisement,id));
    }

    @PostMapping("/setJobAdvertisementIsActive")
    public ResponseEntity<?> setJobAdvertisementIsActive(@RequestParam("isActive") boolean advertisementIsActive,@RequestParam("id") int id){
        return ResponseEntity.ok(this.employerService.setJobAdvertisementIsActive(advertisementIsActive,id));
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
