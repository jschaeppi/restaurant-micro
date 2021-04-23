package com.aston.employeeservice.rest;

import com.aston.employeeservice.domain.Employee;
import com.aston.employeeservice.services.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/api/v1/employee")
public class EmployeeRest {

    Logger log = LoggerFactory.getLogger(EmployeeRest.class);

    private EmployeeService employeeService;

    public EmployeeRest(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/")
    public ResponseEntity<List<Employee>> getEmployees() {
        List<Employee> employeeList = this.employeeService.getEmployees();
        if (employeeList.size() == 0) {
            log.debug("Couldn't find employees");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<Employee>());
        }
        return ResponseEntity.ok().body(employeeList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Integer id) {
        Employee employee = this.employeeService.getEmployee(id);
        if (employee.equals(null)) {
            log.debug("Employee couldn't be found with id: " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Employee());
        }
        return ResponseEntity.ok().body(employee);
    }

    @GetMapping("/{empNum}")
    public ResponseEntity<Employee> getEmployeeByName(@PathVariable String empNum) {
        Employee savedEmployee = this.employeeService.getEmployeeByNum(empNum);
        if (savedEmployee.equals(null)) {
            log.debug("Employee with Emp# +" + empNum + " couldn't be found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Employee());
        }
        return ResponseEntity.ok().body(savedEmployee);
    }

    @PostMapping("/")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = this.employeeService.addEmployee(employee);
        if (savedEmployee.equals(null)) {
            log.debug("Employee couldn't be saved!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Employee());
        }
        return ResponseEntity.ok().body(employee);
    }

    @PutMapping("/")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = this.employeeService.addEmployee(employee);
        if (savedEmployee.equals(null)) {
            log.debug("Employee couldn't be updated properly.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Employee());
        }
        return ResponseEntity.ok().body(employee);
    }



}
