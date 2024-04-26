package miu.cs.ads_datapersisitence.advice;

import miu.cs.ads_datapersisitence.exception.NotFoundException;
import org.modelmapper.spi.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handlePublisherNotFoundException(NotFoundException patientNotFoundException) {
        Map<String , String> errorMessageMap = new HashMap<>();
        errorMessageMap.put("errorMessage", patientNotFoundException.getMessage());
        return errorMessageMap;
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ErrorMessage> handleInvalidCredentialsException(
            BadCredentialsException e) {
        return new ResponseEntity<ErrorMessage>(
                new ErrorMessage(e.getMessage()), HttpStatus.UNAUTHORIZED);
    }
}