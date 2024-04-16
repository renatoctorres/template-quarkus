package com.rct.core.service.model.mapper;

import com.rct.core.service.model.Employee;
import com.rct.infra.persistence.model.EmployeeEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    Employee fromEntity(EmployeeEntity entity);
    EmployeeEntity fromModel(Employee employee);
    List<Employee> fromEntities(List<EmployeeEntity> entities);

}
