package com.web.jpa.webjpa.exception;

import com.web.jpa.webjpa.exception.dto.CustomExceptionResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.http.HttpServletRequest;

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
}
