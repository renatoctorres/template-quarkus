package com.rct.infra.persistence.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.rct.infra.persistence.model.converter.LocalDateTimeConverter;
import com.rct.infra.persistence.model.converter.UUIDConverter;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
public class AuditableEntity {

    private UUID id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @DynamoDBAttribute(attributeName = "Id")
    @DynamoDBTypeConverted(converter = UUIDConverter.class)
    @DynamoDbPartitionKey
    private UUID getId(){
        return id;
    }

    @DynamoDBAttribute(attributeName = "CreatedAt")
    @DynamoDBTypeConverted(converter = LocalDateTimeConverter.class)
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @DynamoDBAttribute(attributeName = "UpdatedAt")
    @DynamoDBTypeConverted(converter = LocalDateTimeConverter.class)
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

}
