package com.rct.infra.persistence.model.converter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

public class DoubleConverter implements DynamoDBTypeConverter<String, Double> {

    @Override
    public String convert(Double object) {
        return object.toString();
    }

    @Override
    public Double unconvert(String object) {
        return Double.parseDouble(object);
    }
}