package com.gateways.renato.springbootjwt.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class NoUserExceptionAdvice {

    @ExceptionHandler(NoUserException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Usuário não encontrado")
    public void handNotFound(Exception ex){
        log.error(ex.getMessage());
    }
}
