package com.web.jpa.webjpa.exception;

import com.web.jpa.webjpa.exception.dto.CustomExceptionResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler({CustomException.class})
    public ResponseEntity<CustomExceptionResponseDTO> customExceptionHandler(HttpClientErrorException exception, HttpServletRequest request) {

        CustomExceptionResponseDTO responseDTO = new CustomExceptionResponseDTO();
        responseDTO.setStatus(exception.getStatusCode().value());
        responseDTO.setMessage(exception.getStatusText());
        responseDTO.setUrl(String.valueOf(request.getRequestURL()));

        log.error("CustomException : {}" , responseDTO);

        return ResponseEntity.status(exception.getStatusCode()).body(responseDTO);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<CustomExceptionResponseDTO> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception,
            HttpServletRequest request
    ) {
        CustomExceptionResponseDTO responseDTO = new CustomExceptionResponseDTO();
        String details = exception
                .getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining("; "));

        responseDTO.setStatus(HttpStatus.BAD_REQUEST.value());
        responseDTO.setMessage(details);
        responseDTO.setUrl(String.valueOf(request.getRequestURL()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseDTO);
    }
}
