package com.web.jpa.webjpa.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomExceptionResponseDTO {

    private Integer status;

    private String message;

    private String url;
}
