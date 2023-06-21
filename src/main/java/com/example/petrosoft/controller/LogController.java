package com.example.petrosoft.controller;

import com.example.petrosoft.service.LogService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

@Controller
public class LogController {

    private final LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping(value = "/postJson")
    public ResponseEntity<?> logGson(HttpServletRequest request) throws IOException {
        logService.log(request);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
