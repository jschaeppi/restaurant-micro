package com.aston.employeeservice.rest;

import com.aston.employeeservice.domain.EmployeeType;
import com.aston.employeeservice.services.EmployeeTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/v1/employeeType")
public class EmployeeTypeRest {

    Logger log = LoggerFactory.getLogger(EmployeeTypeRest.class);

    EmployeeTypeService employeeTypeService;

    public EmployeeTypeRest(EmployeeTypeService employeeTypeService) { this.employeeTypeService = employeeTypeService; }

    @GetMapping("/")
    public List<EmployeeType> getTypes() {
        return this.employeeTypeService.getTypes();
    }

    @GetMapping("/{id}")
    public EmployeeType getType(@PathVariable Integer id) {
        return this.employeeTypeService.getType(id);
    }

    @GetMapping("/{type}")
    public EmployeeType getTypesByType(@PathVariable String type) {
        return this.employeeTypeService.getByType(type);
    }

    @PostMapping("/")
    public EmployeeType createType(@RequestBody EmployeeType employeeType) {
        return this.employeeTypeService.addType(employeeType);
    }

    @PutMapping("/")
    public EmployeeType updateType(@RequestBody EmployeeType employeeType) {
        return this.employeeTypeService.updateType(employeeType);
    }
}
