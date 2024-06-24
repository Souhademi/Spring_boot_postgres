package com.example.second.serivce;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.second.model.Student;
import com.example.second.repository.StudentRepository;

import jakarta.transaction.Transactional;


@Service	
public class StudentService {
	
	private final StudentRepository studentRepository; 

	@Autowired
	 public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}


	public List<Student> getStudents() {
		return studentRepository.findAll();
	 
	}
	public void addStudent(Student student) {
		Optional<Student> studentByEmail =studentRepository.findStudentbyEmail(student.getEmail());
		if (studentByEmail.isPresent()) {throw new IllegalStateException("email taken");}
		
		studentRepository.save(student);
	}
	
	
	public void delateStudent(final Long studentid) {
		boolean existStudent = studentRepository.existsById(studentid);
		if(existStudent == false) {throw new IllegalStateException("student with id " +studentid+ "does not exists");}
		studentRepository.deleteById(studentid);
	}
	
	
	@Transactional
	public void updateStudent(final Long studentid,String name, String email) {
		Student student = studentRepository.findById(studentid).orElseThrow(()-> new IllegalStateException(
							"student with id " +studentid+ "does not exists"));
		if (name != null && name.length()>0 && Objects.equals(student.getName(), name)) {
			student.setName(name);
		}
		student.setName(name);	
		
		if (email != null && email.length()>0 && Objects.equals(student.getEmail(), email)) {
			
		Optional<Student> studentByEmail =studentRepository.findStudentbyEmail(student.getEmail());
		
		if (studentByEmail.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		
		student.setEmail(email);	
		}
	}

}
