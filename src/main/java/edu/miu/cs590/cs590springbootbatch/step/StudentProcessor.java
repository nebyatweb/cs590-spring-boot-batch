package edu.miu.cs590.cs590springbootbatch.step;

import edu.miu.cs590.cs590springbootbatch.domain.Student;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class StudentProcessor implements ItemProcessor<Student, Student> {

    @Override
    public Student process(Student student) throws Exception {
        Student processedStudent = new Student();
        long age = student.getAge();
        LocalDate dob = LocalDate.now().minusYears(age).withDayOfMonth(1).withMonth(1);
        processedStudent.setFirstName(student.getFirstName());
        processedStudent.setLastName(student.getLastName());
        processedStudent.setGpa(student.getGpa());
        processedStudent.setDob(dob);
        System.out.println("Converted from age to DOB");
        return processedStudent;
    }
}
