package com.example.second.controller;

import java.time.LocalDate;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.second.model.Student;
import com.example.second.repository.StudentRepository;

@Configuration
public class StudentConfig {
	
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository repository) {
		return args->{
		Student souha= new Student(
    					1L,
    					"Souha",
    					"souhaade@gmail.com",
    					LocalDate.of(2002, 01, 29)
    					);
		Student alex= new Student(
				2L,
				"Alex",
				"alexxander@gmail.com",
				LocalDate.of(2007, 12, 24)
				);
		
    		repository.saveAll(//Run the  hibernate
				List.of(souha,alex)
				);
		
		};
		
		
	}
};
