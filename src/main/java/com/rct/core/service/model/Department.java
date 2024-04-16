package com.rct.core.service.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Department {
    private String locationId;
    private String managerId;
    private String description;
    private String name;
    private String id;
    private String createdAt;
    private String updatedAt;
}
