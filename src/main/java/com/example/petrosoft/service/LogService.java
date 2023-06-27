package com.example.petrosoft.service;

import com.example.petrosoft.model.ModelParseXml;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;

@Service
public class LogService {

    public void log(ModelParseXml jsonXml) {

        try (FileWriter writer = new FileWriter("A:\\Program\\petrosoft\\petrosoft\\Log\\log.txt", true)) {
            writer.write("\n" + "\n");
            writer.write(jsonXml.getBdy());
            writer.flush();
        } catch (IOException e) {
        }
    }
}
