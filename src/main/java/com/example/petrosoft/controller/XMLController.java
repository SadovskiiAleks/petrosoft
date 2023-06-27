package com.example.petrosoft.controller;

import com.example.petrosoft.service.XMLService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/")
public class XMLController {

    public final XMLService xmlService;

    public XMLController(XMLService xmlService) {
        this.xmlService = xmlService;
    }

    @PostMapping(value = "xml")
    public ResponseEntity<String> readXML(@RequestBody String xml) {
        xmlService.readXML(xml);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}




