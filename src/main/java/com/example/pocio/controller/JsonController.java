package com.example.pocio.controller;

import com.example.pocio.dto.PersonDTO;
import com.example.pocio.dto.TextDTO;
import com.example.pocio.service.IOService;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/io")
public class JsonController {

    @Autowired
    private IOService service;

    @GetMapping("/buffer/read")
    public ResponseEntity<TextDTO> readFile() throws IOException {
        return ResponseEntity.ok(this.service.readFile());
    }

    @PostMapping("/buffer/write")
    public void writeFile(@RequestBody @Valid TextDTO request) throws IOException {
        this.service.writeFile(request);
    }

    @GetMapping("/object/read")
    public ResponseEntity<PersonDTO> readObject() throws IOException {
        return ResponseEntity.ok(this.service.readPerson());
    }

    @PostMapping("/object/write")
    public void writeObject(@RequestBody @Valid PersonDTO request) throws IOException {
        this.service.writePerson(request);
    }

    @GetMapping("/json/read")
    public ResponseEntity<List<PersonDTO>> readJson() throws FileNotFoundException, ParseException {
        return ResponseEntity.ok(this.service.readJson());
    }

    @PostMapping("/json/write")
    public void writeJson(@RequestBody @Valid PersonDTO request) throws IOException {
        this.service.writeJson(request);
    }

    @GetMapping("/jackson/read")
    public ResponseEntity<List<PersonDTO>> readJackson() throws IOException {
        return ResponseEntity.ok(this.service.readJackson());
    }

    @PostMapping("/jackson/write")
    public void writeJackson(@RequestBody @Valid PersonDTO request) throws IOException {
        this.service.writeJackson(request);
    }
}
