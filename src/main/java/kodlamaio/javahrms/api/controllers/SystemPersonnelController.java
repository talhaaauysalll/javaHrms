package kodlamaio.javahrms.api.controllers;

import kodlamaio.javahrms.business.abstracts.SystemPersonnelService;
import kodlamaio.javahrms.core.utilities.results.ErrorDataResult;
import kodlamaio.javahrms.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/systempersonnel")
@CrossOrigin
public class SystemPersonnelController {
    private SystemPersonnelService systemPersonnelService;

    @Autowired
    public SystemPersonnelController(SystemPersonnelService systemPersonnelService) {
        this.systemPersonnelService = systemPersonnelService;
    }
    @PostMapping ("/confirmJobAdvertisement")
    public ResponseEntity<?> confirmJobAdvertisement(@RequestParam("isActive") boolean advertisementIsActive, @RequestParam("id") int id){
        return ResponseEntity.ok(this.systemPersonnelService.confirmJobAdvertisement(advertisementIsActive,id));
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
