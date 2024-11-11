package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.been.AuthResponse;
import com.student.been.Student;
import com.student.payload.StudentLogin;
import com.student.payload.StudentRequest;
import com.student.service.AuthStudentService;

@RestController
@RequestMapping("/api/auth/")
@CrossOrigin("*")

public class AuthController {

	
	@Autowired
	private AuthStudentService userServices;
	
	
	@PostMapping("{role}")
	public ResponseEntity<?> createStudent(@RequestBody StudentRequest student,@PathVariable String role) {
		System.out.println(student);
		
		return new ResponseEntity<Student>(this.userServices.createStudent(student,role), HttpStatus.CREATED);
	}
	
	
	@PostMapping("/signin")
	public ResponseEntity<?> login(@RequestBody StudentLogin authRequest) {
		return new ResponseEntity<AuthResponse>(this.userServices.login(authRequest), HttpStatus.ACCEPTED);
	}

}
