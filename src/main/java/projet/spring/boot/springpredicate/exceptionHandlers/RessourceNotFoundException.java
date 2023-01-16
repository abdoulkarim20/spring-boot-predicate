package projet.spring.boot.springpredicate.exceptionHandlers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FOUND)
public class RessourceNotFoundException extends Exception{
    private static final long SerialVersionUID=1L;

    public RessourceNotFoundException(String message) {
        super(message);
    }
}
