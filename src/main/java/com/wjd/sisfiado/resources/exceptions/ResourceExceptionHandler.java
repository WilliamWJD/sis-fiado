package com.wjd.sisfiado.resources.exceptions;

import com.wjd.sisfiado.services.exceptions.DataIntegrityException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}
