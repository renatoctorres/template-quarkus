package com.rct.infra.config;

import lombok.RequiredArgsConstructor;
import software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@RequiredArgsConstructor
public class DynamoDBConfig {
    public static DynamoDbEnhancedClient createEnhancedClient() {
        DynamoDbClient client = DynamoDbClient.builder()
                .region(Region.of("sa-east-1"))
                .credentialsProvider(EnvironmentVariableCredentialsProvider.create())
                .build();
        return DynamoDbEnhancedClient.builder()
                .dynamoDbClient(client)
                .build();
    }

}
