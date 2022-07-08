package com.example.pocio.service;

import com.example.pocio.dto.PersonDTO;
import com.example.pocio.dto.TextDTO;
import org.apache.tomcat.util.json.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface IJsonService {

    void readJson(TextDTO textDTO);

    void fromJson(TextDTO textDTO) throws IOException;
}
