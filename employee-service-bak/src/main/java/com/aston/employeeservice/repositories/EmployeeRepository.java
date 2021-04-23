package com.aston.employeeservice.repositories;

import com.aston.employeeservice.domain.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

    public Employee findEmployeeByEmpNum(String empNum);
}
