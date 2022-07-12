package com.example.pocio.service.impl;

import com.example.pocio.dto.PersonDTO;
import com.example.pocio.dto.TextDTO;
import com.example.pocio.service.IJsonService;
import com.example.pocio.utils.Json;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class JsonServiceImpl implements IJsonService {

    @Override
    public void readJson(TextDTO textDTO){
        try{
            JsonNode node = Json.parse(textDTO.getText());

            System.out.println("Name:" + node.get("name").asText());
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void fromJson(TextDTO textDTO) throws IOException {
        JsonNode node = Json.parse(textDTO.getText());

        PersonDTO person = Json.fromJson(node,PersonDTO.class);

        System.out.println("Person:" + person.toString());
    }

}
