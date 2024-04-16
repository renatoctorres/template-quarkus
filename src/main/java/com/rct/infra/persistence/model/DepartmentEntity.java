package com.rct.infra.persistence.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.rct.infra.persistence.model.converter.UUIDConverter;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

import java.util.UUID;

@Setter
@DynamoDbBean
public class DepartmentEntity extends AuditableEntity {

    private UUID locationId;
    private UUID managerId;
    private String description;
    private String name;

    @DynamoDBAttribute(attributeName = "ManagerId")
    @DynamoDBTypeConverted(converter = UUIDConverter.class)
    public UUID getManagerId() {
        return managerId;
    }

    @DynamoDBAttribute(attributeName = "LocationId")
    @DynamoDBTypeConverted(converter = UUIDConverter.class)
    public UUID getLocationId() {
        return locationId;
    }

    @DynamoDBAttribute(attributeName = "Description")
    public String getDescription() {
        return description;
    }

    @DynamoDBAttribute(attributeName = "Name")
    public String getName() {
        return name;
    }

}
