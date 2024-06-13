package com.student.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.been.Student;

public interface IStudentRepo extends JpaRepository<Student,Long> {

	
	public boolean existsByEmailAndDeleted(String email, boolean b);

	public Optional<Student> findByEmailAndDeleted(String email, boolean b);

	public Optional<Student> findByEmail(String email);
	
	public boolean existsByEmailAndDeletedAndIdNot(String email, boolean b,Long id);

	public Optional<Student> findByIdAndDeleted(Long id, boolean b);

	public Optional<Student> findByid(Long id);

}
