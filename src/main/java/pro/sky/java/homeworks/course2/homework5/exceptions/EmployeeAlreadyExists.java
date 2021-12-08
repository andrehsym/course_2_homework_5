package pro.sky.java.homeworks.course2.homework5.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "This employee already exists in our list")
public class EmployeeAlreadyExists extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "This employee already exists in our list";

    public EmployeeAlreadyExists() { super(DEFAULT_MESSAGE);}
   public EmployeeAlreadyExists(String message) {
        super(DEFAULT_MESSAGE);
    }

    public EmployeeAlreadyExists(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeAlreadyExists(Throwable cause) {
        super(cause);
    }



}
