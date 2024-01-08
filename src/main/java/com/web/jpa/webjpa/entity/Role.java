package com.web.jpa.webjpa.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "jpa_role")
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Role {

    @Id
    private Integer roleId;
    private String roleName;

    @ManyToMany
    private List<Student> students = new ArrayList<>();
}
