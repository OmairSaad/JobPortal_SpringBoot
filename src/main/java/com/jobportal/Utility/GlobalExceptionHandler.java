package com.jobportal.Utility;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorInfo>> methodArgumentNotValidException(Exception ex, HttpServletRequest request) {
        List<ErrorInfo> resp = new ArrayList<>();
        ((MethodArgumentNotValidException) ex).getAllErrors().forEach(error -> {
            ErrorInfo info = new ErrorInfo(error.getDefaultMessage(),HttpStatus.BAD_REQUEST.value(),new Date());
            resp.add(info);
        });
        return  new ResponseEntity<List<ErrorInfo>>(resp, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorInfo> dataIntegrityViolationException(Exception ex){
       return new ResponseEntity<>(new ErrorInfo("User already exists",HttpStatus.INTERNAL_SERVER_ERROR.value(),new Date()),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorInfo> badCredentialsException(Exception ex){
        return new ResponseEntity<ErrorInfo>(new ErrorInfo("Bad Credentials",HttpStatus.BAD_REQUEST.value(),new Date()),HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorInfo> usernameNotFoundException(Exception ex){
        return new ResponseEntity<>(new ErrorInfo("User not found",HttpStatus.NOT_FOUND.value(),new Date()),HttpStatus.NOT_FOUND);
    }
}
