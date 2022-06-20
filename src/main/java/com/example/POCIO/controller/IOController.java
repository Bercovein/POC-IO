package com.example.POCIO.controller;

import com.example.POCIO.dto.PersonDTO;
import com.example.POCIO.dto.TextDTO;
import com.example.POCIO.service.IOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;

@RestController
@RequestMapping("/io")
public class IOController {

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

}
