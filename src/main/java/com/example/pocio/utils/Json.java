package com.example.pocio.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Json {

    private static ObjectMapper objectMapper = getDefaultObjectMapper();

    private static ObjectMapper getDefaultObjectMapper(){
        return new ObjectMapper();
    }

    public static JsonNode parse(String source) throws IOException {

        return objectMapper.readTree(source);
    }

    public static <A> A fromJson(JsonNode node, Class<A> clazz) throws JsonProcessingException {
        return objectMapper.treeToValue(node,clazz);
    }
}