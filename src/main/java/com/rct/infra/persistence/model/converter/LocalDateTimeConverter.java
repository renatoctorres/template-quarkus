package com.rct.infra.persistence.model.converter;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeConverter implements DynamoDBTypeConverter<String, LocalDateTime> {
    @Override
    public String convert(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }

    @Override
    public LocalDateTime unconvert(String value) {
        return LocalDateTime.parse(value);
    }
}
