package com.rct.infra.persistence.model.converter;

import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import module java.base;

public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime> {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    @Override
    public AttributeValue transformFrom(LocalDateTime input) {
        if (input == null) {
            return AttributeValue.fromNul(true);
        }
        return AttributeValue.fromS(FORMATTER.format(input));
    }

    @Override
    public LocalDateTime transformTo(AttributeValue attributeValue) {
        if (attributeValue.s() == null || attributeValue.s().isEmpty()) {
            return null;
        }
        return LocalDateTime.parse(attributeValue.s(), FORMATTER);
    }

    @Override
    public EnhancedType<LocalDateTime> type() {
        return  EnhancedType.of(LocalDateTime.class);
    }

    @Override
    public AttributeValueType attributeValueType() {
        return AttributeValueType.S;
    }

}
