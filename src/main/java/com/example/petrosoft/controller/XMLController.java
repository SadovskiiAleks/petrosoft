package com.example.petrosoft.controller;

import com.example.petrosoft.service.XMLService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.net.URI;

import static org.springframework.http.MediaType.APPLICATION_XML_VALUE;

@Controller
public class XMLController {
    private final XMLService xmlService;

    @Autowired
    public XMLController(XMLService xmlService) {
        this.xmlService = xmlService;
    }


    @PostMapping(value = "/", produces = APPLICATION_XML_VALUE, consumes = APPLICATION_XML_VALUE)
    public ResponseEntity<String> readXML(HttpServletRequest request) throws IOException, InterruptedException {

        xmlService.readXML(request);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create("http://localhost:4040/postJson"))
                .build();

    }

}




