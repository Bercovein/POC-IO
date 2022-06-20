package com.example.POCIO.service;

import com.example.POCIO.dto.TextDTO;

import java.io.IOException;

public interface IOService {
    TextDTO readFile() throws IOException;

    void writeFile(TextDTO request) throws IOException;
}
