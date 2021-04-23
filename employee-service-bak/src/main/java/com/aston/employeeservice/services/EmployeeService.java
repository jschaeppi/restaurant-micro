package com.aston.employeeservice.services;

import com.aston.employeeservice.domain.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getEmployees();

    public Employee getEmployee(Integer id);

//    public Employee getEmployeeByName();

    public Employee getEmployeeByNum(String empNum);

    public Employee addEmployee(Employee employee);

    public Employee updateEmployee(Employee employee);
}
