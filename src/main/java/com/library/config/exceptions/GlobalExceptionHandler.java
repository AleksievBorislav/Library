package com.library.config.exceptions;

import com.library.config.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({BookNotFoundException.class})
    public ResponseEntity<Object> handleBookNotFoundException(BookNotFoundException exception) {
        return handleBasicExceptions(exception);
    }

    @ExceptionHandler({BookAlreadyExistsException.class})
    public ResponseEntity<Object> handleBookAlreadyExistsException(BookAlreadyExistsException exception) {
        return handleBasicExceptions(exception);
    }

    @ExceptionHandler({ReaderNotFoundException.class})
    public ResponseEntity<Object> handleReaderNotFoundException(ReaderNotFoundException exception) {
        return handleBasicExceptions(exception);
    }

    @ExceptionHandler({ReaderAlreadyExistsException.class})
    public ResponseEntity<Object> handleReaderAlreadyExistsException(ReaderAlreadyExistsException exception) {
        return handleBasicExceptions(exception);
    }

    @ExceptionHandler({BorrowingNotFoundException.class})
    public ResponseEntity<Object> handleBorrowingNotFoundException(BorrowingNotFoundException exception) {
        return handleBasicExceptions(exception);
    }

    ResponseEntity<Object> handleBasicExceptions(Exception exception){
        Logger.LOGGER.error(exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }
}