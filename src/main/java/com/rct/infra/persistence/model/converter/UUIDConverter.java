package com.rct.infra.persistence.model.converter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import java.util.UUID;

public class UUIDConverter implements DynamoDBTypeConverter<String, UUID> {

    @Override
    public String convert(UUID object) {
        return object.toString();
    }

    @Override
    public UUID unconvert(String object) {
        return UUID.fromString(object);
    }
}