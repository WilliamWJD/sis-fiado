package com.wjd.sisfiado.resources.exceptions;

import com.wjd.sisfiado.services.exceptions.DataIntegrityException;
import com.wjd.sisfiado.services.exceptions.ResourceNotFoundExceptionApp;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(DataIntegrityException.class)
    public ResponseEntity<StandardError> databaseException(DataIntegrityException e, HttpServletRequest request){
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setError("Integrity Exception");
        err.setStatus(HttpStatus.BAD_REQUEST.value());
        err.setPath(request.getRequestURI());
        err.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(ResourceNotFoundExceptionApp.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundExceptionApp e, HttpServletRequest request){
        StandardError err = new StandardError();
        err.setTimestamp(Instant.now());
        err.setError("Entity not found");
        err.setStatus(HttpStatus.NOT_FOUND.value());
        err.setPath(request.getRequestURI());
        err.setMessage(e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationError> methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request){
        ValidationError err = new ValidationError();
        err.setTimestamp(Instant.now());
        err.setError("Validation Exception");
        err.setStatus(HttpStatus.UNPROCESSABLE_ENTITY.value());
        err.setPath(request.getRequestURI());
        err.setMessage(e.getMessage());

        for(FieldError f:  e.getBindingResult().getFieldErrors()){
            err.addError(f.getField(), f.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
    }
}
