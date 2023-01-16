package projet.spring.boot.springpredicate.exceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = RessourceNoteFoundException.class)
    public ResponseEntity<?>ressourceNotFoundException(RessourceNoteFoundException ressourceNoteFoundException){
        ErrorDetails errorDetails=new  ErrorDetails(
                new Date(),
                ressourceNoteFoundException.getMessage(),
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(errorDetails,HttpStatus.BAD_REQUEST);
    }
}
