package com.example.pocio.service.impl;


import com.example.pocio.dto.PersonDTO;
import com.example.pocio.dto.TextDTO;
import com.example.pocio.service.IOService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.file.Paths;
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
    public List<PersonDTO> readJson()  {

        List<PersonDTO> response = new ArrayList<>();

        JSONArray list = this.readJSONArray(MY_PERSONS_PATH);

        try {
            list.forEach(per -> response.add(parsePerson((JSONObject) per)));
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    private JSONArray readJSONArray(String path) {
        JSONArray response = new JSONArray();

        try {
            JSONParser jsonParser = new JSONParser();
            response = (JSONArray) jsonParser.parse(new FileReader(path));
        }catch (Exception e){
            e.printStackTrace();
        }
        return response;
    }

    private static PersonDTO parsePerson(JSONObject person)
    {
        return PersonDTO.builder()
                .name((String)person.get("name"))
                .lastName((String)person.get("lastName"))
                .age(Integer.parseInt(person.get("age").toString()))
                .build();
    }

    @Override
    public void writeJson(PersonDTO person) {

        JSONObject obj = new JSONObject();

        obj.put("name", person.getName());
        obj.put("age", person.getAge());
        obj.put("lastName", person.getLastName());

        JSONArray list = this.readJSONArray(MY_PERSONS_PATH);
        list.add(obj);

        try (FileWriter file = new FileWriter(MY_PERSONS_PATH)) {
            file.write(String.valueOf(list));
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void writeJackson(PersonDTO personDTO) throws IOException {

        try {
            List<PersonDTO> list = this.readJackson();

            list.add(personDTO);

            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(Paths.get(MY_PERSONS_PATH).toFile(), list);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<PersonDTO> readJackson() {

        List<PersonDTO> response = new ArrayList<>();

        try {
            ObjectMapper mapper = new ObjectMapper();

            response = mapper.readValue(Paths.get(MY_PERSONS_PATH).toFile(), ArrayList.class);

        }catch (Exception e){
            e.printStackTrace();
        }
       return response;

    }
}
