package com.example.pocio.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;

public class Json {

    private static ObjectMapper objectMapper = getDefaultObjectMapper();

    private static ObjectMapper getDefaultObjectMapper(){
        return new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static JsonNode parse(String source) throws IOException {

        return objectMapper.readTree(source);
    }

    public static <A> A fromJson(JsonNode node, Class<A> clazz) throws JsonProcessingException {
        return objectMapper.treeToValue(node,clazz);
    }

    public static JsonNode toJson(Object obj){
        return objectMapper.valueToTree(obj);
    }

    public static String stringify(JsonNode node) throws JsonProcessingException {
        ObjectWriter ow = objectMapper.writer();
        return ow.writeValueAsString(node);
    }

    public static String prettyPrint(JsonNode node) throws JsonProcessingException {
        ObjectWriter ow = objectMapper.writer();
        ow = ow.with(SerializationFeature.INDENT_OUTPUT);
        return ow.writeValueAsString(node);
    }

}
