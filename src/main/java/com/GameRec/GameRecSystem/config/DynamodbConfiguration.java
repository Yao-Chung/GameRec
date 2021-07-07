package com.GameRec.GameRecSystem.config;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamodbConfiguration {
    private static final DynamoDBMapperConfig.TableNameResolver TABLE_NAME_RESOLVER=(clasName, config)->"UserProfile";
            ClientConfiguration getClientCofiguration() {
                ClientConfiguration cfg = new ClientConfiguration();
                cfg.setProtocol(Protocol.HTTP);
                cfg.setProxyPort(8099);
            return cfg;
            }
    @Bean(name="dynamoDBMapper")
    public DynamoDBMapper dynamoDBMapperLocal() {
        Regions region = Regions.US_EAST_1;
        DynamoDBMapperConfig dbMapperConfig = new DynamoDBMapperConfig.Builder()
                .withTableNameResolver(TABLE_NAME_RESOLVER)
                .build();
        BasicAWSCredentials awsCreds = new BasicAWSCredentials("accessKey","secretKey");
        AmazonDynamoDBClient dynamoDBClient = (AmazonDynamoDBClient) AmazonDynamoDBClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .withRegion(region)
                .build();
        return new DynamoDBMapper(dynamoDBClient, dbMapperConfig);
    }

}
