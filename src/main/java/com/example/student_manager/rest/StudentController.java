package com.example.student_manager.rest;

import com.example.student_manager.model.Student;
import com.example.student_manager.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> hello() {
        return studentService.getAllStudents();
    }

    @GetMapping("/s/{id}")
    public Student getOneStudent(@RequestParam() Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @PutMapping(path = "update/{id}")
    public void updateStudent(@PathVariable("id") Long id,
                              @RequestParam(required = false) String firstName,
                              @RequestParam(required = false) String lastName,
                              @RequestParam(required = false) String email) {
        studentService.updateStudent(id, firstName, lastName, email);
    }

    @DeleteMapping(path = "delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        studentService.delete(id);
    }
}
