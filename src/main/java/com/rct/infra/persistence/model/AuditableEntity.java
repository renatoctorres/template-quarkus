package com.rct.infra.persistence.model;

import com.rct.infra.persistence.model.converter.LocalDateTimeConverter;
import com.rct.infra.persistence.model.converter.UUIDConverter;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbConvertedBy;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import module java.base;

@Setter
public class AuditableEntity {

    private UUID id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @DynamoDbAttribute(value = "Id")
    @DynamoDbConvertedBy(UUIDConverter.class)
    @DynamoDbPartitionKey
    private UUID getId(){
        return id;
    }

    @DynamoDbAttribute(value = "CreatedAt")
    @DynamoDbConvertedBy(LocalDateTimeConverter.class)
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @DynamoDbAttribute(value = "UpdatedAt")
    @DynamoDbConvertedBy(LocalDateTimeConverter.class)
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

}
