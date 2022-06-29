package com.example.pocio.service;

import com.example.pocio.dto.PersonDTO;
import com.example.pocio.dto.TextDTO;

import java.io.IOException;

public interface IOService {
    TextDTO readFile() throws IOException;

    void writeFile(TextDTO request) throws IOException;

    void writePerson(PersonDTO person);

    PersonDTO readPerson();
}
