package com.rct.core.service.impl;

import com.rct.core.service.EmployeeService;
import com.rct.core.service.model.Employee;
import com.rct.core.service.model.mapper.EmployeeMapper;
import com.rct.infra.persistence.repository.EmployeeRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;
import static java.util.stream.StreamSupport.stream;

@Transactional
@ApplicationScoped
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;

    public Employee create(Employee employee) {
        return mapper.fromEntity(repository.create(mapper.fromModel(employee)));
    }

    public List<Employee> findByName(String name) {
        return mapper.fromEntities(stream(repository.findByName(name).spliterator(), false).toList());
    }

    public Employee findById(UUID id) {
        return mapper.fromEntity(repository.findById(id));
    }

    public List<Employee> findAll() {
        return mapper.fromEntities(stream(repository.findAll().spliterator(), false).toList());

    }

    public Employee update(Employee employee) {
        return mapper.fromEntity(repository.update(mapper.fromModel(employee)));
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }


}
