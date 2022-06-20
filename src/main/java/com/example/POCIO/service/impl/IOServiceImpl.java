package com.example.POCIO.service.impl;


import com.example.POCIO.dto.PersonDTO;
import com.example.POCIO.dto.TextDTO;
import com.example.POCIO.service.IOService;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class IOServiceImpl implements IOService {

    private final static String FILES_PATH="files/";

    private final static String PERSONS_PATH = FILES_PATH.concat("Persons.txt");

    private final static String MY_FILE_PATH = FILES_PATH.concat("myFile.txt");

    @Override
    public TextDTO readFile() throws IOException {

        TextDTO response = TextDTO.builder().build();
        BufferedReader reader = null;
        String toResponse = "";
        String str;

        try {
            File file = new File(MY_FILE_PATH);
            reader = new BufferedReader(new FileReader(file));

            while ((str = reader.readLine()) != null) { //line oriented
                toResponse = toResponse.concat(str);
            }
            response.setText(toResponse);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(reader != null) {
                reader.close();
            }
        }
        return response;
    }

    @Override
    public void writeFile(TextDTO request) throws IOException {

        BufferedWriter writer = null;

        try {
            File file = new File(MY_FILE_PATH);

            writer = new BufferedWriter(new FileWriter(file,true));
            writer.newLine();
            writer.write(request.getText());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }
    }

    @Override
    public void writePerson(PersonDTO person){

        try{
            FileOutputStream fileOutputStream
                    = new FileOutputStream(PERSONS_PATH);
            ObjectOutputStream objectOutputStream
                    = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(person); //object oriented
            objectOutputStream.flush();
            objectOutputStream.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public PersonDTO readPerson(){

        PersonDTO person = null;

        try{
            FileInputStream fileInputStream
                    = new FileInputStream(PERSONS_PATH);
            ObjectInputStream objectInputStream
                    = new ObjectInputStream(fileInputStream);
            person = (PersonDTO) objectInputStream.readObject();
            objectInputStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        return person;
    }
}
