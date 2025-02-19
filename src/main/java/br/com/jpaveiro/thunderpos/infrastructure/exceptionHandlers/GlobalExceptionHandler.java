package br.com.jpaveiro.thunderpos.infrastructure.exceptionHandlers;

import br.com.jpaveiro.thunderpos.domain.core.StandardResponse;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.security.InvalidParameterException;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = { EntityExistsException.class })
    public ResponseEntity<StandardResponse> handleEntityExistsException(final EntityExistsException e)
    {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new StandardResponse(
                        HttpStatus.CONFLICT,
                        "Erro! Entidade já existente."
                ));
    }

    @ExceptionHandler(value = { InvalidParameterException.class })
    public ResponseEntity<StandardResponse> handleInvalidParameterException(final InvalidParameterException e)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new StandardResponse(
                        HttpStatus.BAD_REQUEST,
                        "Erro! Parâmetro inválido: ".concat(e.getMessage())
                ));
    }

    @ExceptionHandler(value = { EntityNotFoundException.class })
    public ResponseEntity<StandardResponse> handleEntityNotFoundException(final EntityNotFoundException e)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new StandardResponse(
                        HttpStatus.NOT_FOUND,
                        "Erro! Entidade não existente."
                ));
    }
}
