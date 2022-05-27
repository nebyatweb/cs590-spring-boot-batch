package edu.miu.cs590.cs590springbootbatch.step;

import edu.miu.cs590.cs590springbootbatch.domain.Student;
import edu.miu.cs590.cs590springbootbatch.repository.StudentRepository;
import edu.miu.cs590.cs590springbootbatch.service.StudentService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentWriter implements ItemWriter<Student> {

    @Autowired
    private StudentService studentService;

    @Override
    public void write(List<? extends Student> students) throws Exception {
        System.out.println("Student data saved: " + students);
        studentService.saveAllStudents(students);
    }
}
