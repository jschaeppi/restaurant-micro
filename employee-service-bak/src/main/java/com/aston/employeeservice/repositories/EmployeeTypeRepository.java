package com.aston.employeeservice.repositories;

import com.aston.employeeservice.domain.EmployeeType;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeTypeRepository extends CrudRepository<EmployeeType, Integer> {

    public EmployeeType getEmployeeTypeByType(String type);
}
