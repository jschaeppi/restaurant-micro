package com.aston.employeeservice.rest;

import com.aston.employeeservice.domain.EmployeeType;
import com.aston.employeeservice.services.EmployeeTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/api/v1/employeeType")
public class EmployeeTypeRest {

    Logger log = LoggerFactory.getLogger(EmployeeTypeRest.class);

    EmployeeTypeService employeeTypeService;

    public EmployeeTypeRest(EmployeeTypeService employeeTypeService) { this.employeeTypeService = employeeTypeService; }

    @GetMapping("/")
    public ResponseEntity<List<EmployeeType>> getTypes() {
        List<EmployeeType> employeeTypeList = this.employeeTypeService.getTypes();
        if (employeeTypeList.size() == 0) {
            log.warn("No employee types found!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<EmployeeType>());
        }
        return ResponseEntity.ok().body(employeeTypeList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeType> getType(@PathVariable Integer id) {

        EmployeeType employeeType = this.employeeTypeService.getType(id);
        if (employeeType == null) {
            log.warn("Employee type is invalid");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new EmployeeType());
        }
        return ResponseEntity.ok().body(employeeType);
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<EmployeeType> getTypesByType(@PathVariable String type) {
        EmployeeType employeeType = this.employeeTypeService.getByType(type);
        if (employeeType == null) {
            log.warn("Employee type is invalid");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new EmployeeType());
        }
        return ResponseEntity.ok().body(employeeType);
    }

    @PostMapping("/")
    public ResponseEntity<EmployeeType> createType(@RequestBody EmployeeType employeeType) {
        EmployeeType savedEmployeeType = this.employeeTypeService.addType(employeeType);
        if (savedEmployeeType == null) {
            log.warn("Unable to save employee type");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new EmployeeType());
        }
        return ResponseEntity.ok().body(savedEmployeeType);
    }

    @PostMapping("/list")
    public ResponseEntity<List<EmployeeType>> createTypes(@RequestBody List<EmployeeType> employeeType) {
        List<EmployeeType> savedEmployeeTypeList = this.employeeTypeService.addTypeList(employeeType);
        if (savedEmployeeTypeList == null) {
            log.warn("Unable to save employee type");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<EmployeeType>());
        }
        return ResponseEntity.ok().body(savedEmployeeTypeList);
    }

    @PutMapping("/")
    public ResponseEntity<EmployeeType> updateType(@RequestBody EmployeeType employeeType) {
        EmployeeType updatedEmployeeType = this.employeeTypeService.updateType(employeeType);
        if (updatedEmployeeType == null) {
            log.warn("Employee type is invalid");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new EmployeeType());
        }
        return ResponseEntity.ok().body(updatedEmployeeType);
    }
}
