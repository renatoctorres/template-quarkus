package com.rct.infra.persistence.repository;

import com.rct.infra.persistence.model.EmployeeEntity;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryConditional;
import software.amazon.awssdk.enhanced.dynamodb.model.QueryEnhancedRequest;

import java.util.UUID;

@RequiredArgsConstructor
@ApplicationScoped
public class EmployeeRepository {
    private DynamoDbTable<EmployeeEntity> table;
    private final DynamoDbEnhancedClient client;

    @PostConstruct
    public void configTable() {
        this.table = client.table("EmployeeEntity", TableSchema.fromBean(EmployeeEntity.class));
    }

    public Iterable<EmployeeEntity> findByName(String name) {
        var queryConditional = QueryConditional
                .keyEqualTo(k -> k.partitionValue(name));

        var queryRequest = QueryEnhancedRequest.builder()
                .queryConditional(queryConditional)
                .build();

        return table.query(queryRequest).items();
    }

    public EmployeeEntity findById(UUID id) {
        return table.getItem(r -> r.key(k -> k.partitionValue(id.toString())));
    }

    public Iterable<EmployeeEntity> findAll() {
        return table.scan().items();
    }

    public EmployeeEntity create(EmployeeEntity employeeEntity) {
        table.putItem(employeeEntity);
        return employeeEntity;
    }

    public EmployeeEntity update(EmployeeEntity employeeEntity) {
        table.updateItem(employeeEntity);
        return employeeEntity;
    }

    public void deleteById(UUID id) {
        var employee = new EmployeeEntity();
        employee.setId(id);
        table.deleteItem(employee);
    }


}
