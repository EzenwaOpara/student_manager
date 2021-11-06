package com.example.student_manager.service;

import com.example.student_manager.model.Student;
import com.example.student_manager.model.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    public StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        System.out.printf("\n\n\n\n\n\n");
        System.out.println(studentRepository.findAll());
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

        if (studentOptional.isPresent()) {
            throw new IllegalStateException("Email already taken");
        }

        studentRepository.save(student);
    }

    @Transactional
    public void updateStudent(Long studentId,
                              String firstName,
                              String lastName,
                              String email) {

        Student student = studentRepository.findStudentById(studentId)
                .orElseThrow(() -> new IllegalStateException(
                        "student with " + studentId + " does not exist."
                ));

        if (firstName != null && firstName.length() > 0 &&
                Objects.equals(student.getFirstName(), firstName)) {
            student.setFirstName(firstName);
        }

        if (lastName != null && lastName.length() > 0 &&
                Objects.equals(student.getLastName(), lastName)) {
            student.setLastName(lastName);
        }

        if (email != null && email.length() > 0 &&
                Objects.equals(student.getEmail(), email)) {

            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("email is already taken");
            }
            student.setEmail(email);
        }
    }

    public void delete(Long id) {
        Student studentOptional = studentRepository.findStudentById(id)
                .orElseThrow(() -> new IllegalStateException("user does not exist."));
        studentRepository.deleteById(id);
    }

    public Student getStudentById(Long id) {
        Student student = studentRepository.findStudentById(id)
                .orElseThrow(() -> new IllegalStateException("Student with id " + id + " does not exist"));
        return student;
    }
}
