package com.student.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.been.Student;
import com.student.payload.StudentRequest;
import com.student.service.AuthStudentService;

@RestController
@RequestMapping("/api/students")
@CrossOrigin("*")
public class StudentController {

    @Autowired
    private AuthStudentService studentService;

   
    @PutMapping("/update")
    public ResponseEntity<?> updateUser(@RequestBody StudentRequest request) {
    	 Student updatedStudent = studentService.updateuser(request);
         return new ResponseEntity<>(updatedStudent, HttpStatus.ACCEPTED);  }
}

