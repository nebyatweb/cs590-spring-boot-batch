package edu.miu.cs590.cs590springbootbatch.config;

import edu.miu.cs590.cs590springbootbatch.domain.Student;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfiguration {

    @Autowired
    JobBuilderFactory jobBuilderFactory;

    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Autowired
    ItemProcessor<Student, Student> itemProcessor;

    @Autowired
    ItemWriter<Student> itemWriter;

    @Bean
    public Job job() {
        return jobBuilderFactory.get("Student-Load")
                .incrementer(new RunIdIncrementer())
                .start(step())
                .build();
    }

    @Bean
    public FlatFileItemReader<Student> itemReader() {
        FlatFileItemReader<Student> reader = new FlatFileItemReader<>();
        reader.setResource(new ClassPathResource("studentData.csv"));
        reader.setName("CSV-Reader");
        reader.setLinesToSkip(1);
        reader.setLineMapper(lineMapper());
        return reader;
    }

    @Bean
    public LineMapper<Student> lineMapper() {
        DefaultLineMapper<Student> defaultLineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames(new String[]{"firstName", "lastName", "gpa", "age"});

        BeanWrapperFieldSetMapper<Student> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Student.class);

        defaultLineMapper.setLineTokenizer(lineTokenizer);
        defaultLineMapper.setFieldSetMapper(fieldSetMapper);

        return defaultLineMapper;
    }

    @Bean
    public Step step() {
        return stepBuilderFactory.get("Student-file-load")
                .<Student, Student>chunk(10)
                .reader(itemReader())
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();
    }
}
