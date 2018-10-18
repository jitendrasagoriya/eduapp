package com.jitendra.eduapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jitendra.eduapp.domin.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
	@Query("SELECT F FROM Student F WHERE F.email = :email")
	public Student getByEmail(@Param("email") String email);
	
	@Query("SELECT F FROM Student F WHERE F.nickName = :nickName")
	public Student getByNickName(@Param("nickName") String nickName);

}
