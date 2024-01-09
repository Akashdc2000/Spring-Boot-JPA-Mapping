package com.web.jpa.webjpa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Validated
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @NotNull(message = "Id must not be Null")
    @Min(value = 1,message = "Id not less than 1")
    @Max(value = 20,message = "Id not greater than 20")
    private Long id;

    @Size(min = 3,max = 5,message = "BookId must be between 3-5 characters")
    @NotEmpty(message = "BookId must not be Null or empty")
    private String bookId;

    @NotBlank(message = "BookName must not be blank(not null + at least one non-whitespace)")
    private String bookName;

    @Email
    @Pattern(regexp ="^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$",
            message = "Email not Valid...")
    @NotBlank(message = "Email must not be blank")
    private String bookStoreEmail;

    public Book(String bookId, String bookName, String bookStoreEmail) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookStoreEmail = bookStoreEmail;
    }
}
