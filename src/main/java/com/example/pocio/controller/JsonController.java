package com.example.pocio.controller;

import com.example.pocio.dto.TextDTO;
import com.example.pocio.service.IJsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/json")
public class JsonController {

    @Autowired
    private IJsonService service;

    @PostMapping("/read")
    public void readJackson(@RequestBody TextDTO request) throws IOException {
        this.service.readJson(request);
    }

    @PostMapping("/fromJson")
    public void writeJackson(@RequestBody TextDTO request) throws IOException {
        this.service.fromJson(request);
    }
}
