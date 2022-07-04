package com.example.pocio.service;

import com.example.pocio.dto.PersonDTO;
import com.example.pocio.dto.TextDTO;

import java.io.IOException;
import java.util.List;

public interface IOService {
    TextDTO readFile() throws IOException;

    void writeFile(TextDTO request) throws IOException;

    void writePerson(PersonDTO person);

    PersonDTO readPerson();

    List<PersonDTO> readJson();

    void writeJson(PersonDTO person) throws IOException;
}
