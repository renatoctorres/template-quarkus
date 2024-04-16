package com.rct.infra.persistence.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.rct.infra.persistence.model.converter.DoubleConverter;
import com.rct.infra.persistence.model.converter.LocalDateTimeConverter;
import com.rct.infra.persistence.model.converter.UUIDConverter;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

import java.time.LocalDateTime;
import java.util.UUID;


@Setter
//@AllArgsConstructor
//@NoArgsConstructor(access = PROTECTED)
//@DynamoDBTable(tableName="EmployeeEntity")
@DynamoDbBean
public class EmployeeEntity extends AuditableEntity {

    private UUID departmentId;
    private UUID managerId;
    private UUID jobId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Double salary;
    private Double commission;
    private LocalDateTime birthDate;
    private LocalDateTime hireDate;

    @DynamoDBAttribute(attributeName = "DepartmentId")
    @DynamoDBTypeConverted(converter = UUIDConverter.class)
    public UUID getDepartmentId() {
        return departmentId;
    }

    @DynamoDBAttribute(attributeName = "ManagerId")
    @DynamoDBTypeConverted(converter = UUIDConverter.class)
    public UUID getManagerId() {
        return managerId;
    }

    @DynamoDBAttribute(attributeName = "JobId")
    @DynamoDBTypeConverted(converter = UUIDConverter.class)
    public UUID getJobId() {
        return jobId;
    }

    @DynamoDBAttribute(attributeName = "FirstName")
    public String getFirstName() {
        return firstName;
    }

    @DynamoDBAttribute(attributeName = "LastName")
    public String getLastName() {
        return lastName;
    }

    @DynamoDBAttribute(attributeName = "E-mail")
    public String getEmail() {
        return email;
    }

    @DynamoDBAttribute(attributeName = "PhoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @DynamoDBTypeConverted(converter = DoubleConverter.class)
    @DynamoDBAttribute(attributeName = "Salary")
    public Double getSalary() {
        return salary;
    }

    @DynamoDBTypeConverted(converter = DoubleConverter.class)
    @DynamoDBAttribute(attributeName = "Commission")
    public Double getCommission() {
        return commission;
    }

    @DynamoDBTypeConverted(converter = LocalDateTimeConverter.class)
    @DynamoDBAttribute(attributeName = "BirthDate")
    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    @DynamoDBTypeConverted(converter = LocalDateTimeConverter.class)
    @DynamoDBAttribute(attributeName = "HireDate")
    public LocalDateTime getHireDate() {
        return hireDate;
    }

}
