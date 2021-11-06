package com.example.student_manager;

import com.example.student_manager.model.Student;
import com.example.student_manager.model.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student student = new Student(
                    "Benjamin",
                    "Opara",
                    "benjamin@ben.com",
                    LocalDate.of(1999, Month.JULY, 2)
            );
            Student student1 = new Student(
                    "Nwa",
                    "Opara",
                    "benjamin@ben.com",
                    LocalDate.of(1992, Month.SEPTEMBER, 11)
            );
            Student student2 = new Student(
                    "Eze",
                    "Benja",
                    "benjamin@ben.com",
                    LocalDate.of(1996, Month.NOVEMBER, 4)
            );

            studentRepository.saveAll(
                    List.of(student, student1, student2)
            );
        };
    }
}
