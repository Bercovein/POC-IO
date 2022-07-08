package com.example.pocio.service.impl;

import com.example.pocio.dto.TextDTO;
import com.example.pocio.utils.Json;
import com.fasterxml.jackson.databind.JsonNode;

public class JsonServiceImpl {

    public void readJson(TextDTO textDTO){
        try{
            JsonNode node = Json.parse(textDTO.getText());

            System.out.println(node.get("title").asText());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
