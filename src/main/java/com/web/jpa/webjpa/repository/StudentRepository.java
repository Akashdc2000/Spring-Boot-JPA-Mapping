package com.web.jpa.webjpa.repository;

import com.web.jpa.webjpa.entity.Student;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

//    @EntityGraph(attributePaths = {"laptop", "contact"})
//    Optional<Student> findById(Integer studentId);

//    @EntityGraph(attributePaths = {"laptop", "contact", "roles"})
//    @Query("SELECT s FROM Student s LEFT JOIN FETCH s.contact LEFT JOIN FETCH s.roles WHERE s.studentId = :studentId")
//    Optional<Student> findStudentWithDetails(Integer studentId);
}
