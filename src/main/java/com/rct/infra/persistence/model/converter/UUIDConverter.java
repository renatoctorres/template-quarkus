package com.rct.infra.persistence.model.converter;

import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

import java.util.UUID;

public class UUIDConverter implements AttributeConverter<UUID> {

    @Override
    public AttributeValue transformFrom(UUID input) {
        return AttributeValue.fromS(input.toString());
    }

    @Override
    public UUID transformTo(AttributeValue attributeValue) {
        return UUID.fromString(attributeValue.s());
    }

    @Override
    public EnhancedType<UUID> type() {
        return EnhancedType.of(UUID.class);
    }

    @Override
    public AttributeValueType attributeValueType() {
        return AttributeValueType.S;
    }

}