package com.rct.core.service.model.mapper;

import com.rct.core.service.model.Department;
import com.rct.infra.persistence.model.DepartmentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    Department fromEntity(DepartmentEntity entity);
    DepartmentEntity fromModel(Department department);
    List<Department> fromEntities(List<DepartmentEntity> entities);

}
