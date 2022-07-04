package com.example.pocio.service.impl;


import com.example.pocio.dto.PersonDTO;
import com.example.pocio.dto.TextDTO;
import com.example.pocio.service.IOService;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
@Service
public class IOServiceImpl implements IOService {

    private static final String FILES_PATH="files/";

    private static final String PERSONS_PATH = FILES_PATH.concat("Persons.txt");

    private static final String MY_FILE_PATH = FILES_PATH.concat("myFile.txt");

    private static final String MY_PERSONS_PATH = FILES_PATH.concat("myPersons.txt");

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

    @Override
    public List<PersonDTO> readJson(){

        List<PersonDTO> response = new ArrayList<>();

        try {
            JSONParser parser = new JSONParser(new FileReader(MY_PERSONS_PATH));

            JSONArray a = (JSONArray) parser.parse();

            for (Object o : a)
            {
                JSONObject person = (JSONObject) o;

                response.add(PersonDTO.builder()
                        .age((int) person.get("age"))
                        .name((String) person.get("name"))
                        .lastName((String) person.get("lastName"))
                        .build());
            }
        } catch (FileNotFoundException | ParseException e) {
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public void writeJson(PersonDTO person) throws IOException {

        FileWriter file = new FileWriter(MY_PERSONS_PATH);

        JSONObject obj = new JSONObject();

        obj.put("name", person.getName());
        obj.put("age", person.getAge());
        obj.put("lastName", person.getLastName());

        file.write(String.valueOf(obj));

        file.close();
    }
}
