package com.gk2.rest.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gk3.rest.entity.Student;
import com.gk4.exception.handler.StudentExceptionResponse;
import com.gk4.exception.handler.StudentNotFoundException;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> studentList;
	
	@PostConstruct
	public void loadData() {
		studentList = new ArrayList<Student>();
		studentList.add(new Student("Gk1", "Gp1"));
		studentList.add(new Student("Gk2", "Gp2"));
		studentList.add(new Student("Gk3", "Gp3"));
		studentList.add(new Student("Gk4", "Gp4"));
	}
	
	@GetMapping("/getAllStudents")
	public List<Student> getAllStudents(){
		
		
		return studentList;
	}
	
	@GetMapping("/getAllStudents/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		
		if(studentList.size() <= studentId || studentList == null) {
			throw new StudentNotFoundException("The Given Student is not Present");
		}
		
		return studentList.get(studentId);
	}
	
	
}
