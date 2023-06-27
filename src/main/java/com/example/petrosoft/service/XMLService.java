package com.example.petrosoft.service;

import com.example.petrosoft.controller.LogController;
import com.example.petrosoft.model.ModelParseXml;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class XMLService {
    final private String nameOfXML = "xml";
    LogController logController;

    public XMLService(LogController logController) {
        this.logController = logController;
    }

    public void readXML(String xml)  {
        ModelParseXml jsonXml = new ModelParseXml(nameOfXML, xml);
        logController.logGson(jsonXml);
    }
}
