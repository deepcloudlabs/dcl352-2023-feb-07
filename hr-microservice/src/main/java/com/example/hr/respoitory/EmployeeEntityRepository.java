package com.example.hr.respoitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.hr.entity.EmployeeEntity;

public interface EmployeeEntityRepository extends JpaRepository<EmployeeEntity, String>{
	List<EmployeeEntity> findAllByBirthYearBetween(int begin,int end);
	@Query("select emp from EmployeeEntity emp where emp.birthYear between :begin and :end")
	List<EmployeeEntity> getir(int begin,int end);
}
