package com.rct.core.service;

import com.rct.core.service.model.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    Employee create(Employee employee);

    List<Employee> findByName(String name);

    Employee findById(UUID id);

    List<Employee> findAll();

    Employee update(Employee employee);

    void deleteById(UUID id);
}
