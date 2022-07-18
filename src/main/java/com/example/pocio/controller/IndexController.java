package com.example.pocio.controller;

import com.example.pocio.dto.TextDTO;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/device")
public class IndexController {

    @GetMapping("/")
    public String greeting(Device device) {

        String deviceType;


        if (device.isNormal()) {
            deviceType = "Desktop";
        } else if (device.isMobile() || device.isTablet()) {
            deviceType = "Mobile";
        } else {
            deviceType = "UNKNOWN";
        }

        return deviceType;
    }

    @GetMapping("/agent")
    public String agent(@RequestHeader(value = "User-Agent") String userAgent) throws IOException {
        return userAgent;
    }
}