package com.student.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentRequest {

	private Long id;
	private String email;
	private String studentName;


	private String password;
	
}
