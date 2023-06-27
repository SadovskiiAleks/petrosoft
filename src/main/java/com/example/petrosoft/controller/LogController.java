package com.example.petrosoft.controller;

import com.example.petrosoft.model.ModelParseXml;
import com.example.petrosoft.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/")
public class LogController {

    private final LogService logService;

    @Autowired
    public LogController(LogService logService) {
        this.logService = logService;
    }

    @PostMapping(value = "postJson")
    public ResponseEntity<?> logGson(@RequestBody ModelParseXml jsonXml){
        logService.log(jsonXml);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
