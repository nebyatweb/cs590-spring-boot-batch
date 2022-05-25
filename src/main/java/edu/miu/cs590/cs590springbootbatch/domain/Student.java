package edu.miu.cs590.cs590springbootbatch.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "GPA")
    private double gpa;
    @Column(name = "date_of_birth")
    private LocalDate dob;
}
