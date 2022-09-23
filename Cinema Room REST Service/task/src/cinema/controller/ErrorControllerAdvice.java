package cinema.controller;

import cinema.exception.AlreadySoldException;
import cinema.exception.OutOfBoundsException;
import cinema.exception.WrongPasswordException;
import cinema.exception.WrongTokenException;
import cinema.model.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler({
            AlreadySoldException.class,
            OutOfBoundsException.class,
            WrongTokenException.class
    })
    ResponseEntity<ErrorDTO> errorHandler(RuntimeException e) {
        return ResponseEntity.badRequest()
                .body(new ErrorDTO(e.getMessage()));
    }

    @ExceptionHandler
    ResponseEntity<ErrorDTO> errorHandler(WrongPasswordException e) {
        return ResponseEntity.
                status(HttpStatus.UNAUTHORIZED)
                .body(new ErrorDTO(e.getMessage()));
    }
}