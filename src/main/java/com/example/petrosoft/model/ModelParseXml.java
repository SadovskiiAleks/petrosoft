package com.example.petrosoft.model;


public class ModelParseXml {
    private String name;
    private String body;

    public ModelParseXml(String nameOfXML, String xml) {
        this.name = nameOfXML;
        this.body = xml;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBdy() {
        return body;
    }

    public void setBdy(String body) {
        this.body = body;
    }
}
