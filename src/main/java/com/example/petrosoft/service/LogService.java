package com.example.petrosoft.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class LogService {

    public void log(HttpServletRequest request) {

        try (FileWriter writer = new FileWriter("A:\\Program\\petrosoft\\petrosoft\\Log\\log.txt", true)) {
            BufferedReader reader = request.getReader();
            int intValueOfChar;
            StringBuilder result = new StringBuilder();

            while ((intValueOfChar = reader.read()) != -1) {
                result.append((char) intValueOfChar);
            }
            writer.write("\n" + "\n");
            writer.write(result.toString());
            writer.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
