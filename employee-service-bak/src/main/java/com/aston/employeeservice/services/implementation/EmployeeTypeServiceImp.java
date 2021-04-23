package com.aston.employeeservice.services.implementation;

import com.aston.employeeservice.domain.EmployeeType;
import com.aston.employeeservice.repositories.EmployeeTypeRepository;
import com.aston.employeeservice.services.EmployeeTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeTypeServiceImp implements EmployeeTypeService {

    Logger log = LoggerFactory.getLogger(EmployeeTypeServiceImp.class);

    private EmployeeTypeRepository employeeTypeRepository;

    public EmployeeTypeServiceImp(EmployeeTypeRepository employeeTypeRepository) {
        this.employeeTypeRepository = employeeTypeRepository;
    }

    @Override
    public List<EmployeeType> getTypes() {
        List<EmployeeType> employeeTypeList = new ArrayList<>();
        this.employeeTypeRepository.findAll().iterator().forEachRemaining(employeeTypeList::add);
        return employeeTypeList;
    }

    @Override
    public EmployeeType getType(Integer id) {
        return this.employeeTypeRepository.findById(id).orElse(new EmployeeType());
    }

    @Override
    public EmployeeType getByType(String type) {
        return this.employeeTypeRepository.getEmployeeTypeByType(type);
    }

    @Override
    public EmployeeType addType(EmployeeType employeeType) {
        return this.employeeTypeRepository.save(employeeType);
    }

    @Override
    public EmployeeType updateType(EmployeeType employeeType) {
        return this.employeeTypeRepository.save(employeeType);
    }
}
