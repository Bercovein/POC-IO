package com.example.pocio.service;

import com.example.pocio.dto.PersonDTO;
import com.example.pocio.dto.TextDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.apache.tomcat.util.json.ParseException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface IOService {
    TextDTO readFile() throws IOException;

    void writeFile(TextDTO request) throws IOException;

    void writePerson(PersonDTO person);

    PersonDTO readPerson();

    List<PersonDTO> readJson() throws FileNotFoundException, ParseException;

    void writeJson(PersonDTO person) throws IOException;

    void writeJackson(PersonDTO personDTO) throws IOException;

    List<PersonDTO> readJackson() throws IOException;
}
