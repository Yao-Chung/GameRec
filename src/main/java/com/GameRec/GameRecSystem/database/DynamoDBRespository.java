package com.GameRec.GameRecSystem.database;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.QueryResultPage;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpServerErrorException;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class DynamoDBRespository {
    @Resource(name="dynamoDBMapper")
    DynamoDBMapper dbMapper;

    public List<Messages> getInformation() {
        Regions region = Regions.US_EAST_1;
        List<Messages> datas= new ArrayList<>();
        QueryResultPage<Messages> itemList;

        Map<String, String> expressionAttributeNames = new HashMap<>();
        expressionAttributeNames.put("#userId", "userId");
        Map<String, AttributeValue> expressionAttributeValues = new HashMap<>();
        expressionAttributeValues.put(":userId", new AttributeValue().withS("1"));

        DynamoDBQueryExpression<Messages> retrieveQuery = new DynamoDBQueryExpression<Messages>()
                .withKeyConditionExpression("#userId=:userId")
                .withExpressionAttributeNames(expressionAttributeNames)
                .withExpressionAttributeValues(expressionAttributeValues)
                .withScanIndexForward(false);
        try {
            itemList = dbMapper.queryPage(Messages.class, retrieveQuery);
            datas = itemList.getResults();
        } catch (ResourceNotFoundException e) {
            throw e;
        } catch (HttpServerErrorException e) {
            throw e;
        } catch (Exception e) {
            throw e;
        }
        return datas;
    }
}
