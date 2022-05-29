package edu.miu.cs590.cs590springbootbatch.service;

import edu.miu.cs590.cs590springbootbatch.domain.Student;
import edu.miu.cs590.cs590springbootbatch.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository repository;

    @Override
    public List<? extends Student> saveAllStudents(List<? extends Student> student) {
        return repository.saveAll(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }
}
