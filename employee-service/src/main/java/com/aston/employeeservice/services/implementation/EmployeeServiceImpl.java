package com.aston.employeeservice.services.implementation;

import com.aston.employeeservice.domain.Employee;
import com.aston.employeeservice.repositories.EmployeeRepository;
import com.aston.employeeservice.services.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employeeList = new ArrayList<>();
        this.employeeRepository.findAll().iterator().forEachRemaining(employeeList::add);
        return employeeList;
    }

    @Override
    public Employee getEmployee(Integer id) {
        return this.employeeRepository.findById(id).orElse(null);
    }

/*    @Override
    public Employee getEmployeeByName() {
        return null;
    }*/

    @Override
    public Employee getEmployeeByNum(String empNum) {
        return this.employeeRepository.findEmployeeByEmpNum(empNum);
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }
}
