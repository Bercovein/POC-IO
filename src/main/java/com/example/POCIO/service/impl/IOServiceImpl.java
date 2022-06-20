package com.example.POCIO.service.impl;


import com.example.POCIO.dto.TextDTO;
import com.example.POCIO.service.IOService;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class IOServiceImpl implements IOService {

    private final static String FILES_PATH="files/";

    @Override
    public TextDTO readFile() throws IOException {

        TextDTO response = TextDTO.builder().build();
        BufferedReader reader = null;
        String toResponse = "";
        String strng;

        try {
            File file = new File(FILES_PATH.concat("myFile.txt"));
            reader = new BufferedReader(new FileReader(file));

            while ((strng = reader.readLine()) != null) {
                toResponse = toResponse.concat(strng);
            }
            response.setText(toResponse);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(reader != null)
                reader.close();

        }
        return response;
    }

    @Override
    public void writeFile(TextDTO request) throws IOException {

        BufferedWriter writer = null;

        try {
            File file = new File(FILES_PATH.concat("myFile.txt"));

            writer = new BufferedWriter(new FileWriter(file,true));
            writer.newLine();
            writer.write(request.getText());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null)
                writer.close();
        }
    }
}
