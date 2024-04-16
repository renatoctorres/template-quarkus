package com.rct.infra.persistence.model;

import com.rct.infra.persistence.model.converter.UUIDConverter;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbConvertedBy;
import java.util.UUID;

@Setter
@DynamoDbBean
public class DepartmentEntity extends AuditableEntity {

    private UUID locationId;
    private UUID managerId;
    private String description;
    private String name;

    @DynamoDbAttribute(value = "ManagerId")
    @DynamoDbConvertedBy(UUIDConverter.class)
    public UUID getManagerId() {
        return managerId;
    }

    @DynamoDbAttribute(value = "LocationId")
    @DynamoDbConvertedBy(UUIDConverter.class)
    public UUID getLocationId() {
        return locationId;
    }

    @DynamoDbAttribute(value = "Description")
    public String getDescription() {
        return description;
    }

    @DynamoDbAttribute(value = "Name")
    public String getName() {
        return name;
    }

}
