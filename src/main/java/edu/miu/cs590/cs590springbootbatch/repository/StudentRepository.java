package edu.miu.cs590.cs590springbootbatch.repository;

import edu.miu.cs590.cs590springbootbatch.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, Long> {

}
