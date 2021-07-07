package com.GameRec.GameRecSystem.database;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;

import java.io.Serializable;

public class Messages implements Serializable {

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    private static final long serialVersionUID = 2077992697029525233L;

    @DynamoDBHashKey(attributeName = "userId")
    private String userId;
    @DynamoDBHashKey(attributeName = "userName")
    private String userName;
}
