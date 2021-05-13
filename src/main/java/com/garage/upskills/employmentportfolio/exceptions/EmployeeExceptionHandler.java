package com.garage.upskills.employmentportfolio.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;

@ControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler(value = EmployeeNotFoundException.class)
    public ResponseEntity<Object> handleEmployeeNotFoundException(EmployeeNotFoundException exception) {
        return new ResponseEntity<>("No Data Found: " + exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = BadEmployeeDataException.class)
    public ResponseEntity<Object> handleBadEmployeeDataException(BadEmployeeDataException exception) {
        return new ResponseEntity<>("Bad Request: " + exception.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = SQLException.class)
    public ResponseEntity<Object> handleDatabaseException(SQLException exception) {
        return new ResponseEntity<>("Database Error: " + exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
