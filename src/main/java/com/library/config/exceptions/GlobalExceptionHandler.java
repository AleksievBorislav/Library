package com.library.config.exceptions;

import com.library.config.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmptyResultDataAccessException.class)
    @ResponseBody
    public ExceptionDTO NotFoundExceptionHandler(EmptyResultDataAccessException e){
        ExceptionDTO dto = new ExceptionDTO("Entry not found",HttpStatus.NOT_FOUND.value());
        return dto;
    }

//    @ExceptionHandler(value = {NotFoundException.class})
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ResponseBody
//    public ExceptionDTO handleNotFound(Exception e) {
//        ExceptionDTO dto = new ExceptionDTO();
//        dto.setMsg(e.getMessage());
//        dto.setStatus(HttpStatus.NOT_FOUND.value());
//        e.printStackTrace();
//        return dto;
//    }
}