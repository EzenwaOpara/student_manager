package com.example.student_manager.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findStudentById(Long id);

    Optional<Student> findStudentByFirstName(String firstName);

    Optional<Student> findStudentByLastName(String lastName);

    Optional<Student> findStudentByEmail(String email);

}
