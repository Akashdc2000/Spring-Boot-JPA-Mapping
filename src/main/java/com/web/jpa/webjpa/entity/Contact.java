package com.web.jpa.webjpa.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jpa_contact")
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Contact {

    @Id
    private Integer contactId;
    private String contactNo;
    private String contactName;

    @ManyToOne
    @JoinColumn(name = "studentId")
    private Student student;

}
