package com.rct.core.service;



import com.rct.core.service.model.Department;

import module java.base;

public interface DepartmentService {
    Department create(Department department);
    List<Department> findByName(String name);
    Department findById(UUID id);

    List<Department> findAll();

    Department update(Department department);
    void deleteById(UUID id);
}
