package com.rct.core.service.impl;

import com.rct.core.service.DepartmentService;
import com.rct.core.service.model.Department;
import com.rct.core.service.model.mapper.DepartmentMapper;
import com.rct.infra.persistence.repository.DepartmentRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.UUID;

import static java.util.stream.StreamSupport.stream;

@Transactional
@ApplicationScoped
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository repository;
    private final DepartmentMapper mapper;

    public Department create(Department department) {
        return mapper.fromEntity(
                repository.create(mapper.fromModel(department))
        );

    }

    public List<Department> findByName(String name) {
        return mapper.fromEntities(stream(repository.findByName(name).spliterator(), false)
                .toList());

    }

    public Department findById(UUID id) {
        return mapper.fromEntity(repository.findById(id));
    }

    public List<Department> findAll() {
        return mapper.fromEntities(stream(repository.findAll().spliterator(), false)
                .toList());

    }

    public Department update(Department department) {
        return mapper.fromEntity(repository.update(mapper.fromModel(department)));
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }


}
