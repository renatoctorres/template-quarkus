package com.rct.infra.persistence.repository;

import com.rct.infra.persistence.model.DepartmentEntity;
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
public class DepartmentRepository {
    private DynamoDbTable<DepartmentEntity> table;
    private final DynamoDbEnhancedClient client;

    @PostConstruct
    public void configTable() {
        this.table = client.table("DepartmentEntity", TableSchema.fromBean(DepartmentEntity.class));
    }

    public Iterable<DepartmentEntity> findByName(String name) {
        var queryConditional = QueryConditional
                .keyEqualTo(k -> k.partitionValue(name));

        var queryRequest = QueryEnhancedRequest.builder()
                .queryConditional(queryConditional)
                .build();

        return table.query(queryRequest).items();
    }

    public DepartmentEntity findById(UUID id) {
        return table.getItem(r -> r.key(k -> k.partitionValue(id.toString())));
    }

    public  Iterable<DepartmentEntity> findAll() {
        return table.scan().items();
    }

    public DepartmentEntity create(DepartmentEntity departmentEntity) {
        table.putItem(departmentEntity);
        return departmentEntity;
    }

    public DepartmentEntity update(DepartmentEntity departmentEntity) {
        table.updateItem(departmentEntity);
        return departmentEntity;
    }

    public void deleteById(UUID id) {
        var department = new DepartmentEntity();
        department.setId(id);
        table.deleteItem(department);
    }


}
