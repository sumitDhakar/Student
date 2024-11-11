package com.student.service;

import java.security.Principal;

import org.springframework.http.ResponseEntity;

import com.student.been.AuthResponse;
import com.student.been.Student;
import com.student.payload.StudentLogin;
import com.student.payload.StudentRequest;

public interface AuthStudentService {
	
public Student createStudent(StudentRequest u,String roleId);
	

	public AuthResponse login(StudentLogin authRequest);
	
	

	Student updateuser(StudentRequest request);


}
