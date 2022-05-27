package edu.miu.cs590.cs590springbootbatch.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "gpa")
    private double gpa;
    @Transient
    private long age;
    @Column(name = "dob")
    private LocalDate dob;
}
