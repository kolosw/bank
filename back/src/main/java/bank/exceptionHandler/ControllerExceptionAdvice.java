package bank.exceptionHandler;

import bank.BankApplication;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerExceptionAdvice
  extends ResponseEntityExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(BankApplication.class);

    @ExceptionHandler(value
      = { EntityNotFoundException.class })
    protected ResponseEntity<Object> handleWrongId(
      RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "No object with this ID found";
        log.info("-------Inside of Exception handler:---------");
        log.info("Exception: " + ex);
        log.info("Request: " + request);
        log.info("-------End of Exception handler:---------");
        return handleExceptionInternal(ex, bodyOfResponse, 
          new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}