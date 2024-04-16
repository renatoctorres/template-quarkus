package com.rct.infra.persistence.model;

import com.rct.infra.persistence.model.converter.DoubleConverter;
import com.rct.infra.persistence.model.converter.LocalDateTimeConverter;
import com.rct.infra.persistence.model.converter.UUIDConverter;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbConvertedBy;

import module java.base;


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

    @DynamoDbAttribute(value = "DepartmentId")
    @DynamoDbConvertedBy(UUIDConverter.class)
    public UUID getDepartmentId() {
        return departmentId;
    }

    @DynamoDbAttribute(value = "ManagerId")
    @DynamoDbConvertedBy(UUIDConverter.class)
    public UUID getManagerId() {
        return managerId;
    }

    @DynamoDbAttribute(value = "JobId")
    @DynamoDbConvertedBy(UUIDConverter.class)
    public UUID getJobId() {
        return jobId;
    }

    @DynamoDbAttribute(value = "FirstName")
    public String getFirstName() {
        return firstName;
    }

    @DynamoDbAttribute(value = "LastName")
    public String getLastName() {
        return lastName;
    }

    @DynamoDbAttribute(value = "E-mail")
    public String getEmail() {
        return email;
    }

    @DynamoDbAttribute(value = "PhoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @DynamoDbConvertedBy(DoubleConverter.class)
    @DynamoDbAttribute(value = "Salary")
    public Double getSalary() {
        return salary;
    }

    @DynamoDbConvertedBy(DoubleConverter.class)
    @DynamoDbAttribute(value = "Commission")
    public Double getCommission() {
        return commission;
    }

    @DynamoDbConvertedBy(LocalDateTimeConverter.class)
    @DynamoDbAttribute(value = "BirthDate")
    public LocalDateTime getBirthDate() {
        return birthDate;
    }

    @DynamoDbConvertedBy(LocalDateTimeConverter.class)
    @DynamoDbAttribute(value = "HireDate")
    public LocalDateTime getHireDate() {
        return hireDate;
    }

}
