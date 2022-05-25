package edu.miu.cs590.cs590springbootbatch.config;

import edu.miu.cs590.cs590springbootbatch.domain.Student;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
//
//@Configuration
//@EnableBatchProcessing
public class BatchConfiguration {
//
//    @Autowired
//    public JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    public StepBuilderFactory stepBuilderFactory;
//
//    @Value("${file.input}")
//    private String fileInput;

//    @Bean
//    public FlatFileItemReader reader() {
//        return new FlatFileItemReaderBuilder().name("coffeeItemReader")
//                .resource(new ClassPathResource(fileInput))
//                .delimited()
//                .names(new String[] { "firstName", "lastName", "gpa", "age" })
//                .fieldSetMapper(new BeanWrapperFieldSetMapper() {{
//                    setTargetType(Student.class);
//                }})
//                .build();
//    }
}
