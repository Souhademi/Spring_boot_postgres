package com.example.second.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.second.model.Student;


@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
	@Query("SELECT s FROM Student s WHERE s.email = ?1")
	Optional<Student> findStudentbyEmail(String email);

}
