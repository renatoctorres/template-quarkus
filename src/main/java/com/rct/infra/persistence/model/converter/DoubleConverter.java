package com.rct.infra.persistence.model.converter;

import software.amazon.awssdk.enhanced.dynamodb.AttributeConverter;
import software.amazon.awssdk.enhanced.dynamodb.AttributeValueType;
import software.amazon.awssdk.enhanced.dynamodb.EnhancedType;
import software.amazon.awssdk.services.dynamodb.model.AttributeValue;

public class DoubleConverter implements AttributeConverter<Double> {

    @Override
    public AttributeValue transformFrom(Double input) {
        if (input == null) return AttributeValue.fromN("0");
        return AttributeValue.fromN(Double.toString(input));
    }

    @Override
    public Double transformTo(AttributeValue attributeValue) {
        if (attributeValue.n() == null || attributeValue.n().isEmpty()) return 0.0;
        return Double.parseDouble(attributeValue.n());
    }

    @Override
    public EnhancedType<Double> type() {
        return EnhancedType.of(Double.class);
    }

    @Override
    public AttributeValueType attributeValueType() {
        return AttributeValueType.N;
    }

}