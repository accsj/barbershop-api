package org.barbershop.api.infra.exception;

import org.barbershop.api.core.DTO.ResponseDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarErro404() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarErro400(MethodArgumentNotValidException exception) {
        var erros = exception.getFieldErrors();
        return ResponseEntity.badRequest().body(erros.stream().map(ResponseDTO::new).toList());
    }

    @ExceptionHandler(EmailJaExistenteException.class)
    public ResponseEntity tratarErroEmailJaExistente(EmailJaExistenteException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO(exception.getMessage()));
    }

    @ExceptionHandler(RgCpfJaExistenteException.class)
    public ResponseEntity tratarErroRgCpfJaExistente(RgCpfJaExistenteException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDTO(exception.getMessage()));
    }


}
