package com.GameRec.GameRecSystem.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DynamodbResource {
    @Autowired
    DynamoDBRespository dbRespository;

    @GetMapping(value="getAllValues")
    public List<Messages> getAllValues() {
        List<Messages> datas = new ArrayList<>();
        datas = dbRespository.getInformation();
        //HAHAHA
        System.out.println("Hello Fork");
        return datas;
    }
}
