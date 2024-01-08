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
@Table(name = "jpa_laptops")
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Laptop {

    @Id
    private Integer laptopId;
    private String brand;
    private String model;

    @OneToOne
    @JoinColumn(name = "studentId")
    private Student student;
}
