package com.example.second.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.second.model.Student;
import com.example.second.serivce.StudentService;

import jakarta.transaction.Transactional;

@RestController
//@RequestMapping(path="api/v1/Student")


public class StudentController {
	
	@Autowired
	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		
		this.studentService = studentService;
	}


	@GetMapping
    public List<Student> getStudents() {
	return	studentService.getStudents();
    	
	}
	
	@PostMapping
	public void addNewStudent(@RequestBody Student student) {
		 studentService.addStudent(student);
	}
	
	@DeleteMapping(path="{studentid}")
	public void delateStudent(@PathVariable("studentid")Long studentid) {
		studentService.delateStudent(studentid);
	}
	
	@PutMapping(path="studentid")
	public void updateStudent(@PathVariable("studentid")Long studentid,
			@RequestParam(required=false)String name,
			@RequestParam(required=false)String email 
			){
		studentService.updateStudent(studentid,name,email);
	}
}