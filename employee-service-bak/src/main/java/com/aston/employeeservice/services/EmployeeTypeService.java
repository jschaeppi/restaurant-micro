package com.aston.employeeservice.services;

import com.aston.employeeservice.domain.EmployeeType;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EmployeeTypeService {

    public List<EmployeeType> getTypes();

    public EmployeeType getType(Integer id);

    public EmployeeType getByType(String type);

    public EmployeeType addType(@RequestBody EmployeeType employeeType);

    public EmployeeType updateType(@RequestBody EmployeeType employeeType);
}
