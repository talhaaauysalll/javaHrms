package kodlamaio.javahrms.api.controllers;


import kodlamaio.javahrms.business.abstracts.WorkTypeService;
import kodlamaio.javahrms.core.utilities.results.ErrorDataResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/worktypes")
@CrossOrigin
public class WorkTypesController {
    private WorkTypeService workTypeService;

    @Autowired
    public WorkTypesController(WorkTypeService workTypeService) {
        this.workTypeService = workTypeService;
    }

    @GetMapping("/findByAll")
    public ResponseEntity<?> findByAll(){
        return ResponseEntity.ok(this.workTypeService.findByAll());
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
