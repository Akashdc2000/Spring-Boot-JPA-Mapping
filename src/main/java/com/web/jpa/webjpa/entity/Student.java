package com.web.jpa.webjpa.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jpa_student")
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Student {

    @Id
    private Integer studentId;
    private String name;
    private String about;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private Laptop laptop;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Contact> contact = new ArrayList<>();

    @ManyToMany(mappedBy = "students", cascade = CascadeType.ALL)
    private List<Role> roles = new ArrayList<>();
}
