package com.rct.core.service.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Employee {
    private String id;
    private String departmentId;
    private String managerId;
    private String jobId;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String salary;
    private String commission;
    private String birthDate;
    private String hireDate;
    private String createdAt;
    private String updatedAt;
}
