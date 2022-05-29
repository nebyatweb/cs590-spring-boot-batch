package edu.miu.cs590.cs590springbootbatch.service;

import edu.miu.cs590.cs590springbootbatch.domain.Student;

import java.util.List;


public interface StudentService {
    List<? extends Student> saveAllStudents(List<? extends Student> student);
    List<Student> getAllStudents();
}
