package com.example.hr.adapter;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.hexgonal.Adapter;
import com.example.hr.domain.Employee;
import com.example.hr.domain.TcKimlikNo;
import com.example.hr.entity.EmployeeEntity;
import com.example.hr.repository.EmployeeRepository;
import com.example.hr.respoitory.EmployeeEntityRepository;

@Repository
@Adapter(port = EmployeeRepository.class)
public class EmployeeRepositoryJpaAdapter implements EmployeeRepository {
	private final EmployeeEntityRepository empRepo;
	private final ModelMapper modelMapper;
	
	public EmployeeRepositoryJpaAdapter(EmployeeEntityRepository empRepo, ModelMapper modelMapper) {
		this.empRepo = empRepo;
		this.modelMapper = modelMapper;
	}

	@Override
	public Optional<Employee> findByTcKimlikNo(TcKimlikNo kimlikNo) {
		return empRepo.findById(kimlikNo.getValue())
				      .map(employeeEntity -> modelMapper.map(employeeEntity, Employee.class));
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.MANDATORY)
	public Employee persist(Employee employee) {
		var employeeEntity = modelMapper.map(employee, EmployeeEntity.class);
		return modelMapper.map(empRepo.save(employeeEntity), Employee.class);
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED,propagation = Propagation.MANDATORY)
	public void removeEmployee(Employee employee) {
		empRepo.deleteById(employee.getTcKimlikNo().getValue());
	}

}
